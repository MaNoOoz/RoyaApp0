package com.example.myapplication.Fragments.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapters.TaskAdapter;
import com.example.myapplication.POJO.DailyTask;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingCheckoutStep;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by MaNoOoz on 2/19/2018.
 */

public class HomeFragment extends Fragment {


    private static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    //    private WebsiteAdapter websiteAdapter;
    private FloatingActionButton fab;
    private TextView tx_TodayDate;
    private ImageButton  chooseDate;
    private ArrayList<DailyTask> dailyTasks;
    DailyTask dailyTask;
    TaskAdapter taskAdapter;
//    ========================================================== Lifecycle ========================================================================

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    public HomeFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "setAdapter: ");
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        dailyTasks = new ArrayList<>();




        tx_TodayDate = view.findViewById(R.id.tx_TodayDate);
        recyclerView = view.findViewById(R.id.dailyTasksList);
        chooseDate = view.findViewById(R.id.bt_TodayDate);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }

        });
//
////     textView is the TextView view that should display it
        tx_TodayDate.setText(currentDateTimeString);

        taskAdapter = new TaskAdapter(getActivity(), dailyTasks);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dailyTask = new DailyTask("gasd", "sdsds", "hhhsds");
        dailyTask = new DailyTask("gasd23", "sdsds", "hhhsds");
        dailyTask = new DailyTask("gasd232", "sdsds23", "hhhsds");
        dailyTasks.add(dailyTask);

        taskAdapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
        });


//       TODO: 4/2/2019  Replace Static list With Json List
//        Gson gson  =new Gson();
//        String json = "{\"v_id\":\"1\",\"v_isDone\":false,\"v_type\":\"1\"}";
//        Log.i(TAG, "onCreateView: "+json);
//        ViolationObject violationObject = new ViolationObject(1,1,100);
//        String json = gson.toJson(violationObject);
//       ViolationObject jViolationObject1 = gson.fromJson(json,ViolationObject.class);
//        jsonAdapter = new JsonAdapter();

        return view;

    }

    public void changeItem(int position, String text) {
        Toast.makeText(getActivity(), "" + position + text, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ShoppingCheckoutStep.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    //    ========================================================== Callback ========================================================================

//    @Override
//    public void onEdit(Website website) {
//        showAddEditDialog(website);
//
//    }

    //    ========================================================== My Methods ========================================================================


//    private void showAddEditDialog(final Website website) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setIcon(R.drawable.search);
//        builder.setTitle(getString(website == null ? R.string.dialog_add_title : R.string.dialog_edit_title));
//        View dialogView = getLayoutInflater().inflate(R.layout.add_new_website_dialog, null, false);
//        builder.setView(dialogView);
//
//
//        final EditText inputType = (EditText) dialogView.findViewById(R.id.website_name);
//        final EditText inputType2 = (EditText) dialogView.findViewById(R.id.website_desc);
//        final ImageView webIcon = dialogView.findViewById(R.id.add_icon);
//
//        if (website != null) {
//            // pre-populate
//            inputType.setText(website.getWebsiteName());
//            inputType2.setText(website.getWebsiteDisc());
//            webIcon.setImageDrawable(getResources().getDrawable(R.drawable.like));
//            TextWatcher textWatcher = new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                    // empty
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    // empty
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String titleT = inputType.getText().toString();
//                    String descN = inputType2.getText().toString();
////                    websiteAdapter.firebaseUpdate(website, titleT, descN);
//
//
//                }
//            };
//
//
//            inputType.addTextChangedListener(textWatcher);
//            inputType2.addTextChangedListener(textWatcher);
//
//        }
//
//        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (website == null) {
//                    String lt = inputType.getText().toString();
//                    String ld = inputType2.getText().toString();
//
//
////                    String ld = nameEt.getText().toString();
//                    // TODO: 12/9/2018
////                    websiteAdapter.firebasePush(new Website(lt, ld, ld,R.drawable.ic_add));
//                }
//
//
//            }
//        });
//        builder.setNegativeButton(android.R.string.cancel, null);
//        builder.create().show();
//    }
}
