package com.example.admin.w5d5testfridayreddit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static final String BASE_URL = "http://www.reddit.com/r/";

    private static Retrofit retrofit;

    static RedditDataService redditDataService;

    private static RetrofitInstance instance;

    public RetrofitInstance() {
        redditDataService = createRds(getRetrofitInstance());
    }

    private Retrofit getRetrofitInstance(){

        if(retrofit == null){

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();

        }

        return instance;
    }

    public static RedditDataService createRds(Retrofit retro) {
        return retro.create(RedditDataService.class);
    }

    public RedditDataService getredditDataService()
    {
        return redditDataService;
    }
}
