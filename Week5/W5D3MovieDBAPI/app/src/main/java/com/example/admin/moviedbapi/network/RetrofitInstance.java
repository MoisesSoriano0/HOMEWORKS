package com.example.admin.moviedbapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance INSTANCE;
    private GetMoviesDataService moviesAPI;


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
                .baseUrl(moviesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private GetMoviesDataService createRandomAPI(Retrofit client) {
        return client.create(GetMoviesDataService.class);
    }

    public GetMoviesDataService getRandomAPI() {
        return moviesAPI;
    }
}
