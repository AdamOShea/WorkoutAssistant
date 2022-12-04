package com.example.workoutassistant;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/************
 *
 * Class: Routine List Adapter
 *
 * DesC: inflates list of routines in View routine. Checks which routine is selected to be viewed
 */

public class RoutineListAdapter extends CursorAdapter {

    private Context contextELA;
    private LayoutInflater layoutInflater;
    TextView routineText;
    CheckBox viewRoutine;
    String routine;

    public RoutineListAdapter(Context context, Cursor c)
    {
        super(context, c);
        contextELA = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.exercise_row, parent, false);
        return v;
    }

    public void bindView(View v, Context context, Cursor c)
    {
        String routineTitle = c.getString(c.getColumnIndexOrThrow(RoutineDBHelper.KEY_ROUTINENAME));
        routineText = (TextView) v.findViewById(R.id.exTitle);
        routineText.setText(routineTitle);

        viewRoutine = (CheckBox) v.findViewById(R.id.exerciseCheckBox);

        RoutineDBManager db = new RoutineDBManager(context.getApplicationContext());
        db.open();
        Cursor results = db.getAllRoutines();
        results.moveToFirst();
        db.close();


        viewRoutine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    routine = routineText.getText().toString();
                }

            }
        });

    }

    public String getRoutine() {
        return routine;
    }
}

