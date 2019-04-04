/*
 * Created By Yaman Alkhateeb
 */

package com.example.myapplication.POJO;

public class Task {
    private String lName;
    private String lTitle;
    private String key;

    public Task(String lName, String lTitle, String key) {
        this.lName = lName;
        this.lTitle = lTitle;
        this.key = key;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlTitle() {
        return lTitle;
    }

    public void setlTitle(String lTitle) {
        this.lTitle = lTitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
