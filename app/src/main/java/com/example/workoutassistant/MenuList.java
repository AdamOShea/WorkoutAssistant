package com.example.workoutassistant;

/***
 * Class: MenuList
 *
 * Desc: Holds main menu button titles
 */

public class MenuList {

    private String text;

    public MenuList(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
