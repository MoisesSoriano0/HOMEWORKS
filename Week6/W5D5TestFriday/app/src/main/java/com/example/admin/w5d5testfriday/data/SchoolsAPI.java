package com.example.admin.w5d5testfriday.data;

import com.example.admin.w5d5testfriday.model.datasource.SchoolDetail;
import com.example.admin.w5d5testfriday.model.datasource.Schools;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolsAPI {
    String BASE_URL = "https://data.cityofnewyork.us/resource/";
    String DETAIL_URL = "https://data.cityofnewyork.us/resource/";

    @GET("97mf-9njv.json")
    Call<ArrayList<Schools>> getSchools();

    @GET("734v-jeq5.json")
    Call<SchoolDetail> getDetail(@Query("dbn") String dbn);

}
