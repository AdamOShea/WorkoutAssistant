package com.example.workoutassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/****
 *
 * Class: Menu List Adapter
 *
 * Desc: Inflates main menu listview
 *
 */

public class MenuListAdapter extends ArrayAdapter<MenuList> {

    ArrayList<MenuList> menu;

    public MenuListAdapter(Context context, int textViewResourceId, ArrayList<MenuList> objects)
    {
        super(context, textViewResourceId, objects);
        this.menu = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        if(v == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.menu_row, null);
        }

        MenuList currentOption = menu.get(position);

        if (currentOption != null)
        {
            TextView menuButtonText = (TextView) v.findViewById(R.id.menuButton);
            menuButtonText.setText(currentOption.getText());
        }
        return v;
    }
}
