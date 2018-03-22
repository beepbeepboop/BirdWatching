package com.example.noahd.birdwatching;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText SignUpUN, SignUpPW;
    private FirebaseAuth mAuth;



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.LoginFromSignUp).setOnClickListener(this);
        findViewById(R.id.CreateUser).setOnClickListener(this);

        SignUpUN = (EditText) findViewById(R.id.SignUpUN);
        SignUpPW = (EditText) findViewById(R.id.SignUpPW);
        mAuth = FirebaseAuth.getInstance();
    }



    private void rigisterUser(){
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
    }




    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.CreateUser:
                rigisterUser();
                break;

            case R.id.LoginFromSignUp:
                startActivity(new Intent(this, MainActivity.class));

                Log.d("This works!", "onClick: Hello");
                break;
                



        }

    }
}
