package br.com.kunden.moviescatalog.presenters;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import br.com.kunden.moviescatalog.models.Movie;
import br.com.kunden.moviescatalog.repositories.MovieRepository;

public class MoviePresenter {
    private MovieRepository repository;

    public MoviePresenter(Context context){
        repository = new MovieRepository(context);
    }

    public long insertMovie(Movie movie){
        return repository.insert(movie);
    }

    public List<Movie> getAll() throws SQLException {
        return repository.list();
    }
}
