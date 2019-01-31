package com.example.yogesh.project;

import android.app.ProgressDialog;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class customerlogin extends AppCompatActivity implements View.OnClickListener {

     private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;

    private FirebaseAuth firebaseAuth;
    private EditText _email,_password;
    private String email,password;
    private Button btn, signupBtn;
    private Button loginsuccess;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        btn = findViewById(R.id.btn_login);
        signupBtn = findViewById(R.id.btn_signup);

        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);

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


        _email = (EditText) findViewById(R.id.tv_emailid_customer);
        _password = (EditText) findViewById(R.id.tv_password_customer);

        btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(this);

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
            try{
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

                progressDialog.setMessage("Logging in...");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), custo_home_page.class));
                        }
                        else if(task.getException() instanceof FirebaseAuthInvalidUserException) {
                            Toast.makeText(customerlogin.this, "Username is not registered", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Toast.makeText(customerlogin.this, "Username/Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        if(v == signupBtn) {
            finish();
            startActivity(new Intent(this, customerlogin.class));
        }
    }
}