package br.com.kunden.moviescatalog.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.system.ErrnoException;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.kunden.moviescatalog.database.CursorHandler;
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
    public long insert(Movie movie) {
        try{
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.MOVIE_TITLE,movie.getTitle());
            cv.put(DatabaseHelper.MOVIE_YEAR, movie.getYear());
            cv.put(DatabaseHelper.MOVIE_GENRE,movie.getGenre());
            cv.put(DatabaseHelper.MOVIE_DESCRIPTION,movie.getDescricao());
            long id = write.insert(DatabaseHelper.MOVIE_TABLE_NAME, null, cv);
            write.close();
            return id;
        }catch (Exception ex){
            throw new Error("Erro ao salvar filme: " +  ex.getMessage());
        }
    }

    @Override
    public List<Movie> list() throws SQLException {
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
        CursorHandler cursorHandler = new CursorHandler(cursor);
        List<Movie> movies  = new ArrayList<>();

        if(cursor != null && cursorHandler.moveToFirst()){
            do{
                movies.add(buildMovie(cursorHandler));
            }while(cursorHandler.moveToNext());
        }
        return movies;
    }

    private Movie buildMovie(CursorHandler cursorHandler) throws SQLException {
        return new Movie(
                cursorHandler.getInt(ID),
                cursorHandler.getString(MOVIE_TITLE),
                cursorHandler.getString(MOVIE_YEAR),
                cursorHandler.getString(MOVIE_GENRE),
                cursorHandler.getString(MOVIE_DESCRIPTION));


    }
}
