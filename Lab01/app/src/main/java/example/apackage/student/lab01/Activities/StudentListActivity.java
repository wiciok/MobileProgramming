package example.apackage.student.lab01.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import example.apackage.student.lab01.Adapters.StudentAdapter;
import example.apackage.student.lab01.Model.Student;
import example.apackage.student.lab01.R;


public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        Init();
    }

    private void Init()
    {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("John", "Smith"));
        studentArrayList.add(new Student("Jan", "Kowalski"));
        studentArrayList.add(new Student("Hans", "Mueller"));

        ListView listView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<Student> adapter= new StudentAdapter(this,studentArrayList);
        listView.setAdapter(adapter);
    }
}
