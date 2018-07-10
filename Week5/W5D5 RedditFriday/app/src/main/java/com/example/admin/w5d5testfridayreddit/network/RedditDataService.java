package com.example.admin.w5d5testfridayreddit.network;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RedditDataService {
    //
    @GET("r/{category}/.json")
//    Call<Kind> getRedditResponse()
    Call<ResponseBody> getRedditResponse(
            @Path("category") String category
    );

}
