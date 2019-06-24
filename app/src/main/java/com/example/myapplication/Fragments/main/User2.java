package com.example.myapplication.Fragments.main;

import com.example.myapplication.POJO.User;

class User2 extends User {
    private int i;
    private String john_doe;
    public User2(int i, String john_doe) {
        super();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getJohn_doe() {
        return john_doe;
    }

    public void setJohn_doe(String john_doe) {
        this.john_doe = john_doe;
    }
}
