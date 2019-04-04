/*
 * Created By Yaman Alkhateeb
 */

package com.example.myapplication.POJO;

import com.google.gson.annotations.SerializedName;

public class Violation_Type {

    @SerializedName("status")
    private Status currentState = null;

    // other fields, getters, setters, constructor and other code...

    public enum Status {
        @SerializedName("0")
        PERIODIC,
        @SerializedName("1")
        FLASH,
        @SerializedName("2")
        COMPLIAN

    }
}
