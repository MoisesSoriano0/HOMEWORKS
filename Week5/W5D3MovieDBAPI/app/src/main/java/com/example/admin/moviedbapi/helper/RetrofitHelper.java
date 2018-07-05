package com.example.admin.moviedbapi.helper;

import com.example.admin.moviedbapi.data.MoviesdbAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper INSTANCE;
    private MoviesdbAPI moviesAPI;

    private RetrofitHelper() {
        moviesAPI = createRandomAPI(prepareRetrofit());
    }

    public synchronized static RetrofitHelper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RetrofitHelper();
        }
        return INSTANCE;
    }

    private Retrofit prepareRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(moviesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private MoviesdbAPI createRandomAPI(Retrofit client) {
        return client.create(MoviesdbAPI.class);
    }

    public MoviesdbAPI getRandomAPI() {
        return moviesAPI;
    }
}
