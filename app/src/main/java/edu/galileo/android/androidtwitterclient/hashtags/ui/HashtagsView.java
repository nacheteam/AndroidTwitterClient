package edu.galileo.android.androidtwitterclient.hashtags.ui;

import java.util.List;

import edu.galileo.android.androidtwitterclient.entities.Hashtag;
import edu.galileo.android.androidtwitterclient.entities.Image;

/**
 * Created by nacheteam on 19/06/16.
 */
public interface HashtagsView {

    void showHashtags();
    void hideHashtags();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);

}
