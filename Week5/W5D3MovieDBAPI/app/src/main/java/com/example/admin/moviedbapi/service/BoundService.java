package com.example.admin.moviedbapi.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.admin.moviedbapi.data.Movie;
import com.example.admin.moviedbapi.network.GetMoviesDataService;
import com.example.admin.moviedbapi.network.RetrofitInstance;
import com.example.admin.moviedbapi.presenter.HomeContract;
import com.example.admin.moviedbapi.presenter.HomePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoundService extends Service {
    public static final String API_KEY = "bf304efada46833d9d736cec7ad9daf1";
    public static final int PAGE = 1;
    private static final String TAG = BoundService.class.getSimpleName() + "_TAG";
    GetMoviesDataService getMoviesDataService;
    IBinder iBinder = new MyBinder(this);
    private Movie movieO;
    HomePresenter homePresenter;

    public BoundService() {
    }

    public class MyBinder extends Binder{
        BoundService boundService;

        public MyBinder(BoundService myBoundService)
        {
            this.boundService = myBoundService;
        }

        public BoundService getBoundService(){
            return boundService;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public void getMovies(final HomeContract.View homeView, String movie) {
        getMoviesDataService = RetrofitInstance.getInstance().getMovieAPI();
        getMoviesDataService.getMovies(API_KEY, movie, PAGE)
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        movieO = response.body();
                        if (movieO != null) {
//                            homePresenter.setMovieList(movieO.getResults());
                            homeView.showResult(movieO);
                            Log.d(TAG, "onResponse: url: " +call.request().url());
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        Log.d(TAG, "onFailure: " +t);
                    }
                });
    }
}
