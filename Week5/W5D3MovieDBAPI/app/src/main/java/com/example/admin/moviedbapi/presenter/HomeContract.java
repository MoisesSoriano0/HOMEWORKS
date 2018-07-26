package com.example.admin.moviedbapi.presenter;

import com.example.admin.moviedbapi.data.Movie;
import com.example.admin.moviedbapi.data.Result;

import java.util.List;

public interface HomeContract {

    interface View{
        void showResult(Movie movie);

        void showError();

        void movieDetails();


    }

    interface MovieRowView{

    }

    interface Presenter{
        void getResult(String movie);

        void setMovieList(List<Result> results);

        void onMovieClicked();
    }
}
