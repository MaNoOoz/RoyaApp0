package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.Fragments.main.HomeFragment;
import com.example.myapplication.Fragments.main.NotificationFragment;
import com.example.myapplication.Fragments.main.ProfileFragment;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    // || ========================================== Widgets ============================================= ||
    private Toolbar mToolbar;
    private ActionBar actionBar;
    private FloatingActionButton floatingActionButton;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;


    // || ======================================== Activity LifeCycle ============================================= ||

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        initToolbar();
        ClickEvents();
        initBottomNavigationMenu();


    }

    private void ClickEvents() {
        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShoppingCheckoutStep.class);
            startActivity(intent);
            Toasty.info(getApplicationContext(), "floatingActionButton", Toast.LENGTH_SHORT).show();

        });
    }

    // ======================================== Bottom Bar  Navigation      ============================================= \\
    private void initBottomNavigationMenu() {
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        //I added this if statement to keep the selected fragment when rotating the device
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                new HomeFragment()).commit();

        if (bottomNavigationView != null) {
            bottomNavigationView = findViewById(R.id.navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        Toasty.info(getApplicationContext(), "HomeFragment", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        selectedFragment = new ProfileFragment();
                        Toasty.info(getApplicationContext(), "ProfileFragment", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notif:
                        selectedFragment = new NotificationFragment();
                        Toasty.info(getApplicationContext(), "NotificationsFragment", Toast.LENGTH_SHORT).show();
                        break;

                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                            selectedFragment).commit();
                } else {
                    Toasty.info(getApplicationContext(), "selectedFragment is Null", Toast.LENGTH_SHORT).show();

                }
                return true;


            });


        }
    }

    // ========================================   Sheared  Methods ============================================= \\
    private void initToolbar() {
//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
////        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        setSupportActionBar(mToolbar);
//        actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle("تطبيق المراقبين");
//        actionBar.setIcon(R.drawable.ic_web_asset_white_36dp);
//        Tools.setSystemBarColor(this, R.color.pink_700);

    }

}


