package edu.galileo.android.androidtwitterclient.hashtags;

import edu.galileo.android.androidtwitterclient.entities.Hashtag;
import edu.galileo.android.androidtwitterclient.images.ImagesRepository;

/**
 * Created by nacheteam on 19/06/16.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor{
    private HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}
