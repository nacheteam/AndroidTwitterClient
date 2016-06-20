package edu.galileo.android.androidtwitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import edu.galileo.android.androidtwitterclient.entities.Hashtag;
import edu.galileo.android.androidtwitterclient.hashtags.di.HashtagsComponent;
import edu.galileo.android.androidtwitterclient.hashtags.di.HashtagsModule;
import edu.galileo.android.androidtwitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.androidtwitterclient.images.di.DaggerImagesComponent;
import edu.galileo.android.androidtwitterclient.images.di.ImagesComponent;
import edu.galileo.android.androidtwitterclient.images.di.ImagesModule;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesView;
import edu.galileo.android.androidtwitterclient.images.ui.adapters.OnItemClickListener;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule;
import io.fabric.sdk.android.Fabric;

/**
 * Created by nacheteam on 14/06/16.
 */
public class TwitterClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener)
    {
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }

    public HashtagsComponent getHashtagsComponent(HashtagsView view, edu.galileo.android.androidtwitterclient.hashtags.ui.adapters.OnItemClickListener clickListener)
    {
        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagsModule(new HashtagsModule(view, clickListener))
                .build();
    }
}
