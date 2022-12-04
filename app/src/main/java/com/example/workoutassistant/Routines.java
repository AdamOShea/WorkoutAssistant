package com.example.workoutassistant;

import java.util.ArrayList;

/****
 * Class: Routines
 *
 * Desc: Holds ids for all of the exercises within a routine
 */

public class Routines {
    private Integer _id;
    private String title;
    private ArrayList<String> exerciseIDs = new ArrayList<String>();

    public Routines(String title, ArrayList<String> exerciseIDs) {
        this.title = title;
        this.exerciseIDs = exerciseIDs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getExerciseIDs() {
        return exerciseIDs;
    }

    public void setExerciseIDs(ArrayList<String> exerciseIDs) {
        this.exerciseIDs = exerciseIDs;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
