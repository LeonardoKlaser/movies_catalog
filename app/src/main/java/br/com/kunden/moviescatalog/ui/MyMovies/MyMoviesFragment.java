package br.com.kunden.moviescatalog.ui.MyMovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import br.com.kunden.moviescatalog.databinding.FragmentHomeBinding;
import br.com.kunden.moviescatalog.ui.MyMovies.adapter.MovieAdapter;
import br.com.kunden.moviescatalog.ui.MyMovies.factory.MyMoviesViewModelFactory;

public class MyMoviesFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MyMoviesViewModel viewModel;
    private MovieAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        MyMoviesViewModelFactory factory = new MyMoviesViewModelFactory(requireContext());
        viewModel = new ViewModelProvider(this, factory).get(MyMoviesViewModel.class);

        adapter = new MovieAdapter();
        binding.recyclerMovies.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerMovies.setHasFixedSize(true);
        binding.recyclerMovies.setAdapter(adapter);

        viewModel.getMovies().observe(getViewLifecycleOwner(), movies -> {
            adapter.setMovieList(movies);
        });

        viewModel.loadMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}