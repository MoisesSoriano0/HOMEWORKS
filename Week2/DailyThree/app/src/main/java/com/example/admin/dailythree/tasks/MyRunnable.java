package com.example.admin.dailythree.tasks;

import android.os.Handler;
import com.example.admin.dailythree.utils.HandlerUtils;

public class MyRunnable implements Runnable {

    //handler instance
    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

        HandlerUtils.with(handler).sendMessage("Executing Thread");

        try {
            TaskFactory.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HandlerUtils.with(handler).sendMessage("Task completed");

    }
}
