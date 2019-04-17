package com.example.myapplication.Adapters;

/*
 * Copyright (c) Created By Yaman Alkhateeb  2019.
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.POJO.Post;
import com.example.myapplication.R;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.CustomViewHolder> {

    private List<Post> dataList;

    public PostsAdapter(List<Post> dataList) {

        this.dataList = dataList;
    }

    @NonNull
    @Override

//Construct a RecyclerView.ViewHolder//

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override

//Set the data//
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String id = dataList.get(position).getId() + "";
        String name = dataList.get(position).getTitle() + "";
        String text = dataList.get(position).getText() + "";

        holder.id.setText(id);
        holder.name.setText(name);
        holder.text.setText(text);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

//Calculate the item count for the RecylerView//

    class CustomViewHolder extends RecyclerView.ViewHolder {

//Get a reference to the Views in our layout//

        public final View myView;

        TextView name, id, text;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            name = myView.findViewById(R.id.user);
            id = myView.findViewById(R.id.id);
            text = myView.findViewById(R.id.text);

        }
    }

}
