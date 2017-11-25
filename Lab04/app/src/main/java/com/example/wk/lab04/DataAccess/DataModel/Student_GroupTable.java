package com.example.wk.lab04.DataAccess.DataModel;


public final class Student_GroupTable {
    public static final String TABLE_NAME = "student_group";

    public class Student_GroupColumns{

        public static final String STUDENT_ID = "student_id";
        public static final String GROUP_ID = "group_id";
    }

    public static String onCreate()
    {
        String query =
                "CREATE TABLE "+TABLE_NAME
                        + "("
                        + Student_GroupColumns.STUDENT_ID + " " + DataTypes.INTEGER + "REFERENCES" + StudentTable.TABLE_NAME + "(" + StudentTable.StudentColumns.STUDENT_ID + "),"
                        + Student_GroupColumns.GROUP_ID + " " + DataTypes.INTEGER + "REFERENCES" + GroupTable.TABLE_NAME + "(" + GroupTable.GroupColumns.GROUP_ID + "),"
                        +");";
        return query;
    }

    public static String onUpgrade()
    {
        return "DROP TABLE IF EXISTS " + TABLE_NAME + "; "
                +onCreate();
    }
}
