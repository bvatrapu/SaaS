package com.saptool.utils;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CustomTask extends TimerTask {

    public CustomTask(){

        //Constructor

    }

    public void run() {
        try {

           // System.out.println("Runner");

        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }

    public void runTask() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Calendar.DAY_OF_WEEK,
                Calendar.TUESDAY
        );
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 47);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);



        Timer time = new Timer(); // Instantiate Timer Object

        // Start running the task on Monday at 15:40:00, period is set to 8 hours
        // if you want to run the task immediately, set the 2nd parameter to 0
        time.schedule(new CustomTask(), calendar.getTime(), TimeUnit.HOURS.toMillis(1));
    }
}
