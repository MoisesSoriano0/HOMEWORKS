package com.example.admin.moviedbapi.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.moviedbapi.R;
import com.example.admin.moviedbapi.adapter.MovieAdapter;
import com.example.admin.moviedbapi.data.Movie;
import com.example.admin.moviedbapi.presenter.HomeContract;
import com.example.admin.moviedbapi.presenter.HomePresenter;
import com.example.admin.moviedbapi.service.BoundService;

public class HomeActivity extends AppCompatActivity implements HomeContract.View{

    private LinearLayout linearLayout;
    private Button btnSearch;
    private EditText etSearch;
    private HomePresenter homePresenter;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private BoundService boundService;
    Intent boundIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

    }

    private void bindViews() {
        linearLayout = findViewById(R.id.invisibleLayout);
        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);
        homePresenter = new HomePresenter(this, this);
        boundIntent = new Intent(this, BoundService.class);
    }

    public void onSearch(View view) {

        linearLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void showResult(Movie movie) {
        recyclerView = findViewById(R.id.recycler_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        movieAdapter = new MovieAdapter(movie.getResults(), homePresenter);
        recyclerView.setAdapter(movieAdapter);

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void movieDetails() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void onClickSubmit(View view) {
        homePresenter.getResult(etSearch.getText().toString());

    }
}
