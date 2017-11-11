package com.example.wk.lab02.Activities;

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
    private Button buttonFragment1;
    private Button buttonFragment2;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitButtons();

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            firstFragment = new FirstFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Create a new Fragment to be placed in the activity layout
            secondFragment = new SecondFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            secondFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();

        }
    }

    private void InitButtons()
    {
        buttonFragment1 = (Button)findViewById(R.id.button_fragment1);
        buttonFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragmentToFirst();
            }
        });
        buttonFragment2 = (Button)findViewById(R.id.button_fragment2);
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
