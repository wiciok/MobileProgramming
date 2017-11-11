package com.example.wk.lab02.Activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wk.lab02.R;

public class SharedPrefActivity extends AppCompatActivity {

    private static final String SharedPreferenceName = "TEXTTOSAVEINSHAREDPREFERENCES";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        sharedPreferences = getSharedPreferences(SharedPreferenceName, Activity.MODE_PRIVATE);

        Button buttonSharedPref = (Button)findViewById(R.id.buttonSaveText);
        buttonSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTextInSharedPrefs();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        readTextFromSharedPrefs();
    }

    private void readTextFromSharedPrefs()
    {
        String text = sharedPreferences.getString(SharedPreferenceName, "Nothing saved in SharedPreferences");
        ((EditText)findViewById(R.id.editText)).setText(text);
    }

    private void saveTextInSharedPrefs()
    {
        SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
        preferencesEditor.putString(SharedPreferenceName, ((EditText)findViewById(R.id.editText)).getText().toString());
        preferencesEditor.commit();
    }
}
