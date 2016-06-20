package edu.galileo.android.androidtwitterclient.hashtags;

import edu.galileo.android.androidtwitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by nacheteam on 19/06/16.
 */
public interface HashtagsPresenter {

    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagsTweets();
    void onEventMainThread(HashtagsEvent event);

}
