
package com.example.workoutassistant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static com.example.workoutassistant.ExerciseDBHelper.KEY_ID;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_EXNAME;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_REPS;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_SETS;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_REST;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_STARTWEIGHT;
import static com.example.workoutassistant.ExerciseDBHelper.KEY_TARGETWEIGHT;
import static com.example.workoutassistant.ExerciseDBHelper.TABLE_EXERCISE;

/******
 * Class: Exercise DB Manager
 *
 * Description: Holds methods for storing and reading Exercise database
 *
 *
 *
 */

public class ExerciseDBManager
{
    Context context;
    private ExerciseDBHelper WADBHelper;
    private SQLiteDatabase database;


    public ExerciseDBManager(Context context)
    {
        this.context = context;

    }

    public ExerciseDBManager open() throws SQLException {
        WADBHelper = new ExerciseDBHelper(context);
        database = WADBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        WADBHelper.close();
    }


    void addExercise(Exercise exercise) {

        ContentValues values = new ContentValues();
        values.put(KEY_EXNAME, exercise.getTitle());
        values.put(KEY_SETS, exercise.getSets());
        values.put(KEY_REPS, exercise.getReps());
        values.put(KEY_REST, exercise.getRest());
        values.put(KEY_STARTWEIGHT, exercise.getstartWeight());
        values.put(KEY_TARGETWEIGHT, exercise.getTargetWeight());



        Log.i("adam", "data is " + exercise.getTitle());
        // Inserting Row


        database.insert(TABLE_EXERCISE, null, values);
    }


    Exercise getExercise(int id) {

        Cursor cursor = database.query(TABLE_EXERCISE, new String[] { KEY_ID,
                        KEY_EXNAME, KEY_SETS, KEY_REPS, KEY_REST, KEY_STARTWEIGHT, KEY_TARGETWEIGHT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Exercise exercise = new Exercise(
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getDouble(6));

        return exercise;
    }

    public Cursor getAllExercises() {

        String selectQuery = "SELECT  * FROM " + TABLE_EXERCISE;

        Cursor exerciseList = database.rawQuery(selectQuery, null);

        return exerciseList;
    }

    public Cursor getRoutineExercises(String id)
    {
        String selectQuery = "SELECT * FROM" + TABLE_EXERCISE + "WHERE " + KEY_ID + " = "  + id;

        Cursor routineExercises = database.rawQuery(selectQuery, null);

        return routineExercises;
    }


    public int updateExercise(Exercise exercise) {

        ContentValues values = new ContentValues();
        values.put(KEY_EXNAME, exercise.getTitle());
        values.put(KEY_SETS, exercise.getSets());
        values.put(KEY_REPS, exercise.getReps());
        values.put(KEY_REST, exercise.getRest());
        values.put(KEY_STARTWEIGHT, exercise.getstartWeight());
        values.put(KEY_TARGETWEIGHT, exercise.getTargetWeight());

        return database.update(TABLE_EXERCISE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(exercise.getID()) });
    }



    public void remove() {

        database.delete(TABLE_EXERCISE, null, null);
    }


    public int getExerciseCount() {
        String countQuery = "SELECT  * FROM " + TABLE_EXERCISE;
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


}