package com.example.admin.w5d5testfridayreddit.network;


import com.example.admin.w5d5testfridayreddit.model.Kind;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RedditDataService {
    //
    @GET("{category}/.json")
//    Call<Kind> getRedditResponse()
    Call<Kind> getRedditResponse(
            @Path("category") String category
    );

}
