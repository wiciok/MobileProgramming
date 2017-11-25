package com.example.wk.lab04.DataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wk.lab04.DataAccess.DataModel.GroupTable;
import com.example.wk.lab04.DataAccess.DataModel.StudentTable;
import com.example.wk.lab04.DataAccess.DataModel.Student_GroupTable;

public class DbConnector extends SQLiteOpenHelper {
    private static DbConnector instance;

    private static final String DATABASE_NAME = "postsDatabase";
    private static final int DATABASE_VERSION = 1;

    private DbConnector(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DbConnector getInstance(Context context){
        if(instance==null) {
            instance = new DbConnector(context);
        }
        return instance;
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentTable.onCreate());
        db.execSQL(GroupTable.onCreate());
        db.execSQL(Student_GroupTable.onCreate());
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL(StudentTable.onUpgrade());
            db.execSQL(GroupTable.onUpgrade());
            db.execSQL(Student_GroupTable.onUpgrade());
        }
    }


}