package br.com.kunden.moviescatalog.ui.notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import br.com.kunden.moviescatalog.models.Movie;
import br.com.kunden.moviescatalog.presenters.MoviePresenter;

public class NotificationsViewModel extends ViewModel {
    private final MoviePresenter moviePresenter;


    public NotificationsViewModel(Context app) {
        moviePresenter = new MoviePresenter(app);
    }

    public long InsertMovie(Movie movie){
        return moviePresenter.insertMovie(movie);
    }

  //  public LiveData<String> getText() {
   //     return mText;
    //}
}