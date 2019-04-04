package com.example.myapplication.POJO;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

public class Bnood {
    private boolean isSelected;
    private String userName;
    private int position;

    public Bnood() {
    }

    public Bnood(boolean isSelected, String userName) {
        this.isSelected = isSelected;
        this.userName = userName;
    }

    //now create constructor and getter setter method using shortcut like command+n for mac & Alt+Insert for window.
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
