package com.example.admin.moviedbapi.network;

import com.example.admin.moviedbapi.data.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMoviesDataService {

    @GET("movie")
    Call<Movie> getMovies(@Query("api_key") String api_key,
                          @Query("query") String movie,
                          @Query("page") int page
                               );

}
