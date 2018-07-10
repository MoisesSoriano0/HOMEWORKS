package com.example.admin.w7d1compoundviewhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.w7d1compoundviewhw.customview.MyRectangleView;

public class MainActivity extends AppCompatActivity {

    private MyRectangleView myRectangleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myRectangleView = findViewById(R.id.myRectangle);
    }
}
