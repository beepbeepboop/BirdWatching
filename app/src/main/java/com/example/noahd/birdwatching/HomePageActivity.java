package com.example.noahd.birdwatching;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button currentObservations = (Button) findViewById(R.id.currentBirbs);
        Button addObservations = (Button) findViewById(R.id.addBirbs);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");

        }



        findViewById(R.id.currentBirbs).setOnClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.currentBirbs:
                startActivity(new Intent(this,birdObservations.class ));
                break;


        }
    }
}
