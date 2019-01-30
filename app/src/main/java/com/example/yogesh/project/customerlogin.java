package com.example.yogesh.project;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class customerlogin extends AppCompatActivity implements View.OnClickListener {

     private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;

    private FirebaseAuth firebaseAuth;
    private EditText _email,_password;
    private String email,password;
    private Button btn;
    private Button signupbtn;
    private Button loginsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        btn = findViewById(R.id.btn_login);

        getSupportActionBar().hide();

        // init constraintLayout
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(500);

        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(500);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), Welcome_screen.class));
        }


        _email = (EditText) findViewById(R.id.input_email);
        _password = (EditText) findViewById(R.id.input_password);

        btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(this);
        signupbtn=(Button)findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(customerlogin.this,customer_signup.class);
                startActivity(i);
            }
        });
        loginsuccess=(Button)findViewById(R.id.btn_login);
        loginsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(customerlogin.this,customerhomepage.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==btn){
            email = _email.getText().toString();
            password = _password.getText().toString();

            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                Toast.makeText(this, "E-mail ID and Password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(email)) {
                Toast.makeText(this, "E-mail ID cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        finish();
                        startActivity(new Intent(getApplicationContext(), customerhomepage.class));
                    }
                }
            });
        }
    }
}