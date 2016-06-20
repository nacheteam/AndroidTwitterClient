package edu.galileo.android.androidtwitterclient.images.ui;

import java.util.List;

import edu.galileo.android.androidtwitterclient.entities.Image;

/**
 * Created by nacheteam on 17/06/16.
 */
public interface ImagesView {

    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);

}
