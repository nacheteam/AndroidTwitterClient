package edu.galileo.android.androidtwitterclient.hashtags.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.androidtwitterclient.hashtags.HashtagsPresenter;
import edu.galileo.android.androidtwitterclient.hashtags.ui.HashtagsFragment;
import edu.galileo.android.androidtwitterclient.lib.di.LibsModule;

/**
 * Created by nacheteam on 19/06/16.
 */
@Singleton @Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {

    void inject(HashtagsFragment fragment);
    HashtagsPresenter getPresenter();

}
