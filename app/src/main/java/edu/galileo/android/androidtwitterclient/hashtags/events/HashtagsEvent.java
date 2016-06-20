package edu.galileo.android.androidtwitterclient.hashtags.events;

import java.util.List;

import edu.galileo.android.androidtwitterclient.entities.Hashtag;

/**
 * Created by nacheteam on 19/06/16.
 */
public class HashtagsEvent {

    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
