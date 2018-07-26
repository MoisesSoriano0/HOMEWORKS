package com.example.admin.w5d5testfriday.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.w5d5testfriday.R;
import com.example.admin.w5d5testfriday.model.data.Schools;
import com.example.admin.w5d5testfriday.presenter.Contract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void displaySchools(ArrayList<Schools> schools) {

    }
}
