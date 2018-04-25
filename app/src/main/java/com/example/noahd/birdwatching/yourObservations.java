package com.example.noahd.birdwatching;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class yourObservations extends AppCompatActivity {

    TextView recieve;
    ImageView cameraImageView;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_observations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        recieve = (TextView) findViewById(R.id.recieve);
        cameraImageView = (ImageView) findViewById(R.id.cameraImageView);


        Intent intent = getIntent();
        String recieveSpecies = intent.getStringExtra("createSpecies");
        String recieveTime = intent.getStringExtra("createTimes");
        String recieveLong = intent.getStringExtra("createLong");
        String recieveLat = intent.getStringExtra("createLat");
        Bitmap bitmap = intent.getParcelableExtra("Bitmap");
       // Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
        cameraImageView.setImageBitmap(bitmap);

        recieve.setText("Current Species: " + recieveSpecies + "\n" +
                "Current Time: " + recieveTime + "\n" +
                "Current Longtitude: " + recieveLong + "\n" +
                "Current Latitude: " + recieveLat + "\n");





        //   Bundle extras = getIntent().getExtras();

     //  recieve.setText(recieve1);

    //   recieve.setText(getIntent().getStringExtra("createOb"));

    }

}
