package com.example.noahd.birdwatching;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addObservation extends AppCompatActivity implements View.OnClickListener {

    EditText species;
    EditText times;
    EditText longtitude, latitude;
    Button createObser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_observation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        species = (EditText) findViewById(R.id.speciesEdit);
        times = (EditText) findViewById(R.id.timeEdit);
        longtitude = (EditText) findViewById(R.id.longtitudeEdit);
        latitude = (EditText) findViewById(R.id.latitudeEdit);

        createObser = (Button) findViewById(R.id.createOb);



        }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, yourObservations.class);
       intent.putExtra("createOb", species.getText().toString());
       intent.putExtra("createOb", times.getText().toString());
       intent.putExtra("createOb", longtitude.getText().toString());
       intent.putExtra("createOb", latitude.getText().toString());
       startActivity(intent);

    }
}
