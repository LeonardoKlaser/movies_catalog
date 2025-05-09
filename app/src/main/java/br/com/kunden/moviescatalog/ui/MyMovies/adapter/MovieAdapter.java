package br.com.kunden.moviescatalog.ui.MyMovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.kunden.moviescatalog.R;
import br.com.kunden.moviescatalog.models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movieList;

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_movies, parent, false);

        return new MyViewHolder(movieList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleView.setText(movie.getTitle());
        holder.genreView.setText(movie.getGenre());
        holder.yearView.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView titleView, yearView, genreView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.adp_title);
            yearView = itemView.findViewById((R.id.adp_year));
            genreView = itemView.findViewById(R.id.adp_genre);
        }
    }
}
