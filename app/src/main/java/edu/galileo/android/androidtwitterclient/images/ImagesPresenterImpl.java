package edu.galileo.android.androidtwitterclient.images;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidtwitterclient.images.events.ImagesEvent;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesView;
import edu.galileo.android.androidtwitterclient.lib.base.EventBus;

/**
 * Created by nacheteam on 17/06/16.
 */
public class ImagesPresenterImpl implements ImagesPresenter {

    private EventBus eventBus;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(EventBus eventBus, ImagesView view, ImagesInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view=null;
    }

    @Override
    public void getImageTweets() {
        if(view != null)
        {
            view.hideImages();
            view.showProgress();
        }
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String errorMsg = event.getError();
        if(view != null)
        {
            view.showImages();
            view.hideProgress();
            if(errorMsg!=null)
            {
                view.onError(errorMsg);
            }
            else
            {
                view.setContent(event.getImages());
            }
        }
    }
}
