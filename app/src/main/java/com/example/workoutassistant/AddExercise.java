package com.example.workoutassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/************************
 * Class: Add Exercise
 *
 * Description: Allows user to enter details for an exercise and puts the exercise in the database
 */

public class AddExercise extends Activity {

    Button createExercise, cancelCreate;
    Exercise newExercise;
    EditText exName, exSets, exReps, exRest, exStartWeight, exTargetWeight;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercise);

        ExerciseDBManager db = new ExerciseDBManager(this);

        exName = (EditText) findViewById(R.id.exerciseName);
        exSets = (EditText) findViewById(R.id.sets);
        exReps = (EditText) findViewById(R.id.repetitions);
        exRest = (EditText) findViewById(R.id.restTime);
        exStartWeight = (EditText) findViewById(R.id.startWeight);
        exTargetWeight = (EditText) findViewById(R.id.targetWeight);

        cancelCreate = (Button) findViewById(R.id.cancelCreateButton);
        cancelCreate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish(); // cancel creation
            }
        });

        createExercise = (Button) findViewById(R.id.createExerciseButton);
        createExercise.setOnClickListener(new View.OnClickListener()  // checks all inputs after create exercise is pressed
        {
            public void onClick(View v) {

                String name = exName.getText().toString();

                String setsStr = exSets.getText().toString();
                Integer sets;
                try {
                    sets = Integer.parseInt(setsStr);
                } catch (NumberFormatException e) {
                    sets = 0;
                }

                String repsStr = exReps.getText().toString();
                Integer reps;
                try {
                    reps = Integer.parseInt(repsStr);
                } catch (NumberFormatException e) {
                    reps = 0;
                }
//
                String restStr = exRest.getText().toString();
                Integer rest;
                try {
                    rest = Integer.parseInt(restStr);
                } catch (NumberFormatException e){
                    rest = 0;
                }
//
                String startWeightStr = exStartWeight.getText().toString();
                Double startWeight;
                try {
                    startWeight = Double.parseDouble(startWeightStr);
                } catch (NumberFormatException e) {
                    startWeight = 0.0;
                }
//
                String targetWeightStr = exTargetWeight.getText().toString();
                Double targetWeight;
                try {
                    targetWeight = Double.parseDouble(targetWeightStr);
                } catch (NumberFormatException e)
                {
                    targetWeight = 0.0;
                }


//                // pull user input from addExercise and insert into db if all inputs are satisfied
                if (name.trim().equals("") || setsStr.trim().equals("") || repsStr.trim().equals("") || restStr.trim().equals("") || startWeightStr.trim().equals("") || targetWeightStr.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "1 or more fields are empty. Please input into all fields", Toast.LENGTH_LONG).show();
                } else {

                    newExercise = new Exercise(name, sets, reps, rest, startWeight, targetWeight);

                    db.open();
                    db.addExercise(newExercise);
                    db.close();
                    Intent intent = new Intent(AddExercise.this, CreateRoutine.class);
                    finish();
                }
            }
        });
    }
}
