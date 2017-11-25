package com.example.wk.lab04.DataAccess.Dao.Write;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.wk.lab04.DataAccess.Dao.Interfaces.DaoWritable;
import com.example.wk.lab04.DataAccess.DataModel.GroupTable;
import com.example.wk.lab04.DataAccess.DbConnector;
import com.example.wk.lab04.Model.Group;


public class GroupDaoWrite implements DaoWritable<Group> {
    private SQLiteDatabase writableDB;

    public GroupDaoWrite(Context context){
        writableDB = DbConnector.getInstance(context).getWritableDatabase();
    }

    @Override
    public void save(Group obj) {
        writableDB.beginTransaction();

        try {
            ContentValues groupValues = new ContentValues();
            ContentValues student_groupValues = new ContentValues();
            for(int i=0;i<obj.studentList.size();i++){
                long studentId = addOrUpdateUser(post.user);
                student_groupValues.put(KEY_POST_USER_ID_FK, studentId);
            }





            groupValues.put(KEY_POST_TEXT, post.text);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            writableDB.insertOrThrow(GroupTable.TABLE_NAME, null, groupValues);
            writableDB.setTransactionSuccessful();
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            writableDB.endTransaction();
        }
    }

    @Override
    public void update(Group obj) {

    }

    @Override
    public void delete(Group obj) {

    }
}
