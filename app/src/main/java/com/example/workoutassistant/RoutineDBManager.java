
package com.example.workoutassistant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static com.example.workoutassistant.RoutineDBHelper.KEY_ID;
import static com.example.workoutassistant.RoutineDBHelper.KEY_ROUTINENAME;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID1;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID2;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID3;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID4;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID5;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID6;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID7;
import static com.example.workoutassistant.RoutineDBHelper.KEY_EXERCISEID8;


import static com.example.workoutassistant.RoutineDBHelper.TABLE_ROUTINE;

import java.util.ArrayList;

/*******
 *
 * Class: Routine DB Manager
 *
 * DEsc: Holds methods for reading and writing to Routines Table
 */

public class RoutineDBManager
{
    Context context;
    private RoutineDBHelper routineDBHelper;
    private SQLiteDatabase database;


    public RoutineDBManager(Context context)
    {
        this.context = context;

    }

    public RoutineDBManager open() throws SQLException {
        routineDBHelper = new RoutineDBHelper(context);
        database = routineDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        routineDBHelper.close();
    }


    void addRoutine(Routines routine) {

        ContentValues values = new ContentValues();
        values.put(KEY_ROUTINENAME, routine.getTitle());
        values.put(KEY_EXERCISEID1, Integer.parseInt(routine.getExerciseIDs().get(0)));
        if (routine.getExerciseIDs().size() > 1){
            values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(1)));
            if (routine.getExerciseIDs().size() > 2){
                values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(2)));
                if (routine.getExerciseIDs().size() > 3){
                    values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(3)));
                    if (routine.getExerciseIDs().size() > 4){
                        values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(4)));
                        if (routine.getExerciseIDs().size() > 5){
                            values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(5)));
                            if (routine.getExerciseIDs().size() > 6){
                                values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(6)));
                                if (routine.getExerciseIDs().size() > 7){
                                    values.put(KEY_EXERCISEID2, Integer.parseInt(routine.getExerciseIDs().get(7)));
                                }
                            }
                        }
                    }
                }
            }
        }



        Log.i("adam", "data is " + routine.getTitle());
        // Inserting Row


        database.insert(TABLE_ROUTINE, null, values);
    }


    Routines getRoutine(int id) {

        Cursor cursor = database.query(TABLE_ROUTINE, new String[] { KEY_ID,
                        KEY_ROUTINENAME, KEY_EXERCISEID1, KEY_EXERCISEID2, KEY_EXERCISEID3, KEY_EXERCISEID4, KEY_EXERCISEID5, KEY_EXERCISEID6, KEY_EXERCISEID7, KEY_EXERCISEID8}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ArrayList<String> exIDs = new ArrayList<>();
        for (int i = 2; i<10; i++){
            exIDs.add(String.valueOf(cursor.getInt(i)));
        }

        Routines routine = new Routines(
                cursor.getString(1), exIDs);

        return routine;
    }

    public Cursor getAllRoutines() {

        String selectQuery = "SELECT  * FROM " + TABLE_ROUTINE;

        Cursor routineList = database.rawQuery(selectQuery, null);

        return routineList;
    }


    public void deleteRoutine(Routines routine) {

        database.delete(TABLE_ROUTINE, KEY_ID + " = ?",
                new String[] { String.valueOf(routine.get_id()) });
        database.close();
    }

    public void remove() {
        database.delete(TABLE_ROUTINE, null, null);

    }


    public int getRoutineCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ROUTINE;
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


}