package com.example.admin.weekend3booksapiretrofitpicasso.activity.network;

import com.example.admin.weekend3booksapiretrofitpicasso.activity.model.BookList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetBookDataService {

    @GET("volumes")
//    Call<BookList> getBookData(@Query("q") String book);
    Call<BookList> getBookData(@Query("q") String book, @Query(("key"))String key);

}
