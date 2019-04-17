package com.example.myapplication.Fragments.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapters.CommentAdapter;
import com.example.myapplication.Adapters.PostsAdapter;
import com.example.myapplication.Network.myApi;
import com.example.myapplication.POJO.DailyTask;
import com.example.myapplication.POJO.Post;
import com.example.myapplication.R;
import com.example.myapplication.ShoppingCheckoutStep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by MaNoOoz on 2/19/2018.
 */

public class HomeFragment extends Fragment {
//    https://www.androidauthority.com/retrofit-android-tutorial-906928/

    private static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    //    private WebsiteAdapter websiteAdapter;
    private FloatingActionButton fab;
    private TextView tx_TodayDate, test;
    private ImageButton chooseDate;
    private ArrayList<DailyTask> dailyTasks;
    private Button editBtn, createBtn;

    //    private DailyTask dailyTask;
//    private TaskAdapter taskAdapter;
    private CommentAdapter commentAdapter;
    private PostsAdapter postsAdapter;

    private myApi myApi;
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
        Gson gson = new GsonBuilder().serializeNulls().create();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        Request orginalRequest = chain.request();
                        Request NewRequest = orginalRequest.newBuilder().header("InterceptorHeader", "xyz").build();
                        return chain.proceed(NewRequest);

                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        myApi = retrofit.create(myApi.class);
//        widgets ============================================================================
        recyclerView = view.findViewById(R.id.dailyTasksList);
        tx_TodayDate = view.findViewById(R.id.tx_TodayDate);
        test = view.findViewById(R.id.test);
        recyclerView = view.findViewById(R.id.dailyTasksList);
        chooseDate = view.findViewById(R.id.bt_TodayDate);
        editBtn = view.findViewById(R.id.editPost);
        createBtn = view.findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePost();

            }
        });



        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }

        });

        tx_TodayDate.setText(currentDateTimeString);

//        taskAdapter = new TaskAdapter(getActivity(), dailyTasks);
//        recyclerView.setAdapter(taskAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        dailyTasks.add(0, new DailyTask("bbbb", "bbb", "bb"));
//        dailyTasks.add(1, new DailyTask("aaaaa", "aaa", "aa"));
//        dailyTasks.add(2, new DailyTask("Yaaa", "yaa", "ya"));
//        dailyTasks.add(3, new DailyTask("HHHH", "hhh", "hh"));
//        dailyTasks.add(4, new DailyTask("SSSS", "sss", "ss"));
//        taskAdapter.notifyDataSetChanged();

//        taskAdapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                changeItem(position, "Clicked");
//            }
//        });


//       TODO: 4/2/2019  Replace Static list With Json List

        //Create a handler for the RetrofitInstance interface// ----------------------------
//         myApi = RetrofitClient.getRetrofitInstance().create(myApi.class);
        // Or ----------------------------


        //        Gson gson  =new Gson();
//        String json = "{\"v_id\":\"1\",\"v_isDone\":false,\"v_type\":\"1\"}";
//        Log.i(TAG, "onCreateView: "+json);
//        ViolationObject violationObject = new ViolationObject(1,1,100);
//        String json = gson.toJson(violationObject);
//       ViolationObject jViolationObject1 = gson.fromJson(json,ViolationObject.class);
//        jsonAdapter = new JsonAdapter();

        return view;

    }

//    ========================================================== My Methods ========================================================================

//    private void getPosts() {
////        Using Map
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("userId", "1");
//        parameters.put("_sort", "id");
//        parameters.put("_order", "desc");
//
//        Call<List<Post>> call = myApi.getPosts(parameters);
//
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                if (!response.isSuccessful()) {
//                    test.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<Post> posts = response.body();
//                postsAdapter = new PostsAdapter(posts);
//                postsAdapter.notifyDataSetChanged();
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                recyclerView.setLayoutManager(layoutManager);
//                //Set the Adapter to the RecyclerView//
//                recyclerView.setItemViewCacheSize(5);
//                recyclerView.setAdapter(postsAdapter);
//
//                if (posts != null) {
//                    for (Post post : posts) {
//                        String content = "";
//                        content += "\n"+"ID:" + " " + post.getId()+"\n";
//                        content += "User ID: " + post.getUserId() + "\n";
//                        content += "Title: " + post.getTitle() + "\n";
//                        content += "Text: " + post.getText() + "\n\n";
//
//                        test.append(content);
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                test.setText(t.getMessage());
//            }
//        });
//
//
//    }
//    private void getComments() {
//        Call<List<Comment>> call = myApi.getAllComments(new Integer[]{1,2,3},null,null);
////        Call<List<Comment>> call = myApi.getComments("posts/3/comments");
//        //Execute the request asynchronously//
//        call.enqueue(new Callback<List<Comment>>() {
//            @Override
//            //Handle a successful response//
//            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
//                if (!response.isSuccessful()) {
//                    test.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<Comment> usersList = response.body()  ;
//
//                commentAdapter = new CommentAdapter(usersList);
//                commentAdapter.notifyDataSetChanged();
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                recyclerView.setLayoutManager(layoutManager);
//                //Set the Adapter to the RecyclerView//
//                recyclerView.setAdapter(commentAdapter);
//
//                if (usersList != null) {
//                    for (Comment comment : usersList) {
//                        String content = "";
//                        content += "\n"+"ID:" + " " + comment.getId()+"\n";
//                        content += "User ID: " + comment.getPostId() + "\n";
//                        content += "Name: " + comment.getName() + "\n";
//                        content += "Email: " + comment.getId() + "\n";
//                        content += "Text: " + comment.getText() + "\n\n";
//                        test.append(content);
//                    }
//                }
//
//            }
//            @Override
//            //Handle execution failures//
//            public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable throwable) {
//                //If the request fails, then display the following toast//
//                Toast.makeText(getActivity(), "Unable to load users", Toast.LENGTH_SHORT).show();
//                test.setText(throwable.getMessage());
//            }
//        });
//
//    }

    private void createPost() {
        Post post = new Post(23, "New Title", "New Text");

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "New Title");

        Call<Post> call = myApi.createPost(fields);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    test.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                // TODO: 4/17/2019 fix retrive list of updated posts
//                List<Post> posts = response.body();
//                postsAdapter = new PostsAdapter(posts);
//                postsAdapter.notifyDataSetChanged();
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                recyclerView.setLayoutManager(layoutManager);
//                //Set the Adapter to the RecyclerView//
//                recyclerView.setItemViewCacheSize(5);
//                recyclerView.setAdapter(postsAdapter);

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                test.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                test.setText(t.getMessage());
            }
        });
    }

    private void updatePost() {
        Post post = new Post(12, null, "New Text");

        Call<Post> call = myApi.patchPost("Hi man", 15, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    test.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                test.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                test.setText(t.getMessage());
            }
        });
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
