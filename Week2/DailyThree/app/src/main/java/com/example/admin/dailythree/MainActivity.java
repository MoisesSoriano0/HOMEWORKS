package com.example.admin.dailythree;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.dailythree.tasks.MyRunnable;
import com.example.admin.dailythree.tasks.Task;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{

    private ProgressBar pbarOne;
    private ProgressBar pbarTwo;
    private ProgressBar pbarThree;
    private ProgressBar pbarFour;

    private TextView tvThreadOne;
    private TextView tvThreadTwo;
    private TextView tvThreadThree;
    private TextView tvThreadFour;

    private TextView tvTimeOne;
    private TextView tvTimeTwo;
    private TextView tvTimeThree;
    private TextView tvTimeFour;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbarOne = findViewById(R.id.progressBarOne);
        pbarTwo = findViewById(R.id.progressBarTwo);
        pbarThree = findViewById(R.id.progressBarThree);
        pbarFour = findViewById(R.id.progressBarFour);

        handler = new Handler();

        bindViews();

    }

    private void bindViews() {
        tvThreadOne = findViewById(R.id.tvThreadOne);
        tvThreadTwo = findViewById(R.id.tvThreadTwo);
        tvThreadThree = findViewById(R.id.tvThreadThree);
        tvThreadFour = findViewById(R.id.tvThreadFour);

        tvTimeOne = findViewById(R.id.tvTimeOne);
        tvTimeTwo = findViewById(R.id.tvTimeTwo);
        tvTimeThree = findViewById(R.id.tvTimeThree);
        tvTimeFour = findViewById(R.id.tvTimeFour);
    }

    private int progressStatus = 0;

    public void onStart(View view) {

        int randOne = randomNumber();
        int randTwo = randomNumber();
        int randThree = randomNumber();
        int randFour = randomNumber();


        tvTimeOne.setText(String.valueOf (randOne));
        tvTimeTwo.setText(String.valueOf (randTwo));
        tvTimeThree.setText(String.valueOf (randThree));
        tvTimeFour.setText(String.valueOf (randFour));

        //percentage to advance each time
        final int progPercentageOne = 100/randOne;
        final int progPercentageTwo = 100/randTwo;
        final int progPercentageThree = 100/randThree;
        final int progPercentageFour = 100/randFour;

//        MyRunnable myRunnable = new MyRunnable(handler);

        Runnable r1 = new Task(handler, progPercentageOne, pbarOne, tvThreadOne);
        Runnable r2 = new Task(handler, progPercentageTwo, pbarTwo, tvThreadTwo);
        Runnable r3 = new Task(handler, progPercentageThree, pbarThree, tvThreadThree);
        Runnable r4 = new Task(handler, progPercentageFour, pbarFour, tvThreadFour);

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        pool.shutdown();

//        what do you pass?
//        progPercentageOne...
//        progressStatus begins at 0, so you can create it there


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (progressStatus < 100) {
////                    progressStatus += 1;
//                    progressStatus += progPercentageOne;
//
//                    handler.post(new Runnable() {
//                        public void run() {
//                            pbarOne.setProgress(progressStatus);
//                        }
//                    });
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();



    }

    private int randomNumber(){
        Random randOne = new Random();
        return  randOne.nextInt(20) + 1;
    }


    @Override
    public boolean handleMessage(Message msg) {
        System.out.println("msge back: " + msg);
        return false;
    }
}
