package com.example.admin.moviedbapi.network;

import com.example.admin.moviedbapi.data.MoviePages;

import retrofit2.Call;
import retrofit2.http.Query;

public interface GetMoviesDataService {

    //https://api.themoviedb.org/3/search/movie?api_key=bf304efada46833d9d736cec7ad9daf1&query=fiction
    String BASE_URL = "https://api.themoviedb.org/3/search/";

    Call<MoviePages> getMovies(@Query("api_key") String api_key,
                               @Query("query") String movie,
                               @Query("page") int page
                               );

}
