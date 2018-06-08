package com.example.admin.dailyfour;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.dailyfour.tasks.MyAsyncTask;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarOne;
    private ProgressBar progressBarTwo;
    private ProgressBar progressBarThree;
    private ProgressBar progressBarFour;
    private TextView tvCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarOne = findViewById(R.id.progressBarOne);
        progressBarTwo = findViewById(R.id.progressBarTwo);
        progressBarThree = findViewById(R.id.progressBarThree);
        progressBarFour = findViewById(R.id.progressBarFour);

        tvCounter = findViewById(R.id.tvCounter);


    }


    private int clickCounter = 0;
    public void onClickAsyncTask(View view) {
        clickCounter++;

        if(clickCounter == 1){
            MyAsyncTask myAsyncTask = new MyAsyncTask(progressBarOne, tvCounter, "Serial Execution");
            myAsyncTask.execute("Task parameters");

            MyAsyncTask myAsyncTask2 = new MyAsyncTask(progressBarTwo, tvCounter, "Serial Execution");
            myAsyncTask2.execute("Task parameters");

            MyAsyncTask myAsyncTask3 = new MyAsyncTask(progressBarThree, tvCounter, "Serial Execution");
            myAsyncTask3.execute("Task parameters");

            MyAsyncTask myAsyncTask4 = new MyAsyncTask(progressBarFour, tvCounter, "Serial Execution");
            myAsyncTask4.execute("Task parameters");


        }else if (clickCounter == 2){
            MyAsyncTask myAsyncTask = new MyAsyncTask(progressBarOne, tvCounter, "Parallel Execution");
            myAsyncTask.executeOnExecutor(myAsyncTask.THREAD_POOL_EXECUTOR, "Parallel");

            MyAsyncTask myAsyncTask2 = new MyAsyncTask(progressBarTwo, tvCounter, "Parallel Execution");
            myAsyncTask2.executeOnExecutor(myAsyncTask2.THREAD_POOL_EXECUTOR, "Parallel");

            MyAsyncTask myAsyncTask3 = new MyAsyncTask(progressBarThree, tvCounter, "Parallel Execution");
            myAsyncTask3.executeOnExecutor(myAsyncTask3.THREAD_POOL_EXECUTOR, "Parallel");

            MyAsyncTask myAsyncTask4 = new MyAsyncTask(progressBarFour, tvCounter, "Parallel Execution");
            myAsyncTask4.executeOnExecutor(myAsyncTask4.THREAD_POOL_EXECUTOR, "Parallel");

        }else{
            clickCounter = 0;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

//    Trying to avoid memory leak
//    private static class MyAsyncTask extends AsyncTask<String, Integer, String> {
//
//
//        public static final String TAG = com.example.admin.dailyfour.tasks.MyAsyncTask.class.getSimpleName() + "_TAG";
//    private final WeakReference<MainActivity> mActivityRef;
//
//
//
//        private ProgressBar progressBar;
//        TextView tvExecution;
//        private String taskType;
//
//
//        public MyAsyncTask(ProgressBar progressBar,TextView tvCounter, String taskT, MainActivity mainActivity) {
//            this.progressBar = progressBar;
//            this.tvExecution = tvCounter;
//            this.taskType = taskT;
//            this.mActivityRef = mainActivity;
//        }
//
//        //    main thread
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
////        tvResult.setText("Starting Task");
//            Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
//        }
//
//        //    worker
//        @Override
//        protected String doInBackground(String... strings) {
////      start task
//            Log.d(TAG, "doInBackground: " + strings[0]);
////        publish progress
//
//            for (int i = 0; i <= 100; i++) {
//                try {
//                    Thread.sleep(50);
//                    publishProgress(i); //this value goes behind and it is recieved by the onProgressUpdate method
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//            Log.d(TAG, "doInBackground: Thread: " + Thread.currentThread().getName());
//            return "Task result";
//        }
//
//        //    main thread
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//
////        one way to convert the integer as string
//            tvExecution.setText(taskType);
//            progressBar.setProgress(values[0]);
//
////        Log.d(TAG, "onProgressUpdate: Thread: " + Thread.currentThread().getName());
//        }
//
//        //    main thread
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
////        update ui
//            Log.d(TAG, "onPostExecute: Thread: " + Thread.currentThread().getName());
//            Log.d(TAG, "onPostExecute: Result" +s);
//            tvExecution.setText(s);
//        }
//
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//            Log.d(TAG, "onProgressUpdate: Thread" + Thread.currentThread().getName());
//        }
//    }

}
