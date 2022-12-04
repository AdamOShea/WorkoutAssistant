package com.example.workoutassistant;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**********
 * Class: View Routine
 *
 * DEsc: Shows all of users created routines. User can select one and view its exercises
 *
 */


public class ViewRoutine extends Activity {

    ListView routineList;
    Button viewRout;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_routine);

        RoutineDBManager db = new RoutineDBManager(this);
        db.open();

        Cursor results = db.getAllRoutines();
        results.moveToFirst();

        db.close();

        RoutineListAdapter rtCursorAdapter = new RoutineListAdapter(this, results);
        routineList = (ListView) findViewById(R.id.routinesList);
        routineList.setAdapter(rtCursorAdapter);

        viewRout = (Button) findViewById(R.id.viewRoutineButton);
        viewRout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRoutine.this, RoutineViewActivity.class);
                intent.putExtra("SelectedRoutine", rtCursorAdapter.getRoutine());
                Log.i("intent", rtCursorAdapter.getRoutine());
                startActivity(intent);
            }
        });

    }
}
