package edu.galileo.android.androidtwitterclient.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Created by nacheteam on 14/06/16.
 */
public class CustomTwitterApiClient extends TwitterApiClient {

    public CustomTwitterApiClient(Session session)
    {
        super(session);
    }

    public TimelineService  getTimelineService()
    {
        return getService(TimelineService.class);
    }



}
