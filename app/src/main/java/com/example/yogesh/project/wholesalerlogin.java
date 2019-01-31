package com.example.yogesh.project;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class wholesalerlogin extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private EditText _email,_password;
    private String email,password;
    private Button btn;
    private Button signupbtn;
    private Button loginsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesalerlogin);

        btn = findViewById(R.id.btn_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            //startActivity(new Intent(getApplicationContext(), wholesaler_home.class));
        }
        _email = (EditText) findViewById(R.id.input_email);
        _password = (EditText) findViewById(R.id.input_password);

        btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(this);
        signupbtn=(Button)findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(wholesalerlogin.this,wholesaler_signup.class);
                startActivity(i);
            }
        });
        loginsuccess=(Button)findViewById(R.id.btn_login);
        loginsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i= new Intent(wholesalerlogin.this,wholesaler_home.class);
                //startActivity(i);
            }
        });

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
                        //startActivity(new Intent(getApplicationContext(), wholesaler_home.class));
                    }
                }
            });
        }
    }
}
