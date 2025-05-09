package br.com.kunden.moviescatalog.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.kunden.moviescatalog.models.Movie;

public interface IMovieDAO {
    public long insert (Movie movie);
    public List<Movie> list() throws SQLException;
}
