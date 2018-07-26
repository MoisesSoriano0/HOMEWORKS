package com.example.admin.w5d5testfridayreddit.presenter;


import android.util.Log;
import android.widget.Toast;

import com.example.admin.w5d5testfridayreddit.model.Child;
import com.example.admin.w5d5testfridayreddit.model.Kind;
import com.example.admin.w5d5testfridayreddit.network.RedditDataService;
import com.example.admin.w5d5testfridayreddit.network.RetrofitInstance;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPresenter implements ViewContract.Presenter {

    private static final String TAG = ViewPresenter.class.getSimpleName() + "_TAG";

    RedditDataService redditDataService;
    ViewContract.View view;

    public ViewPresenter(ViewContract.View view) {
        this.view = view;
    }

    @Override
    public void getResult(final String query)
    {
        redditDataService = RetrofitInstance.getInstance().getredditDataService();

        redditDataService.getRedditResponse(query).enqueue(new Callback<Kind>() {
            @Override
            public void onResponse(Call<Kind> call, Response<Kind> response) {
                Log.d(TAG, "onResponse: URL: " + call.request().url());
                if (response.body().getData().getChildren().size() <= 0) {
                    Log.d(TAG, "onResponse: No results");
                }else{
                    view.displayResults((ArrayList<Child>) response.body().getData().getChildren());

                }
            }

            @Override
            public void onFailure(Call<Kind> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t);
            }
        });
    }


}
