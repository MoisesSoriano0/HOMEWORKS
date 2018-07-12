package com.example.admin.w7d3timberlaeakcanaryzxing;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w7d3timberlaeakcanaryzxing.Timber.NoLogReleaseTree;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private TextView tvScanned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plant();
        timberLog();

        tvScanned = findViewById(R.id.tvScanned);


        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this.getApplication());


//        causeML();
//        noML();

//        viewPDF();



    }

    private void viewPDF() {
        String linkTo = "https://www.guggenheim.org/wp-content/uploads/2004/08/guggenheim-pub-the-aztec-empire-2004.pdf";

        WebView mWebView=new WebView(MainActivity.this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://docs.google.com/gview?embedded=true&url="+linkTo);
        setContentView(mWebView);
    }

    //GC won't find the reference to the thread so it'll cause a memory leak
    private void causeML() {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }

    //we are referencing the thread, so this way the garbage collector will know and wont cause a memory leak
    private void noML() {
        new MyThread().start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            SystemClock.sleep(1000);
        }
    }

    private void timberLog() {
        Timber.v("timber verbose log");
        Timber.d("timber debug log");
        Timber.i("timber info log");
        Timber.w("timber warning log");
        Timber.e("timber error log");
    }

    private void plant() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else
            Timber.plant(new NoLogReleaseTree());
    }

    public void onScan(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanResult != null) {
            if (scanResult.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                tvScanned.setText(scanResult.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}

