package com.example.wk.lab03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StartService extends Service {
    private Timer timer;
    private Toast toast;

    public StartService() {
    }


    private void showToast() {
        toast.show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        toast = Toast.makeText(this,"Your service is still running",Toast.LENGTH_SHORT);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Your service has been started",Toast.LENGTH_LONG).show();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                showToast();
            }
        }, 4000, 4000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

