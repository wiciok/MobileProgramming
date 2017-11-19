package com.example.wk.lab03;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this, StartService.class);
        //startService(intent);

        Intent intent2 = new Intent(this, BoundService.class);
        bindService(intent2, mConnection, Context.BIND_AUTO_CREATE);
    }


    private BoundService mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        // Called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Because we have bound to an explicit
            // service that is running in our own process, we can
            // cast its IBinder to a concrete class and directly access it.
            BoundService.MyBinder binder = (BoundService.MyBinder) service;
            mService = binder.getService();
        }

        // Called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {

        }
    };

    @Override
    public void onPause(){
        super.onPause();
        unbindService(mConnection);
    }


    public void onButtonShowCounterClick(View view){
        mService.showToastWithCounter();
    }

    public void onButtonNewActivityClick(View view) {
        Intent newActivityShowIntent = new Intent(this, NewActivity.class);
        startActivity(newActivityShowIntent);
    }
}
