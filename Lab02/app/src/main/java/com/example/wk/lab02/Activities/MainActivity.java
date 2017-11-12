package com.example.wk.lab02.Activities;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wk.lab02.Fragments.FirstFragment;
import com.example.wk.lab02.Fragments.SecondFragment;
import com.example.wk.lab02.R;

public class MainActivity extends AppCompatActivity {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    private final int SMSPermissionRequestCode = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //necessary for Android 6.0 and above:
        requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, SMSPermissionRequestCode);

        setContentView(R.layout.activity_main);
        InitButtons();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }

    private void InitButtons()
    {
        Button buttonFragment1 = (Button) findViewById(R.id.button_fragment1);
        buttonFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmentToFirst();
            }
        });
        Button buttonFragment2 = (Button) findViewById(R.id.button_fragment2);
        buttonFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmentToSecond();
            }
        });

        Button buttonSharedPref = (Button)findViewById(R.id.button_sharedpreferences);
        buttonSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSharedPrefClicked();
            }
        });
    }

    private void changeFragmentToFirst()
    {
        if(firstFragment==null)
            firstFragment=new FirstFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, firstFragment);
        transaction.commit();
    }

    private void changeFragmentToSecond()
    {
        if(secondFragment==null)
            secondFragment = new SecondFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, secondFragment);
        transaction.commit();
    }

    public void buttonSharedPrefClicked()
    {
        Intent intent = new Intent(this, SharedPrefActivity.class);
        startActivity(intent);
    }
}
