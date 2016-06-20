package edu.galileo.android.androidtwitterclient.hashtags;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidtwitterclient.hashtags.events.HashtagsEvent;
import edu.galileo.android.androidtwitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.androidtwitterclient.images.ImagesInteractor;
import edu.galileo.android.androidtwitterclient.images.events.ImagesEvent;
import edu.galileo.android.androidtwitterclient.images.ui.ImagesView;
import edu.galileo.android.androidtwitterclient.lib.base.EventBus;

/**
 * Created by nacheteam on 19/06/16.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private EventBus eventBus;
    private HashtagsView view;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor) {
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
    public void getHashtagsTweets() {
        if(view != null)
        {
            view.hideHashtags();
            view.showProgress();
        }
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if(view != null)
        {
            view.showHashtags();
            view.hideProgress();
            if(errorMsg!=null)
            {
                view.onError(errorMsg);
            }
            else
            {
                view.setContent(event.getHashtags());
            }
        }
    }
}
