package com.example.myapplication.Fragments.main;

/**
 * Created by MaNoOoz on 11/26/2017.
 */

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class NotificationFragment extends Fragment {
    private static final String TAG = "NotificationFragment";
    private ProgressBar pr;
    private Button addNewViolationBtn;
    private Handler progressHandler = new Handler();


    public NotificationFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);
        setHasOptionsMenu(true);


        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}