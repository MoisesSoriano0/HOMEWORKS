package com.example.admin.moviedbapi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.moviedbapi.R;
import com.example.admin.moviedbapi.data.Result;
import com.example.admin.moviedbapi.presenter.HomeContract;
import com.example.admin.moviedbapi.presenter.HomePresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Result> movies;
    HomeContract.Presenter presenter;

    public MovieAdapter(List<Result> movies, HomePresenter presenter) {
        this.movies = movies;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvMovieTitle.setText(movies.get(position).getOriginalTitle());
        holder.tvMovieRating.setText(movies.get(position).getVoteCount());
        Picasso.get().load("http://image.tmdb.org/t/p/w185/" + movies.get(position).getPosterPath()).into(holder.ivMovieImage);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovieImage;
        TextView tvMovieTitle, tvMovieRating;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivMovieImage = itemView.findViewById(R.id.ivMovieImage);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvMovieRating = itemView.findViewById(R.id.tvMovieRating);
            itemView.setOnClickListener((View.OnClickListener)presenter);
        }
    }
}
