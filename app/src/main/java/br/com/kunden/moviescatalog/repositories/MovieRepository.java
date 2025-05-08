package br.com.kunden.moviescatalog.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.kunden.moviescatalog.database.DatabaseHelper;
import br.com.kunden.moviescatalog.interfaces.IMovieDAO;
import br.com.kunden.moviescatalog.models.Movie;
import kotlin.NotImplementedError;

import static br.com.kunden.moviescatalog.database.DatabaseHelper.ID;
import static br.com.kunden.moviescatalog.database.DatabaseHelper.MOVIE_TABLE_NAME;
import static br.com.kunden.moviescatalog.database.DatabaseHelper.MOVIE_TITLE;
import static br.com.kunden.moviescatalog.database.DatabaseHelper.MOVIE_YEAR;
import static br.com.kunden.moviescatalog.database.DatabaseHelper.MOVIE_DESCRIPTION;
import static br.com.kunden.moviescatalog.database.DatabaseHelper.MOVIE_GENRE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.viewmodel.CreationExtras;

public class MovieRepository implements IMovieDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;
    private SQLiteDatabase query;

    public MovieRepository(Context context){
        DatabaseHelper db = new DatabaseHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }
    @Override
    public boolean adicionar(Movie movie) {
        try{
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.MOVIE_TITLE,movie.getTitle());
            cv.put(DatabaseHelper.MOVIE_YEAR, movie.getYear());
            cv.put(DatabaseHelper.MOVIE_GENRE,movie.getGenre());
            cv.put(DatabaseHelper.MOVIE_DESCRIPTION,movie.getDescricao());
            write.insert(DatabaseHelper.MOVIE_TABLE_NAME, null, cv);
            return true;
        }catch (SQLException ex){
            Log.e("INFO", "Erro ao salvar filme: " +  ex.getMessage() );
        }
        return false;
    }

    @Override
    public List<Movie> listar() {
        String[] fields = {
                ID,
                MOVIE_TITLE,
                MOVIE_YEAR,
                MOVIE_GENRE,
                MOVIE_DESCRIPTION
        };

        Cursor cursor = write.query(
                MOVIE_TABLE_NAME,
                fields,
                null,
                null,
                null,
                null,
                null
        );
        throw new NotImplementedError();
    }
}
