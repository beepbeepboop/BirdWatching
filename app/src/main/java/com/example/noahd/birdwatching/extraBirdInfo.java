package com.example.noahd.birdwatching;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;
import com.example.noahd.birdwatching.R;

import java.util.HashMap;

public class extraBirdInfo extends AppCompatActivity  {

    DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private Button createBtn;
    String Url ="";
    private HashMap<String, String> birdInfoHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_bird_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.birdImageView);
        createBtn = findViewById(R.id.createButton);
        Intent intent = getIntent();
        createBtn.setOnClickListener(buttonListener);
        birdInfoHashMap = (HashMap<String, String>) intent.getSerializableExtra("bird");
        Url = birdInfoHashMap.get("PhotoUrl");

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open, R.string.close);


        Glide.with(this).load(Url).into(imageView);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");

        }


    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };



}
