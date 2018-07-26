package com.example.admin.w5d5testfriday.presenter;

import android.util.Log;

import com.example.admin.w5d5testfriday.RetrofitHelper.RetrofitInstance;
import com.example.admin.w5d5testfriday.model.data.SchoolDetail;
import com.example.admin.w5d5testfriday.model.data.Schools;
import com.example.admin.w5d5testfriday.network.SATService;
import com.example.admin.w5d5testfriday.network.SchoolService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class ActivityPresenter implements Contract.Presenter {

    private SchoolService schoolService;
    private SATService satService;


    public static final String TAG = "TAG_";

    Contract.View view;
    Contract.SchoolInfo schoolInfo;


    public ActivityPresenter(Contract.View view) {
        this.view = view;

    }
    public ActivityPresenter(Contract.SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }
    @Override
    public void getSchools() {

        schoolService = new RetrofitInstance(RetrofitInstance.getRetrofitInstance()).getSchoolService();

        schoolService.getSchools().enqueue(new retrofit2.Callback<ArrayList<Schools>>() {
            @Override
            public void onResponse(Call<ArrayList<Schools>> call, Response<ArrayList<Schools>> response) {

                Log.d(TAG, "onResponse: "+response.body().size());
                view.displaySchools(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Schools>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t+" url "+call.request().url().toString());
            }
        });
    }


    @Override
    public void getSchoolInfo(String dbn) {

        satService = new RetrofitInstance(RetrofitInstance.getRetrofitInstance()).getSats();

        satService.getSchoolDetails(dbn).enqueue(new retrofit2.Callback<ArrayList<SchoolDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<SchoolDetail>> call, Response<ArrayList<SchoolDetail>> response) {

                Log.d(TAG, "onResponse: url"+call.request().url().toString());

                if(response.body().size() > 0) {
                    schoolInfo.displaySchoolInfo(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SchoolDetail>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });

    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }
}