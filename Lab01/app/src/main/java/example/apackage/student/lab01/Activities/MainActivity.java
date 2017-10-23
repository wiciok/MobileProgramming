package example.apackage.student.lab01.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.apackage.student.lab01.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1ClickedCommonMethod();
            }
        });
    }

    public void button1Clicked(View view)
    {
        //button1ClickedCommonMethod();
    }

    private void button1ClickedCommonMethod(){
        Intent intent = new Intent(this, StudentListActivity.class);
        startActivity(intent);
    }
}
