package com.example.workoutassistant;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/************************
Class Name: Create Routine

Description: Allows user to create a routine by selecting exercises in the listview. Create exercise button redirects to AddExercise activity to allow for creation of exercises
 */


import java.util.ArrayList;

public class CreateRoutine extends Activity  {

    Button addExercise, createRoutine;
    ListView exerciseList;
    EditText routineName;
    ExerciseListAdapter exCursorAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_routine);

        routineName = (EditText) findViewById(R.id.routineName);           // initialising page elements
        createRoutine = (Button) findViewById(R.id.createRoutineButton);
        addExercise = (Button) findViewById(R.id.addExercise);
        addExercise.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
                startActivity(new Intent(CreateRoutine.this, AddExercise.class));  // start add exercise activity

            }
        });

        ExerciseDBManager db = new ExerciseDBManager(this);
        db.open();

        Cursor results = db.getAllExercises();  // retrieves all exercises in database to be displayed in listview
        results.moveToFirst();

        db.close();

        exCursorAdapter = new ExerciseListAdapter(this, results);
        exerciseList = (ListView) findViewById(R.id.exerciseList);       // create listview
        exerciseList.setAdapter(exCursorAdapter);


        createRoutine.setOnClickListener(new View.OnClickListener() {  // checks which exercises are ticked and creates routine from them
            @Override
            public void onClick(View v) {


                if (routineName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a name for your routine", Toast.LENGTH_LONG).show();
                }
                    else
                {
                    ArrayList<String> exercises = new ArrayList<>();

                    ArrayList<String> checkedExercises = exCursorAdapter.getExList();

                    for (int i = 0; i < exCursorAdapter.getExList().size(); i++) {
                        results.moveToPosition(i);

                        if (checkedExercises.get(i).trim().equals(results.getString(results.getColumnIndexOrThrow("title")).trim()))  { // checks which checkboxes have been selected
                            exercises.add(results.getString(results.getColumnIndexOrThrow("_id"))); // if so, add to list of exercises

                        }
                    }

                    Routines newRoutine = new Routines(routineName.getText().toString(), exercises);  // creates new routine in database
                    RoutineDBManager routineDBManager = new RoutineDBManager(getApplicationContext());
                    routineDBManager.open();
                    routineDBManager.addRoutine(newRoutine);
                    routineDBManager.close();
                    Toast.makeText(getApplicationContext(), "New routine created: "+ routineName.getText().toString(), Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }




}

