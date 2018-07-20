package com.example.admin.w5d2fragmentsrecyclerview.network;

import com.example.admin.w5d2fragmentsrecyclerview.model.Repository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetRepoDataService {
    @GET("{user}/repos")
    Call<ArrayList<Repository>> getUserRepos(@Path("user") String user);
}
