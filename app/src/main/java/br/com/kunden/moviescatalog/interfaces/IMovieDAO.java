package br.com.kunden.moviescatalog.interfaces;

import java.util.List;

import br.com.kunden.moviescatalog.models.Movie;

public interface IMovieDAO {
    public boolean adicionar (Movie movie);
    public List<Movie> listar();
}
