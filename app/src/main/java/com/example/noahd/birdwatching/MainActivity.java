package com.example.noahd.birdwatching;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText SignUpUN, SignUpPW;
    ProgressBar createProgress;
    ImageView frontpagePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();

        SignUpUN = (EditText) findViewById(R.id.SignUpUN);
        SignUpPW = (EditText) findViewById(R.id.SignUpPW);
        createProgress = (ProgressBar) findViewById(R.id.createProgress);



        frontpagePic = (ImageView) findViewById(R.id.frontpagePic);

        int imageResource = getResources().getIdentifier("@drawable/birbo", null, this.getPackageName());
        frontpagePic.setImageResource(imageResource);

        findViewById(R.id.LoginButton).setOnClickListener(this);
        findViewById(R.id.SignUpButton).setOnClickListener(this);




        findViewById(R.id.ExitBtn).setOnClickListener(this);
        Toast.makeText(getApplicationContext(),"Hello and Welcome!",Toast.LENGTH_SHORT).show();



    }

        private void userLogin(){

            String email = SignUpUN.getText().toString().trim();
            String password = SignUpPW.getText().toString().trim();

            if(email.isEmpty()){
                SignUpUN.setError("Email is required!");
                SignUpUN.requestFocus();
                return;

            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                SignUpUN.setError("Please enter a valid Email");
                SignUpUN.requestFocus();
                return;
            }



            if(password.isEmpty()) {
                SignUpPW.setError("Password is required!");
                SignUpPW.requestFocus();
                return;
            }

            if(SignUpPW.length()< 6) {
                SignUpPW.setError("Minimum password Length is 6 characters");
                SignUpPW.requestFocus();
                return;
            }

            if (SignUpPW.length()> 30) {
                SignUpPW.setError("Too many characters!");
                SignUpPW.requestFocus();
                return;
            }

            createProgress.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful() && task.getResult() !=null){
                        createProgress.setVisibility(View.GONE);
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        createProgress.setVisibility(View.GONE);
                    }

                }
            });


        }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.SignUpButton:
                startActivity(new Intent(this,SignUpActivity.class ));
                break;

            case R.id.LoginButton:
                userLogin();
                break;

            case R.id.ExitBtn:
                finish();
                System.exit(0);

            }
        }

    }

