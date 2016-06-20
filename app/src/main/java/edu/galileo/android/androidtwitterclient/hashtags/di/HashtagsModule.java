package edu.galileo.android.androidtwitterclient.hashtags.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Provides;
import edu.galileo.android.androidtwitterclient.api.CustomTwitterApiClient;
import edu.galileo.android.androidtwitterclient.entities.Hashtag;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsInteractor;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsInteractorImpl;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsPresenter;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsPresenterImpl;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsRepository;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsRepositoryImpl;
import edu.galileo.android.androidtwitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.androidtwitterclient.hashtags.ui.adapters.HashtagsAdapter;
import edu.galileo.android.androidtwitterclient.hashtags.ui.adapters.OnItemClickListener;
import edu.galileo.android.androidtwitterclient.lib.base.EventBus;

/**
 * Created by nacheteam on 19/06/16.
 */
public class HashtagsModule {

    private HashtagsView view;
    private OnItemClickListener clickListener;


    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener)
    {
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener()
    {
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemList()
    {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagsPresenter providesImagePresenter(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor)
    {
        return new HashtagsPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesImageView()
    {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesImagesInteractor(HashtagsRepository repository)
    {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client)
    {
        return new HashtagsRepositoryImpl(eventBus, client);
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
