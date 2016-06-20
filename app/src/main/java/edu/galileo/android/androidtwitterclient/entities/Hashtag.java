package edu.galileo.android.androidtwitterclient.entities;

import java.util.List;

/**
 * Created by nacheteam on 19/06/16.
 */
public class Hashtag {

    private String id;
    private String tweetText;
    private int favouriteCount;
    private List<String> hashtags;
    private final static String BASE_TWEET_URL = "https://twitter.com/null/status/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public static String getBaseTweetUrl() {
        return BASE_TWEET_URL;
    }
}
