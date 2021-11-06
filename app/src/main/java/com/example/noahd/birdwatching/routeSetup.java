package com.example.noahd.birdwatching;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class routeSetup extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText species;
    EditText times;
    EditText longtitude, latitude;
    Button createObser;
    ImageView cameraImage;
    ImageButton addImage;
    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_setup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateText = findViewById(R.id.dateText);
        Spinner spinner = findViewById(R.id.routeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.routeNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        findViewById(R.id.calendarButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        TextView startTimeTextViewButton = findViewById(R.id.startTimeSelector);
        startTimeTextViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new timePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });


        // Handles Specifics
        species = (EditText) findViewById(R.id.numcarsEdit);


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

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        cameraImage.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, yourSurvey.class);
//       intent.putExtra("createSpecies", species.getText().toString());
//       intent.putExtra("createTimes", times.getText().toString());
//       intent.putExtra("createLong", longtitude.getText().toString());
//       intent.putExtra("createLat", latitude.getText().toString());
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_menu_camera);
//
//        intent.setClass(routeSetup.this,yourObservations.class);
//        intent.putExtra("Bitmap",bitmap);
       startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Date: " + dayOfMonth + "/" + month + "/" + year;
        dateText.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView) findViewById(R.id.startTimeSelector);
        String strTemp = new String();
        if(hourOfDay < 10)
            strTemp = "0" + Integer.toString(hourOfDay) + ":";
        else
            strTemp = Integer.toString(hourOfDay) + ":";

        if(minute < 10)
            strTemp = strTemp + "0" + Integer.toString(minute);
        else
            strTemp = strTemp + Integer.toString(minute);
        textView.setText(strTemp);
    }
}
