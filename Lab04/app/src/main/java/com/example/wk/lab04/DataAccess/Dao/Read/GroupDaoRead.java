package com.example.wk.lab04.DataAccess.Dao.Read;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wk.lab04.DataAccess.Dao.Interfaces.DaoReadable;
import com.example.wk.lab04.DataAccess.DataModel.GroupTable;
import com.example.wk.lab04.DataAccess.DataModel.StudentTable;
import com.example.wk.lab04.DataAccess.DataModel.Student_GroupTable;
import com.example.wk.lab04.DataAccess.DbConnector;
import com.example.wk.lab04.Model.Group;
import com.example.wk.lab04.Model.Student;

import java.util.ArrayList;
import java.util.List;


public class GroupDaoRead implements DaoReadable<Group> {
    private SQLiteDatabase readableDB;

    public GroupDaoRead(Context context){
        readableDB=DbConnector.getInstance(context).getReadableDatabase();
    }

    @Override
    public Group getById(int id) {
        String query =  String.format(
                "SELECT * " +
                        "FROM %s " +
                        "INNER JOIN %s ON %s.%s = %s.%s " +
                        "INNER JOIN %s ON %s.%s = %s.%s " +
                        "WHERE %s.%s = %d;",
                GroupTable.TABLE_NAME,
                Student_GroupTable.TABLE_NAME, GroupTable.TABLE_NAME, GroupTable.GroupColumns.GROUP_ID, Student_GroupTable.TABLE_NAME, Student_GroupTable.Student_GroupColumns.GROUP_ID,
                StudentTable.TABLE_NAME, StudentTable.TABLE_NAME, StudentTable.StudentColumns.STUDENT_ID, Student_GroupTable.TABLE_NAME, Student_GroupTable.Student_GroupColumns.STUDENT_ID,
                GroupTable.TABLE_NAME, GroupTable.GroupColumns.GROUP_ID, id);

        Cursor cursor = readableDB.rawQuery(query,null);
        List<Student> students = new ArrayList<Student>();
        Group newGroup = null;

        try {
            if (cursor.moveToFirst()) {
                newGroup = new Group();
                newGroup.name = cursor.getString(cursor.getColumnIndex(GroupTable.GroupColumns.GROUP_NAME));
                newGroup.id = cursor.getInt(cursor.getColumnIndex(GroupTable.GroupColumns.GROUP_ID));
                do {
                    Student newStudent = new Student();
                    newStudent.id = cursor.getInt(cursor.getColumnIndex(StudentTable.StudentColumns.STUDENT_ID));
                    newStudent.name = cursor.getString(cursor.getColumnIndex(StudentTable.StudentColumns.STUDENT_NAME));
                    newStudent.surname = cursor.getString(cursor.getColumnIndex(StudentTable.StudentColumns.STUDENT_SURNAME));
                    students.add(newStudent);
                } while(cursor.moveToNext());
                newGroup.studentList = students;
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return newGroup;
    }

    @Override
    public List getAll() { return null;   }
}
