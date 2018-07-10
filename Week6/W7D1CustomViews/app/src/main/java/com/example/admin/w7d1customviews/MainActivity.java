package com.example.admin.w7d1customviews;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.w7d1customviews.customview.MyCircleView;

public class MainActivity extends AppCompatActivity {

    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircleView = findViewById(R.id.myCircle);
    }

    public void onRadiusChanged(View view) {
        myCircleView.setRadius(300);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onColorChanged(View view) {
//        myCircleView.setFillColor(Color.RED);
        myCircleView.setFillColor(getColor(R.color.colorAccent));
    }

    public void onMakeBigger(View view) {

        myCircleView.setRadius(myCircleView.getRadius() + 10);
    }

    public void onMakeSmaller(View view) {
        myCircleView.setRadius(myCircleView.getRadius() - 10);
    }
}
