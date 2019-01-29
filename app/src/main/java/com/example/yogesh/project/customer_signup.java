package com.example.yogesh.project;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class customer_signup extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private EditText editText_email,editText_password;
    private String email,password;
    private Button editText_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        editText_email = (EditText) findViewById(R.id.c_email_id);
        editText_password = (EditText) findViewById(R.id.c_password);
        editText_btn = (Button) findViewById(R.id.btn_signup);

        editText_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == editText_btn){
            email = editText_email.getText().toString();
            password = editText_password.getText().toString();

            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                }
            });
        }
    }
}
