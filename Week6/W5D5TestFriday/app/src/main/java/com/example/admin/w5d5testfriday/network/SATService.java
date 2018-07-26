package com.example.admin.w5d5testfriday.network;

import com.example.admin.w5d5testfriday.model.data.SchoolDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SATService {

@GET("734v-jeq5.json")
    Call<ArrayList<SchoolDetail>> getSchoolDetails(@Query("dbn") String dbn);
}
