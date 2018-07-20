package com.example.admin.moviedbapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.invisibleLayout);
        btnSearch = findViewById(R.id.btnSearch);
    }

    public void onSearch(View view) {

        linearLayout.setVisibility(View.VISIBLE);

    }
}
