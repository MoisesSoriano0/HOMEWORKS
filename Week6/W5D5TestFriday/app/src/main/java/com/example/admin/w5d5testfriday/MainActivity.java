package com.example.admin.w5d5testfriday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.w5d5testfriday.model.datasource.Schools;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showResult(List<Schools> schooolsResult) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void navigateToDetail() {

    }

    @Override
    public void onClick(View v) {

    }
}
