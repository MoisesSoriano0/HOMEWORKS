package com.example.admin.moviedbapi;

import com.example.admin.moviedbapi.base.BasePresenter;
import com.example.admin.moviedbapi.movies.Result;

public interface HomeContract {

    interface View{
        void showResult();

        void shorError();

        void navigateToDetail(Result result);


    }

    //new view
//    interface UserRowView {
//        void setUserName(String name);
//    }

    interface MovieRowView{

    }

    interface Presenter extends BasePresenter{
        void getResult();

        void onBindRowViewAtPosition(int position, MovieRowView movieRowView);

        void onItemInteraction(int position);

        int getResultCount();
    }
}
