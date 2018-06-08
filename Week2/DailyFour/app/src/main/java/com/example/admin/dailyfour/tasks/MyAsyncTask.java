package com.example.admin.dailyfour.tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.dailyfour.MainActivity;

import java.lang.ref.WeakReference;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {


    public static final String TAG = MyAsyncTask.class.getSimpleName() + "_TAG";
//    private final WeakReference<MainActivity> mActivityRef;



    private ProgressBar progressBar;
    TextView tvExecution;
    private String taskType;


    public MyAsyncTask(ProgressBar progressBar,TextView tvCounter, String taskT) {
        this.progressBar = progressBar;
        this.tvExecution = tvCounter;
        this.taskType = taskT;
    }

    //    main thread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        tvResult.setText("Starting Task");
        Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
    }

//    worker
    @Override
    protected String doInBackground(String... strings) {
//      start task
        Log.d(TAG, "doInBackground: " + strings[0]);
//        publish progress

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
                publishProgress(i); //this value goes behind and it is recieved by the onProgressUpdate method
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        Log.d(TAG, "doInBackground: Thread: " + Thread.currentThread().getName());
        return "Task result";
    }

//    main thread
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

//        one way to convert the integer as string
        tvExecution.setText(taskType);
        progressBar.setProgress(values[0]);

//        Log.d(TAG, "onProgressUpdate: Thread: " + Thread.currentThread().getName());
    }

//    main thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        update ui
        Log.d(TAG, "onPostExecute: Thread: " + Thread.currentThread().getName());
        Log.d(TAG, "onPostExecute: Result" +s);
        tvExecution.setText(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onProgressUpdate: Thread" + Thread.currentThread().getName());
    }
}
