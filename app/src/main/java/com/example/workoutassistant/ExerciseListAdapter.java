package com.example.workoutassistant;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*****
 *
 * Class: Exercise List Adapter
 *
 * Desc: Inflates Listview in create routine activity
 *
 *
 */

public class ExerciseListAdapter extends CursorAdapter {

    ArrayList<String> exList = new ArrayList<>();



    private Context contextELA;
    private LayoutInflater layoutInflater;



    public ExerciseListAdapter(Context context, Cursor c)
    {
        super(context, c);
        contextELA = context;
        layoutInflater = LayoutInflater.from(context);
        this.exList = exList;


    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.exercise_row, parent, false);
        return v;
    }

    public void bindView(View v, Context context, Cursor c)
    {
        String exTitle = c.getString(c.getColumnIndexOrThrow(ExerciseDBHelper.KEY_EXNAME));
        TextView exerciseText = (TextView) v.findViewById(R.id.exTitle);
        exerciseText.setText(exTitle);

        CheckBox exCB = (CheckBox) v.findViewById(R.id.exerciseCheckBox);

        ExerciseDBManager db = new ExerciseDBManager(context.getApplicationContext());
        db.open();

        Cursor results = db.getAllExercises();
        results.moveToFirst();
        db.close();

        exCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {    // Checks which checkboxes are selected and adds them to array
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    exList.add(exerciseText.getText().toString());
                }
                else
                {
                    exList.remove(exerciseText.getText().toString());
                }

            }
        });

    }

    public ArrayList<String> getExList() {
        return exList;
    }

}
