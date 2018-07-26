package com.example.admin.moviedbapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance INSTANCE;
    private GetMoviesDataService moviesAPI;
    String BASE_URL = "https://api.themoviedb.org/3/search/";

    private RetrofitInstance() {
        moviesAPI = createRandomAPI(prepareRetrofit());
    }

    public synchronized static RetrofitInstance getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RetrofitInstance();
        }
        return INSTANCE;
    }

    private Retrofit prepareRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private GetMoviesDataService createRandomAPI(Retrofit client) {
        return client.create(GetMoviesDataService.class);
    }

    public GetMoviesDataService getMovieAPI() {
        return moviesAPI;
    }
}
