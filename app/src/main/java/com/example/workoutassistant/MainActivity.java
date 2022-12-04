package com.example.workoutassistant;

/*******************
Author: Adam O'Shea
Student Number: C20372181

App title: Workout Assistant
 App Description: Allows a user to create a workout routine to assist them during a workout. The user creates individual exercises and then adds them all to a routine. A user can delete all of the data they have created if they please.

Class: MainActivity

Description: Holds the main menu of the app. Allows user to traverse to other parts of the app.

 */


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuList opt1 = new MenuList("Create Routine");  // Objects holding the text for each menu button
        MenuList opt2 = new MenuList("View Routines");
        MenuList opt3 = new MenuList("Delete All Routines/Exercises");
        MenuList opt4 = new MenuList("Exercise Information");

        ArrayList<MenuList> mainMenu = new ArrayList<MenuList>(); // ArrayList to hold menu buttons
        mainMenu.add(opt1);
        mainMenu.add(opt2);
        mainMenu.add(opt3);
        mainMenu.add(opt4);

        ListView menuList = (ListView) findViewById(R.id.menu_list);  //ListView to display menu buttons
        MenuListAdapter menuListAdapter = new MenuListAdapter(this, R.layout.menu_row, mainMenu); // Listview adapter
        menuList.setAdapter(menuListAdapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //Listener to check which button has been clicked and redirects user to appropriate activity
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent intent = new Intent(MainActivity.this, CreateRoutine.class); // start Create Routine activity
                    startActivity(intent);
                }
                else if (position == 1)
                {
                    Intent intent = new Intent(MainActivity.this, ViewRoutine.class); // Start View routine activity
                    startActivity(intent);
                }
                else if (position == 2)
                {
                    Intent intent = new Intent(MainActivity.this, DeleteAllActivity.class); // Start delete data activity
                    startActivity(intent);
                }
                else if (position == 3)
                {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.menshealth.com/uk/workouts/"));
                    startActivity(intent);
                }
            }
        });
    }


}