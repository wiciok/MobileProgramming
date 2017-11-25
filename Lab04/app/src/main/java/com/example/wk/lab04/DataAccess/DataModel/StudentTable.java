package com.example.wk.lab04.DataAccess.DataModel;

public final class StudentTable {
    public static final String TABLE_NAME = "student";

    public class StudentColumns{

        public static final String STUDENT_NAME = "name";
        public static final String STUDENT_SURNAME = "surname";
        public static final String STUDENT_ID = "student_id";
    }

    public static String onCreate()
    {
        String query =
                "CREATE TABLE "+TABLE_NAME
                + "("
                +StudentColumns.STUDENT_ID + " " + DataTypes.INTEGER + "PRIMARY KEY" + ","
                +StudentColumns.STUDENT_NAME + " " + DataTypes.TEXT +","
                +StudentColumns.STUDENT_SURNAME + " " + DataTypes.TEXT +","
                +");";
        return query;
    }

    public static String onUpgrade()
    {
        return "DROP TABLE IF EXISTS " + TABLE_NAME + "; "
                +onCreate();
    }
}
