package com.example.workoutassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*************
 * Class: DeleteAll Activity
 *
 * Description: Allows user to delete all data from the database (for data protection purposes)
 */

public class DeleteAllActivity extends Activity {

    Button delEx, delRou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_everything);

        delEx = (Button) findViewById(R.id.deleteEx);
        delRou = (Button) findViewById(R.id.deleteRout);

        delEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseDBManager db = new ExerciseDBManager(getApplicationContext());
                db.open();
                db.remove();
                db.close();
                Toast.makeText(getApplicationContext(), "Deleted All Exercise Data", Toast.LENGTH_LONG).show();
            }
        });

        delRou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoutineDBManager db = new RoutineDBManager(getApplicationContext());
                db.open();
                db.remove();
                db.close();
                Toast.makeText(getApplicationContext(), "Deleted All Routine Data", Toast.LENGTH_LONG).show();
            }
        });
    }
}
