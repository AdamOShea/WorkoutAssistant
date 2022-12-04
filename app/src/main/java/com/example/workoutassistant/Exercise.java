package com.example.workoutassistant;

/**********

Class: Exercise

Description: Holds all attributes of an exercise
 */

public class Exercise {


    private Integer _id;
        private String title;
        private Integer sets;
        private Integer reps;
        private Integer rest;
        private Double startWeight;
        private Double targetWeight;


    public Exercise(String title, Integer sets, Integer reps, Integer rest, Double startWeight, Double targetWeight) {
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.startWeight = startWeight;
        this.targetWeight = targetWeight;
    }

    public Integer getID() {
        return _id;
    }

    public void setID(Integer _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    public Double getstartWeight() {
        return startWeight;
    }

    public void setWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }




}

