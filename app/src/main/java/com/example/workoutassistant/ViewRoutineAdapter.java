package com.example.workoutassistant;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/****
 *
 * Class: ViewRoutineADapter
 *
 * DesC: Displays a specific routines exercises with all of that exercises data
 */

public class ViewRoutineAdapter extends CursorAdapter {

    private Context contextELA;
    private LayoutInflater layoutInflater;
    TextView exerciseName;
    TextView sets;
    TextView reps;
    TextView rest;
    TextView startWeight;
    TextView targetWeight;


    public ViewRoutineAdapter(Context context, Cursor c) {
        super(context, c);
        contextELA = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.routine_row, parent, false);
        return v;
    }

    public void bindView(View v, Context context, Cursor c) {

        exerciseName = (TextView) v.findViewById(R.id.EDexTitle);
        sets = (TextView) v.findViewById(R.id.EDSets);
        reps = (TextView) v.findViewById(R.id.EDreps);
        rest = (TextView) v.findViewById(R.id.EDrest);
        startWeight = (TextView) v.findViewById(R.id.EDstartW);
        targetWeight = (TextView) v.findViewById(R.id.EDEtargetW);

        String name =  c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_EXNAME));
        String eSets = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_SETS));
        String eReps = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_REPS));
        String eRest = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_REST));
        String strtW = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_STARTWEIGHT));
        String trgtW = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_TARGETWEIGHT));

        exerciseName.setText("Name: " + name);
        sets.setText("Sets: " + eSets);
        reps.setText("Reps: " + eReps);
        rest.setText("Rest Time:" + eRest);
        startWeight.setText("Start Weight: " +strtW);
        targetWeight.setText("Target Weight: " + trgtW);


    }
}
