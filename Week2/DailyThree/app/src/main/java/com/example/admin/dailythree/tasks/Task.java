package com.example.admin.dailythree.tasks;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Task implements Runnable {

    private int progressStatus = 0;
    private int progressPercentage = 0;
    private Handler handler;
    private ProgressBar progressBar;
    private TextView txtViewToUpdate;

//    private ProgressBar pbTwo;
//    private ProgressBar pbThree;
//    private ProgressBar pbFour;

    public Task(Handler handler1, int percentage, ProgressBar pb1, TextView txtViewInput){

        progressPercentage = percentage;
        progressBar = pb1;
        handler = handler1;
        txtViewToUpdate = txtViewInput;

    }


    @Override
    public void run() {


//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                txtViewToUpdate.setText(Thread.currentThread().getName().toString());
//            }
//        });

        while(progressStatus < 100){
            progressStatus += progressPercentage;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progressStatus);
                }
            });

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
