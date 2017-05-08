package com.example.pauline.easyvoting.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import com.example.pauline.easyvoting.R;
import com.example.pauline.easyvoting.adapter.TabsAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        connectFragments();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

        // Handle action bar item clicks here. The action bar will
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_logout) {
                logout();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


        private void logout() {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
        }


    @Override
    public void onClick(View v) {


    }
    public void connectFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        ArrayList<String> titles=new ArrayList<>();

        fragments.add(new welcome());
        fragments.add(new question());
        fragments.add(new yes_no());

        titles.add("Welcome");
        titles.add("Question");
        titles.add("vote");

        TabsAdapter adapter=new TabsAdapter(getSupportFragmentManager(),fragments,titles);

        mViewPager.setAdapter(adapter);

    }


}
