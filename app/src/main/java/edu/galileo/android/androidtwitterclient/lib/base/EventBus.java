package edu.galileo.android.androidtwitterclient.lib.base;

/**
 * Created by nacheteam on 14/06/16.
 */
public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);

}
