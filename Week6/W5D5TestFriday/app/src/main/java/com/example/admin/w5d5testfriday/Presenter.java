package com.example.admin.w5d5testfriday;

import android.util.Log;

import com.example.admin.w5d5testfriday.RetrofitHelper.RetrofitHelper;
import com.example.admin.w5d5testfriday.data.SchoolsAPI;
import com.example.admin.w5d5testfriday.model.datasource.Schools;
import com.example.admin.w5d5testfriday.view.BaseView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Presenter {

    private Contract.View baseView;
    private SchoolsAPI schoolsAPI;
    public static final String TAG = Presenter.class.getSimpleName() + "_TAG";

    public Presenter(Contract.View baseView) {
        this.baseView = baseView;
        schoolsAPI = RetrofitHelper.getInstance().getSchoolsAPI();
    }

    @Override
    public void getResult() {
        schoolsAPI.getSchools().enqueue(new Callback<ArrayList<Schools>>() {
            @Override
            public void onResponse(Call<ArrayList<Schools>> call, Response<ArrayList<Schools>> response) {
                Log.d(TAG, "onResponse: " + call.request().url());
                if(response.isSuccessful()){
                    ArrayList<Schools> schools = response.body();
                    baseView.shorResult(schools);
                }else{
                    baseView.showError();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Schools>> call, Throwable t) {
                baseView.showError();
            }
        });
    }

    @Override
    public void onNaavigateToDetail() {

    }

    @Override
    public void attachView(BaseView view) {

    }

    @Override
    public void detachView() {

    }
}
