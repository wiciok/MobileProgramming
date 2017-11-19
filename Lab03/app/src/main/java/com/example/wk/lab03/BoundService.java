package com.example.wk.lab03;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;


public class BoundService extends Service {

    private final IBinder binder = new MyBinder();
    private Handler handler = new Handler();
    private int counter = 0;
    private Timer timer;

    public BoundService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Your bound service has been started", Toast.LENGTH_LONG).show();


        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                showToastWithInfo();
            }
        }, 4000, 4000);


        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        timer.cancel();
        stopSelf();
        return false;
    }

    public void showToastWithInfo(){
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), "Your bound service is still working", Toast.LENGTH_SHORT).show();
                counter++;
            }
        });
    }

    public void showToastWithCounter(){

        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), "Counter: "+counter, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class MyBinder extends Binder implements IBinder {
        BoundService getService(){
            return BoundService.this;
        }
    }
}
