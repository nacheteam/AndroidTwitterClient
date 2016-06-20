package edu.galileo.android.androidtwitterclient.images;

import edu.galileo.android.androidtwitterclient.images.events.ImagesEvent;

/**
 * Created by nacheteam on 17/06/16.
 */
public interface ImagesPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);

}
