package edu.galileo.android.androidtwitterclient.hashtags.di;

import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import com.twitter.sdk.android.core.Session;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import edu.galileo.android.androidtwitterclient.api.CustomTwitterApiClient;
import edu.galileo.android.androidtwitterclient.entities.Hashtag;
import edu.galileo.android.androidtwitterclient.images.HashtagsInteractor;
import edu.galileo.android.androidtwitterclient.images.ImagesPresenter;
import edu.galileo.android.androidtwitterclient.images.ImagesRepository;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesFragment;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesFragment_MembersInjector;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesView;
import edu.galileo.android.androidtwitterclient.images.ui.adapters.ImagesAdapter;
import edu.galileo.android.androidtwitterclient.images.ui.adapters.OnItemClickListener;
import edu.galileo.android.androidtwitterclient.lib.base.EventBus;
import edu.galileo.android.androidtwitterclient.lib.base.ImageLoader;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule_ProvidesEventBusFactory;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule_ProvidesFragmentFactory;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule_ProvidesImageLoaderFactory;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule_ProvidesLibraryEventBusFactory;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule_ProvidesRequestManagerFactory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerImagesComponent implements ImagesComponent {
    private Provider<org.greenrobot.eventbus.EventBus> providesLibraryEventBusProvider;
    private Provider<EventBus> providesEventBusProvider;
    private Provider<ImagesView> providesImageViewProvider;
    private Provider<Session> providesTwitterProvider;
    private Provider<CustomTwitterApiClient> providesCustomTwitterApiClientProvider;
    private Provider<ImagesRepository> providesImagesRepositoryProvider;
    private Provider<ImagesInteractor> providesImagesInteractorProvider;
    private Provider<ImagesPresenter> providesImagePresenterProvider;
    private Provider<List<Image>> providesItemListProvider;
    private Provider<Fragment> providesFragmentProvider;
    private Provider<RequestManager> providesRequestManagerProvider;
    private Provider<ImageLoader> providesImageLoaderProvider;
    private Provider<OnItemClickListener> providesOnItemClickListenerProvider;
    private Provider<ImagesAdapter> providesAdapterProvider;
    private MembersInjector<ImagesFragment> imagesFragmentMembersInjector;

    private DaggerImagesComponent(Builder builder) {
        assert builder != null;
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(final Builder builder) {
        this.providesLibraryEventBusProvider = ScopedProvider.create(LibsModule_ProvidesLibraryEventBusFactory.create(builder.libsModule));
        this.providesEventBusProvider = ScopedProvider.create(LibsModule_ProvidesEventBusFactory.create(builder.libsModule, providesLibraryEventBusProvider));
        this.providesImageViewProvider = ScopedProvider.create(ImagesModule_ProvidesImageViewFactory.create(builder.imagesModule));
        this.providesTwitterProvider = ScopedProvider.create(ImagesModule_ProvidesTwitterFactory.create(builder.imagesModule));
        this.providesCustomTwitterApiClientProvider = ScopedProvider.create(ImagesModule_ProvidesCustomTwitterApiClientFactory.create(builder.imagesModule, providesTwitterProvider));
        this.providesImagesRepositoryProvider = ScopedProvider.create(ImagesModule_ProvidesImagesRepositoryFactory.create(builder.imagesModule, providesEventBusProvider, providesCustomTwitterApiClientProvider));
        this.providesImagesInteractorProvider = ScopedProvider.create(ImagesModule_ProvidesImagesInteractorFactory.create(builder.imagesModule, providesImagesRepositoryProvider));
        this.providesImagePresenterProvider = ScopedProvider.create(ImagesModule_ProvidesImagePresenterFactory.create(builder.imagesModule, providesEventBusProvider, providesImageViewProvider, providesImagesInteractorProvider));
        this.providesItemListProvider = ScopedProvider.create(ImagesModule_ProvidesItemListFactory.create(builder.imagesModule));
        this.providesFragmentProvider = ScopedProvider.create(LibsModule_ProvidesFragmentFactory.create(builder.libsModule));
        this.providesRequestManagerProvider = ScopedProvider.create(LibsModule_ProvidesRequestManagerFactory.create(builder.libsModule, providesFragmentProvider));
        this.providesImageLoaderProvider = ScopedProvider.create(LibsModule_ProvidesImageLoaderFactory.create(builder.libsModule, providesRequestManagerProvider));
        this.providesOnItemClickListenerProvider = ScopedProvider.create(ImagesModule_ProvidesOnItemClickListenerFactory.create(builder.imagesModule));
        this.providesAdapterProvider = ScopedProvider.create(ImagesModule_ProvidesAdapterFactory.create(builder.imagesModule, providesItemListProvider, providesImageLoaderProvider, providesOnItemClickListenerProvider));
        this.imagesFragmentMembersInjector = ImagesFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), providesImagePresenterProvider, providesAdapterProvider);
    }

    @Override
    public void inject(ImagesFragment fragment) {
        imagesFragmentMembersInjector.injectMembers(fragment);
    }

    @Override
    public ImagesPresenter getPresenter() {
        return providesImagePresenterProvider.get();
    }

    public static final class Builder {
        private LibsModule libsModule;
        private ImagesModule imagesModule;

        private Builder() {
        }

        public ImagesComponent build() {
            if (libsModule == null) {
                throw new IllegalStateException("libsModule must be set");
            }
            if (imagesModule == null) {
                throw new IllegalStateException("imagesModule must be set");
            }
            return new DaggerImagesComponent(this);
        }

        public Builder libsModule(LibsModule libsModule) {
            if (libsModule == null) {
                throw new NullPointerException("libsModule");
            }
            this.libsModule = libsModule;
            return this;
        }

        public Builder imagesModule(ImagesModule imagesModule) {
            if (imagesModule == null) {
                throw new NullPointerException("imagesModule");
            }
            this.imagesModule = imagesModule;
            return this;
        }
    }
}

