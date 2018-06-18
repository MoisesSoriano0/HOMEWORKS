package com.example.admin.weekend3booksapiretrofitpicasso.activity.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
