package br.com.kunden.moviescatalog.ui.MyMovies;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.SQLException;
import java.util.List;

import br.com.kunden.moviescatalog.models.Movie;
import br.com.kunden.moviescatalog.presenters.MoviePresenter;

public class MyMoviesViewModel extends ViewModel {

    private final MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
    private final MoviePresenter moviePresenter;

    public MyMoviesViewModel(Context app) {
        moviePresenter = new MoviePresenter(app);
        loadMovies();
    }

    public LiveData<List<Movie>> getMovies() {
        return movieList;
    }

    public void loadMovies() {
        new Thread(() -> {
            try {
                List<Movie> movies = moviePresenter.getAll();
                movieList.postValue(movies);
            } catch (SQLException e) {
                throw new Error(e.getMessage());
            }
        }).start();
    }
}