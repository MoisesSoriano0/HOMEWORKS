package com.example.admin.w5d5testfriday.RetrofitHelper;

import com.example.admin.w5d5testfriday.network.SATService;
import com.example.admin.w5d5testfriday.network.SchoolService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    static Retrofit retrofitInstance;

    public static final String BASE_URL = "https://data.cityofnewyork.us/resource/";
//97mf-9njv.json


    public RetrofitInstance(Retrofit retrofitInstance) {
        this.retrofitInstance = retrofitInstance;

    }

    public static Retrofit getRetrofitInstance()
    {
        if(retrofitInstance == null)
        {

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance;
    }

    public SchoolService getSchoolService()
    {
        return retrofitInstance.create(SchoolService.class);
    }

    public SATService getSats(){ return  retrofitInstance.create(SATService.class);}
}
