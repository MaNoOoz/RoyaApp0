package com.example.myapplication.Fragments.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;


/**
 * Created by MaNoOoz on 11/30/2017.
 */

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
//        setArguments(new Bundle());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //inflate View
        final View view = inflater.inflate(R.layout.frragment_rules, container, false);
        setHasOptionsMenu(true);


        return view;

    }//onCreateView End

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();

    }


//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
////        inflater.inflate(R.menu.start, menu);
//
//    }
//
//    //http://tutorialsbuzz.com/2015/11/android-filter-recyclerview-using-searchview-in-toolbar.html
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
////        int id = item.getItemId();
////        if (id == R.id.action_search) {
////            Toast.makeText(getActivity(), "Soon", Toast.LENGTH_SHORT).show();
////        }
////        return true;
////    }
//    }
//}
}
