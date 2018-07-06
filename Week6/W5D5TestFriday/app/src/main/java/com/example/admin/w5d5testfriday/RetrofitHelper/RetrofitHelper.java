package com.example.admin.w5d5testfriday.RetrofitHelper;

import com.example.admin.w5d5testfriday.data.SchoolsAPI;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper INSTANCE;
    private SchoolsAPI schoolsAPI;

    public RetrofitHelper() {
        schoolsAPI = createSchoolsAPI(prepareRetrofit());
    }

    public synchronized  static RetrofitHelper getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new RetrofitHelper();
        }
        return INSTANCE;
    }

    private Retrofit prepareRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(SchoolsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private SchoolsAPI createSchoolsAPI(Retrofit client) {
        return client.create(SchoolsAPI.class);
    }

    public SchoolsAPI getSchoolsAPI(){
        return schoolsAPI;
    }
}
