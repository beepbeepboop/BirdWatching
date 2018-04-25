package com.example.noahd.birdwatching;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class addObservation extends AppCompatActivity implements View.OnClickListener {

    EditText species;
    EditText times;
    EditText longtitude, latitude;
    Button createObser;
    ImageView cameraImage;
    ImageButton addImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_observation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Handles Specifics
        species = (EditText) findViewById(R.id.speciesEdit);
        times = (EditText) findViewById(R.id.timeEdit);
        longtitude = (EditText) findViewById(R.id.longtitudeEdit);
        latitude = (EditText) findViewById(R.id.latitudeEdit);

         // Handles Camera Function
        cameraImage = (ImageView) findViewById(R.id.cameraView);
        addImage = (ImageButton) findViewById(R.id.addImageBtn);


        // Handles the creation
        createObser = (Button) findViewById(R.id.createOb);


        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);


            }
        });



        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        cameraImage.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, yourObservations.class);
       intent.putExtra("createSpecies", species.getText().toString());
       intent.putExtra("createTimes", times.getText().toString());
       intent.putExtra("createLong", longtitude.getText().toString());
       intent.putExtra("createLat", latitude.getText().toString());
       startActivity(intent);

    }
}
