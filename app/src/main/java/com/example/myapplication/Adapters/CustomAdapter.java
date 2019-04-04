package com.example.myapplication.Adapters;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.POJO.Bnood;
import com.example.myapplication.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Activity activity;
    List<Bnood> users;
    LayoutInflater inflater;

    //short to create constructer using command+n for mac & Alt+Insert for window


    public CustomAdapter(Activity activity) {
        this.activity = activity;
    }

    public CustomAdapter(Activity activity, List<Bnood> users) {
        this.activity = activity;
        this.users = users;

        inflater = activity.getLayoutInflater();
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
    public View getView(int itemIndex, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.spinner_items_status, viewGroup, false);

            CheckBox listItemCheckbox = convertView.findViewById(R.id.checkbox);

            TextView listItemText = convertView.findViewById(R.id.text);

            viewHolder = new ViewHolder(convertView);

            viewHolder.setItemCheckbox(listItemCheckbox);

            viewHolder.setItemTextView(listItemText);

            convertView.setTag(viewHolder);
        }

        Bnood listViewItemDto = users.get(itemIndex);
        viewHolder.getItemCheckbox().setChecked(listViewItemDto.isSelected());
        viewHolder.getItemTextView().setText(listViewItemDto.getUserName());

        return convertView;
    }


//            view = inflater.inflate(R.layout.spinner_items_status, viewGroup, false);
//            holder = new ViewHolder(view);
//            holder.itemTextView = view.findViewById(R.id.text);
//            holder.itemCheckbox = view.findViewById(R.id.checkbox);
//            view.setTag(holder);
//        } else
//            holder = (ViewHolder) view.getTag();
//        Bnood model = users.get(i);
//        holder.itemTextView.setText(model.getUserName());
//        if (model.isSelected())
//            holder.itemCheckbox.setChecked(false);
//        else
//            holder.itemCheckbox.setChecked(true);
//        return view;


    public void updateRecords(List<Bnood> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox itemCheckbox;

        private TextView itemTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.setIsRecyclable(false);
        }

        public CheckBox getItemCheckbox() {
            return itemCheckbox;
        }

        public void setItemCheckbox(CheckBox itemCheckbox) {
            this.itemCheckbox = itemCheckbox;
        }

        public TextView getItemTextView() {
            return itemTextView;
        }

        public void setItemTextView(TextView itemTextView) {
            this.itemTextView = itemTextView;
        }
    }
}
