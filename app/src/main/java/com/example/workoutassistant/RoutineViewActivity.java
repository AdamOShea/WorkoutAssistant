package com.example.workoutassistant;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

/******************
Class name: Routine View Activity

Description: Allows user to view a routine in depth
 */

public class RoutineViewActivity extends Activity {
    ListView exerciseList;
    TextView routineName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_delete_routine);

        // Reference: The following code came from https://stackoverflow.com/questions/5265913/how-to-use-putextra-and-getextra-for-string-data
        String selectedRoutine;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();              // retrieves Intent.putextra from View Routine class for page title
            if(extras == null) {
                selectedRoutine = null;
            } else {
                selectedRoutine = extras.getString("SelectedRoutine");
            }
        } else {
            selectedRoutine = (String) savedInstanceState.getSerializable("SelectedRoutine");
        }
        // reference complete

        exerciseList = (ListView) findViewById(R.id.EDroutList);
        routineName = (TextView) findViewById(R.id.EDroutineName);
        routineName.setText(selectedRoutine);


        ExerciseDBManager exDB = new ExerciseDBManager(this);
        exDB.open();
        Cursor exResults = exDB.getAllExercises();
        exResults.moveToFirst();

        ViewRoutineAdapter viewRoutineAdapter = new ViewRoutineAdapter(this, exResults);
        exerciseList.setAdapter(viewRoutineAdapter);
    }
}
