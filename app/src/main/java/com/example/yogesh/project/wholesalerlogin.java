package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wholesalerlogin extends AppCompatActivity {

    private Button signupbtn;
    private Button loginsuccess;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesalerlogin);


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
                Intent i= new Intent(wholesalerlogin.this,wholesaler_signup.class);
                startActivity(i);
            }
        });
    }
}
