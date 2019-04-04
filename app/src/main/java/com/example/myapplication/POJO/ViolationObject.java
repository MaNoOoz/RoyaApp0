package com.manooz.roya_app.POJO;

import com.google.gson.annotations.SerializedName;


public class mViolationObject {

    // TODO: 3/20/2019


    private int v_id;
    private int v_type;
    private double v_value;
    @SerializedName("body")
    private String v_name;

    private String v_title;
    private String v_desc;
    private boolean v_isDone;

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public int getV_type() {
        return v_type;
    }

    public void setV_type(int v_type) {
        this.v_type = v_type;
    }

    public double getV_value() {
        return v_value;
    }

    public void setV_value(double v_value) {
        this.v_value = v_value;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_title() {
        return v_title;
    }

    public void setV_title(String v_title) {
        this.v_title = v_title;
    }

    public String getV_desc() {
        return v_desc;
    }

    public void setV_desc(String v_desc) {
        this.v_desc = v_desc;
    }

    public boolean isV_isDone() {
        return v_isDone;
    }

    public void setV_isDone(boolean v_isDone) {
        this.v_isDone = v_isDone;
    }
}
