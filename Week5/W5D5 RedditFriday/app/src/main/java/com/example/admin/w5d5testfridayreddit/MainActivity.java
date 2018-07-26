package com.example.admin.w5d5testfridayreddit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import com.example.admin.w5d5testfridayreddit.Adapter.MainAdapter;
import com.example.admin.w5d5testfridayreddit.model.Child;
import com.example.admin.w5d5testfridayreddit.presenter.ViewContract;
import com.example.admin.w5d5testfridayreddit.presenter.ViewPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewContract.View {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private ViewPresenter viewPresenter;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPresenter = new ViewPresenter(this);
        searchView = findViewById(R.id.svSearch);
        recyclerView = findViewById(R.id.rvRedditPost);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewPresenter.getResult(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public void displayResults(ArrayList<Child> results) {
        mainAdapter = new MainAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }
}
