/*
 * Copyright (c) 2019
 */

package com.example.myapplication.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.POJO.DailyTask;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private static final String TAG = "TaskAdapter";
    private Context context;
    private ArrayList<DailyTask> dailyTasks;
    private OnItemClickListener mListener;

    public TaskAdapter(Context context, ArrayList<DailyTask> dailyTasks) {
        this.context = context;
        this.dailyTasks = dailyTasks;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View fragmentView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_root, viewGroup, false);
        return new MyViewHolder(fragmentView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DailyTask dailyTask = dailyTasks.get(position);
        holder.titleTextView.setText(dailyTask.getlName());
        holder.nameTextView.setText(dailyTask.getlTitle());
        holder.profile_image.setText(dailyTask.getlName().substring(0, 1) + dailyTask.getlTitle().substring(0, 1));
        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        holder.profile_image.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return dailyTasks.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout vg;
        private TextView titleTextView;
        private TextView nameTextView;
        private TextView profile_image;
//        private ImageView send, edit, delete, share;


        MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.taskTitle);
            nameTextView = itemView.findViewById(R.id.desc);
            profile_image = itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                            Log.d(TAG, "onClick() returned: " + position);

                        }

                    }
                }
            });

        }

    }




}