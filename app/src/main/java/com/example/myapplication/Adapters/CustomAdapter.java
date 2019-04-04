package com.example.myapplication.Adapters;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.POJO.Bnood;
import com.example.myapplication.R;

import java.util.List;
import java.util.Set;

public class CustomAdapter  extends  BaseAdapter {
    Activity activity;
    List<Bnood> users;
    LayoutInflater inflater;

    //short to create constructer using command+n for mac & Alt+Insert for window


    public CustomAdapter(Activity activity) {
        this.activity = activity;
    }

    public CustomAdapter(Activity activity, List<Bnood> users) {
        this.activity   = activity;
        this.users      = users;

        inflater        = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){

            view = inflater.inflate(R.layout.spinner_items_status, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = view.findViewById(R.id.text);
            holder.ivCheckBox =  view.findViewById(R.id.checkbox);

            view.setTag(holder);
        }else
            holder = (ViewHolder)view.getTag();

        Bnood model = users.get(i);

        holder.tvUserName.setText(model.getUserName());

        if (model.isSelected())
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);

        else
            holder.ivCheckBox.setBackgroundResource(R.drawable.check);

        return view;

    }

    public void updateRecords(List<Bnood> users){
        this.users = users;

        notifyDataSetChanged();
    }

    class ViewHolder{

        TextView tvUserName;
        CheckBox ivCheckBox;

    }
}
