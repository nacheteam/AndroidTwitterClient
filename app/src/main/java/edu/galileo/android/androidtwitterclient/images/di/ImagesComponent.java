package edu.galileo.android.androidtwitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.androidtwitterclient.images.ImagesPresenter;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesFragment;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule;

/**
 * Created by nacheteam on 17/06/16.
 */
@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {

    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();

}
