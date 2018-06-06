package com.example.admin.dailytwo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TagIt.with(this),"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TagIt.with(this), "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Show message in screen
//        Toast.makeText(this,"onPause()", Toast.LENGTH_LONG).show();
        Log.d(TagIt.with(this), "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TagIt.with(this), "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagIt.with(this), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagIt.with(this), "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TagIt.with(this), "onRestart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        newConfig.orientation portrait = 1
        Log.d(TagIt.with(this), "onConfigurationChanged " + newConfig.orientation);
    }

    public void onClickButton(View view) {

        Intent intent = null;

        switch (view.getId()){
            case R.id.btnOne:
                intent = new Intent(this,ImplicitIntentsActivity.class);
                break;
            case R.id.btnTwo:
                intent = new Intent(this, emiCalculatorActivity.class);
                break;
            case R.id.btnThree:
                intent = new Intent(this, userFormActivity.class);
                break;
        }

        startActivity(intent);
    }
}
