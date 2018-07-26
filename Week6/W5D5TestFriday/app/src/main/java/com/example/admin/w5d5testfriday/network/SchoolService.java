package com.example.admin.w5d5testfriday.network;

import com.example.admin.w5d5testfriday.model.data.Schools;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SchoolService {

    @GET("97mf-9njv.json")
    Call<ArrayList<Schools>> getSchools();

}
