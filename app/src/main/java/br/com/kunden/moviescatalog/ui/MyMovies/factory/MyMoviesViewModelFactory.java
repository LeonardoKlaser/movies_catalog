package br.com.kunden.moviescatalog.ui.MyMovies.factory;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.kunden.moviescatalog.ui.MyMovies.MyMoviesViewModel;

public class MyMoviesViewModelFactory implements ViewModelProvider.Factory {
    private final Context appContext;

    public MyMoviesViewModelFactory(Context context) {
        this.appContext = context.getApplicationContext();
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MyMoviesViewModel(appContext);
    }
}
