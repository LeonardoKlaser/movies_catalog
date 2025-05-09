package br.com.kunden.moviescatalog.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import br.com.kunden.moviescatalog.databinding.FragmentNotificationsBinding;
import br.com.kunden.moviescatalog.models.Movie;
import br.com.kunden.moviescatalog.ui.notifications.factory.AddMovieViewModelFactory;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private NotificationsViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<String> years = new ArrayList<>();
        for(int i = 1990; i <= 2025; i++){
            years.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapterAnos = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                years
        );
        List<String> genres = new ArrayList<>(List.of("Ação", "Comédia", "Drama", "Ficção", "Terror", "Romance"));
        ArrayAdapter<String> adapterGenres = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                genres
        );

        binding.dropdownAno.setAdapter(adapterAnos);
        binding.dropdownGenero.setAdapter(adapterGenres);

        AddMovieViewModelFactory factory = new AddMovieViewModelFactory(requireContext());
        viewModel =  new ViewModelProvider(this, factory).get(NotificationsViewModel.class);

        binding.buttonSalvar.setOnClickListener(v -> {
            viewModel.InsertMovie(
                    new Movie(
                            binding.editTextNome.getText().toString(),
                            binding.dropdownAno.getText().toString(),
                            binding.dropdownGenero.getText().toString(),
                            binding.editTextDescricao.getText().toString()

                    )
            );
            Toast.makeText(getContext(), "Filme inserido com sucesso", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}