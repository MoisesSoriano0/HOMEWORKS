package com.example.admin.w5d4geocodingdaggermvp.model.datasource;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RemoteDataSource {

    public static final String BASE_URL = "https://maps.googleapis.com/";
//    public static final String KEY = "AIzaSyAGJNQVFmrTfjFxsm1a-LUsUkk7yiJG5Cw";
    public static final String KEY = "AIzaSyBqHzNQSKdx2WkUbVLpfwTgRdtgEgiGlL8";

    public static Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Observable<GeoCodeResponse> getResponse(String latlng){
        RemoteService remoteService = createRetrofit().create(RemoteService.class);
        return remoteService.getGeoCodeResponse(latlng, KEY);
    }

    interface RemoteService {
        @GET("maps/api/geocode/json")
        Observable<GeoCodeResponse> getGeoCodeResponse(@Query("latlng") String latlng, @Query("key") String key);
//        observable can be any datasource, its in rxjava, we wanna hanlde observable, observable is from rxjava
//        Call is a differnt class
    }

}
