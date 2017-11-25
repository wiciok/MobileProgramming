package com.example.wk.lab04.DataAccess.DataModel;


public final class GroupTable {
    public static final String TABLE_NAME = "group";

    public class GroupColumns{

        public static final String GROUP_NAME = "name";
        public static final String GROUP_ID = "group_id";
    }

    public static String onCreate()
    {
        String query =
                "CREATE TABLE "+TABLE_NAME
                        + "("
                        +GroupColumns.GROUP_ID + " " + DataTypes.INTEGER + "PRIMARY KEY" + ","
                        +GroupColumns.GROUP_NAME + " " + DataTypes.TEXT +","
                        +");";
        return query;
    }

    public static String onUpgrade()
    {
        return "DROP TABLE IF EXISTS " + TABLE_NAME + "; "
                +onCreate();
    }
}
