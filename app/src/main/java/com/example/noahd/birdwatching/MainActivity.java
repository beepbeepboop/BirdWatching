package com.example.noahd.birdwatching;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome here! Lets have some fun!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });


        findViewById(R.id.LoginButton).setOnClickListener(this);
        findViewById(R.id.SignUpButton).setOnClickListener(this);
        findViewById(R.id.ExitBtn).setOnClickListener(this);

        Toast.makeText(getApplicationContext(),"Hello and Welcome!",Toast.LENGTH_SHORT).show();



    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.SignUpButton:
                startActivity(new Intent(this,SignUpActivity.class ));
                break;

            case R.id.LoginButton:
                startActivity(new Intent(this, HomePageActivity.class));
                break;

            case R.id.ExitBtn:
                finish();
                System.exit(0);

            }
        }

    }

