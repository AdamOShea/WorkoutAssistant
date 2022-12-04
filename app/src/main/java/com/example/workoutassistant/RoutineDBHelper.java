package com.example.workoutassistant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/****
 * Class: Routine DB HElper
 *
 * Desc: Creates Routines table in DB
 */

public class RoutineDBHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "routinesDB";
    public static final String TABLE_ROUTINE = "routines";
    public static final String KEY_ID = "_id";
    public static final String KEY_ROUTINENAME = "title";
    public static final String KEY_EXERCISEID1 = "_id1";
    public static final String KEY_EXERCISEID2 = "_id2";
    public static final String KEY_EXERCISEID3 = "_id3";
    public static final String KEY_EXERCISEID4 = "_id4";
    public static final String KEY_EXERCISEID5 = "_id5";
    public static final String KEY_EXERCISEID6 = "_id6";
    public static final String KEY_EXERCISEID7 = "_id7";
    public static final String KEY_EXERCISEID8 = "_id8";




    public RoutineDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ROUTINE_TABLE = "CREATE TABLE " + TABLE_ROUTINE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ROUTINENAME + " TEXT,"
                + KEY_EXERCISEID1 + " INTEGER,"
                + KEY_EXERCISEID2 + " INTEGER,"
                + KEY_EXERCISEID3 + " INTEGER,"
                + KEY_EXERCISEID4 + " INTEGER,"
                + KEY_EXERCISEID5 + " INTEGER,"
                + KEY_EXERCISEID6 + " INTEGER,"
                + KEY_EXERCISEID7 + " INTEGER,"
                + KEY_EXERCISEID8 + " INTEGER"
                + ")";
        db.execSQL(CREATE_ROUTINE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROUTINE);
        onCreate(db);
    }
}