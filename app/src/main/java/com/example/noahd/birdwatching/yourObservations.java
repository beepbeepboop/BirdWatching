package com.example.noahd.birdwatching;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class yourObservations extends AppCompatActivity {

    TextView recieve;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_observations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recieve = (TextView) findViewById(R.id.recieve);


        Intent intent = getIntent();
        String recieveSpecies = intent.getStringExtra("createSpecies");
        String recieveTime = intent.getStringExtra("createTimes");
        String recieveLong = intent.getStringExtra("createLong");
        String recieveLat = intent.getStringExtra("createLat");

        recieve.setText("Current Species is: " + recieveSpecies + "\n\n" +
                "Current Time is: " + recieveTime + "\n\n" +
                "Current Longtitude is: " + recieveLong + "\n\n" +
                "Current Latitude is: " + recieveLat + "\n\n");





        //   Bundle extras = getIntent().getExtras();

     //  recieve.setText(recieve1);

    //   recieve.setText(getIntent().getStringExtra("createOb"));

    }

}
