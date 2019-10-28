package com.example.proj2;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class TaskDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES1 =
            "CREATE TABLE " + TaskManager.TaskEntry.TABLE_NAME1 + " (" +
                    TaskManager.TaskEntry._ID + " INTEGER PRIMARY KEY," +
                    TaskManager.TaskEntry.COLUMN_1_TITLE + " TEXT," +
                    TaskManager.TaskEntry.COLUMN_1_DATE + " TEXT," +
                    TaskManager.TaskEntry.COLUMN_1_DESC + " TEXT )";

    private static final String SQL_CREATE_ENTRIES2 =
            "CREATE TABLE " + TaskManager.TaskEntry.TABLE_NAME2 + " (" +
                    TaskManager.TaskEntry._ID + " INTEGER PRIMARY KEY," +
                    TaskManager.TaskEntry.COLUMN_2_TITLE + " TEXT, " +
                    TaskManager.TaskEntry.COLUMN_2_DESC + " TEXT, " +
                    TaskManager.TaskEntry.COLUMN_NAME_PARENT + " TEXT, "+
                    TaskManager.TaskEntry.COLUMN_2_DATE + " TEXT , "
                    + " FOREIGN KEY ("+TaskManager.TaskEntry.COLUMN_NAME_PARENT+") REFERENCES "+TaskManager.TaskEntry.TABLE_NAME1+
                    "("+TaskManager.TaskEntry.COLUMN_1_TITLE+"))" ;


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TaskManager.TaskEntry.TABLE_NAME1;

    private static final String SQL_DELETE_ENTRIES2 =
            "DROP TABLE IF EXISTS " + TaskManager.TaskEntry.TABLE_NAME2;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TaskReader.db";

    public TaskDbHelper(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION); }
    public void onCreate(SQLiteDatabase db) {
        System.out.println("lll");
        db.execSQL(SQL_CREATE_ENTRIES1);
        db.execSQL(SQL_CREATE_ENTRIES2);
    }
    public void checker(){
        SQLiteDatabase s = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskManager.TaskEntry.COLUMN_1_TITLE, "Acads");
        values.put(TaskManager.TaskEntry.COLUMN_1_DESC, "Padhai ki baatein");
        values.put(TaskManager.TaskEntry.COLUMN_1_DATE, "2019-12-31");
        long newRowId = s.insert(TaskManager.TaskEntry.TABLE_NAME1, null, values);
        ContentValues values2 = new ContentValues();
        values2.put(TaskManager.TaskEntry.COLUMN_1_TITLE, "Self improvement");
        values2.put(TaskManager.TaskEntry.COLUMN_1_DESC, "Reading list, blogs, exercise, etc.");
        values2.put(TaskManager.TaskEntry.COLUMN_1_DATE, "2019-12-30");
        long newRowId2 = s.insert(TaskManager.TaskEntry.TABLE_NAME1, null, values2);
        ContentValues values3 = new ContentValues();
        values3.put(TaskManager.TaskEntry.COLUMN_1_TITLE, "Research");
        values3.put(TaskManager.TaskEntry.COLUMN_1_DESC, "Pet projects");
        //values3.put(TaskManager.TaskEntry.COLUMN_1_DATE, "2019-12-30");
        long newRowId3 = s.insert(TaskManager.TaskEntry.TABLE_NAME1, TaskManager.TaskEntry.COLUMN_1_DATE, values3);
        ContentValues values4 = new ContentValues();
        values4.put(TaskManager.TaskEntry.COLUMN_1_TITLE, "Hobbies");
        values4.put(TaskManager.TaskEntry.COLUMN_1_DESC, "<3");
        //values3.put(TaskManager.TaskEntry.COLUMN_1_DATE, "2019-12-30");
        long newRowId4 = s.insert(TaskManager.TaskEntry.TABLE_NAME1, TaskManager.TaskEntry.COLUMN_1_DATE, values4);
        //////////////////////////
        ContentValues values5 = new ContentValues();
        values5.put(TaskManager.TaskEntry.COLUMN_2_TITLE, "Exercise");
        values5.put(TaskManager.TaskEntry.COLUMN_2_DESC, "someday?");
        values5.put(TaskManager.TaskEntry.COLUMN_2_DATE, "2021-02-29");
        values5.put(TaskManager.TaskEntry.COLUMN_NAME_PARENT, "2");
        long newRowId5 = s.insert(TaskManager.TaskEntry.TABLE_NAME2, TaskManager.TaskEntry.COLUMN_2_DATE, values5);

        ContentValues values6 = new ContentValues();
        values6.put(TaskManager.TaskEntry.COLUMN_2_TITLE, "Reading list");
        values6.put(TaskManager.TaskEntry.COLUMN_2_DESC, "My bucket list:\nHear the Wind Sing\nThe Fountainhead\nAtlas Shrugged\nA prisoner of birth");
        //values5.put(TaskManager.TaskEntry.COLUMN_2_DATE, "2021-02-2");
        values6.put(TaskManager.TaskEntry.COLUMN_NAME_PARENT, "2");
        long newRowId6 = s.insert(TaskManager.TaskEntry.TABLE_NAME2, TaskManager.TaskEntry.COLUMN_2_DATE, values6);

        ContentValues values7 = new ContentValues();
        values7.put(TaskManager.TaskEntry.COLUMN_2_TITLE, "Origami");
        values7.put(TaskManager.TaskEntry.COLUMN_2_DESC, "cranes and tigers.");
        values7.put(TaskManager.TaskEntry.COLUMN_2_DATE, "2019-10-29");
        values7.put(TaskManager.TaskEntry.COLUMN_NAME_PARENT, "4");
        long newRowId7 = s.insert(TaskManager.TaskEntry.TABLE_NAME2, TaskManager.TaskEntry.COLUMN_2_DATE, values7);

        ContentValues values8 = new ContentValues();
        values8.put(TaskManager.TaskEntry.COLUMN_2_TITLE, "Drum practice!");
        values8.put(TaskManager.TaskEntry.COLUMN_2_DESC, "Aim:\nHallowed be thy name,\nAcid Rain (LTE)");
        values8.put(TaskManager.TaskEntry.COLUMN_2_DATE, "2019-10-29");
        values8.put(TaskManager.TaskEntry.COLUMN_NAME_PARENT, "4");
        long newRowId8 = s.insert(TaskManager.TaskEntry.TABLE_NAME2, TaskManager.TaskEntry.COLUMN_2_DATE, values8);
        s.close();
    }
    public void cc(){
        SQLiteDatabase s = getWritableDatabase();
         String a[]={};
        long newRowId = s.delete(TaskManager.TaskEntry.TABLE_NAME1,"1=1",a);
        s.close();
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES2);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void ins1(String tname , String tdesc, String dt) {
        SQLiteDatabase s = getWritableDatabase();
        ContentValues values8 = new ContentValues();
        values8.put(TaskManager.TaskEntry.COLUMN_1_TITLE, tname);
        values8.put(TaskManager.TaskEntry.COLUMN_1_DESC, tdesc);
        if(!dt.equals("")) {values8.put(TaskManager.TaskEntry.COLUMN_1_DATE, "2019-10-29");}
        //values8.put(TaskManager.TaskEntry.COLUMN_NAME_PARENT, "4");
        long newRowId8 = s.insert(TaskManager.TaskEntry.TABLE_NAME1, TaskManager.TaskEntry.COLUMN_1_DATE, values8);
        s.close();
    }
    }


