
package com.example.workoutassistant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/****
 * Class: Exercise DB Helper
 *
 * Description: Creates Exercise table in database
 *
 *
 */

public class ExerciseDBHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "exercisesDB";
    public static final String TABLE_EXERCISE = "exercises";
    public static final String KEY_ID = "_id";
    public static final String KEY_EXNAME = "title";
    public static final String KEY_SETS = "sets";
    public static final String KEY_REPS = "reps";
    public static final String KEY_REST = "rest";
    public static final String KEY_STARTWEIGHT = "startWeight";
    public static final String KEY_TARGETWEIGHT = "targetWeight";

    public ExerciseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EXERCISE_TABLE = "CREATE TABLE " + TABLE_EXERCISE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_EXNAME + " TEXT,"
                + KEY_SETS + " INTEGER,"
                + KEY_REPS + " INTEGER,"
                + KEY_REST + " INTEGER,"
                + KEY_STARTWEIGHT + " DOUBLE,"
                + KEY_TARGETWEIGHT + " DOUBLE"
                + ")";
        db.execSQL(CREATE_EXERCISE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        onCreate(db);
    }
}