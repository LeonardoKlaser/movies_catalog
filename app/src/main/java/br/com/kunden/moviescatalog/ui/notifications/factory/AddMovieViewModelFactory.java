package br.com.kunden.moviescatalog.ui.notifications.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.kunden.moviescatalog.ui.notifications.NotificationsViewModel;

public class AddMovieViewModelFactory implements ViewModelProvider.Factory {
    private final Context appContext;

    public AddMovieViewModelFactory(Context context) {
        this.appContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new NotificationsViewModel(appContext);
    }

}
