package com.example.admin.dailythree.tasks;

import android.util.Log;

public class TaskFactory {
    public static void createSimpleTask(Object progress) throws InterruptedException {

        String TAG = progress.getClass().getSimpleName() + "_TAG  Thread:" ;

        Log.d(TAG, "createSimpleTask: Starting Task on " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            Log.d(TAG, "createSimpleTask: Task Status: " +i);
            Thread.sleep(500);
        }

        Log.d(TAG, "createSimpleTask: Task Complete");
    }

    private int progressStatus = 0;
    public static void createProgressBarTask(int progressPercentage){


    }
}
