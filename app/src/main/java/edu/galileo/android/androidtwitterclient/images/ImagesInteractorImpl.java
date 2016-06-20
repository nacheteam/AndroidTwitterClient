package edu.galileo.android.androidtwitterclient.images;

/**
 * Created by nacheteam on 17/06/16.
 */
public class ImagesInteractorImpl implements ImagesInteractor {

    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
