package edu.galileo.android.androidtwitterclient.images.di;

import android.content.pm.PackageInstaller;
import android.widget.ImageView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.TwitterApi;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.androidtwitterclient.api.CustomTwitterApiClient;
import edu.galileo.android.androidtwitterclient.entities.Image;
import edu.galileo.android.androidtwitterclient.images.ImagesInteractor;
import edu.galileo.android.androidtwitterclient.images.ImagesInteractorImpl;
import edu.galileo.android.androidtwitterclient.images.ImagesPresenter;
import edu.galileo.android.androidtwitterclient.images.ImagesPresenterImpl;
import edu.galileo.android.androidtwitterclient.images.ImagesRepository;
import edu.galileo.android.androidtwitterclient.images.ImagesRepositoryImpl;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesView;
import edu.galileo.android.androidtwitterclient.images.ui.adapters.ImagesAdapter;
import edu.galileo.android.androidtwitterclient.images.ui.adapters.OnItemClickListener;
import edu.galileo.android.androidtwitterclient.lib.base.EventBus;
import edu.galileo.android.androidtwitterclient.lib.base.ImageLoader;

/**
 * Created by nacheteam on 17/06/16.
 */
@Module
public class ImagesModule {

    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener)
    {
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener()
    {
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemList()
    {
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagePresenter(EventBus eventBus, ImagesView view, ImagesInteractor interactor)
    {
        return new ImagesPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImageView()
    {
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository)
    {
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client)
    {
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session)
    {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter()
    {
        return Twitter.getSessionManager().getActiveSession();
    }
}
