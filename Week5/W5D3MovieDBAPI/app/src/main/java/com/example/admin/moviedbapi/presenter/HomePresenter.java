package com.example.admin.moviedbapi.presenter;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.example.admin.moviedbapi.data.Result;
import com.example.admin.moviedbapi.service.BoundService;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter, ServiceConnection {

    public static final String TAG = HomePresenter.class.getSimpleName() + "_TAG";
    private HomeContract.View homeView;
    Context context;
    Intent intentBoundService;
    BoundService boundService;
    String movie = "";

    public HomePresenter(HomeContract.View homeView, Context context) {
        this.homeView = homeView;
        this.context = context;
        intentBoundService = new Intent(context, BoundService.class);
    }

    @Override
    public void getResult(String movie) {
        this.movie = movie;
        context.bindService(intentBoundService, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void setMovieList(List<Result> results) {

    }

    @Override
    public void onMovieClicked() {
        homeView.movieDetails();
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "onServiceConnected: ");

        BoundService.MyBinder binder = (BoundService.MyBinder) service;
        boundService = binder.getBoundService();
        boundService.getMovies(homeView,movie);
        context.unbindService(this);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "onServiceDisconnected: ");
    }
}
