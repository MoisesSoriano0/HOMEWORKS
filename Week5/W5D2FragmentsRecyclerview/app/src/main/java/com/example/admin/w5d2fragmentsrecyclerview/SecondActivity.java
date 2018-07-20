package com.example.admin.w5d2fragmentsrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.w5d2fragmentsrecyclerview.Adapters.RepoAdapter;
import com.example.admin.w5d2fragmentsrecyclerview.model.Repository;
import com.example.admin.w5d2fragmentsrecyclerview.network.GetRepoDataService;
import com.example.admin.w5d2fragmentsrecyclerview.network.RetrofitInstance;

import java.sql.SQLOutput;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName() + "_TAG";
    private EditText tvUserName;
    private RecyclerView recyclerView;
    private RepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvUserName = findViewById(R.id.etUserName);


    }

    public void onSearch(View view) {
        GetRepoDataService service = RetrofitInstance
                .getRetrofitInstance().create(GetRepoDataService.class);

        Call <ArrayList <Repository> > call = service.getUserRepos(tvUserName.getText().toString());

        System.out.println("url*****************************************************  " + call.request().url());

        call.enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Call<ArrayList<Repository>> call, Response<ArrayList<Repository>> response) {
                if (response.body() != null) {
                    loadResults(response.body());
                } else {
                    Toast.makeText(SecondActivity.this, "No results", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Repository>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }

    private void loadResults(ArrayList<Repository> body) {
        recyclerView = findViewById(R.id.recycler_repo);
        adapter = new RepoAdapter(body);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
