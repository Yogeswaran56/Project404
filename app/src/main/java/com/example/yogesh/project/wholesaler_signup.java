package com.example.yogesh.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class wholesaler_signup extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceCustomerId;
    private EditText editText_email,editText_password, editText_username, editText_phoneNumber;
    private String email,password, username;
    private long phNumber;
    private Button editText_btn;
    private TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesaler_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        editText_email = findViewById(R.id.c_email_id);
        editText_password = findViewById(R.id.c_password);
        editText_btn = findViewById(R.id.btn_sign);
        editText_username = findViewById(R.id.c_username);
        editText_phoneNumber = findViewById(R.id.c_phone_number);

        editText_btn.setOnClickListener(this);
        tvv=(TextView)findViewById(R.id.tv_login);
        tvv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == editText_btn){
            email = editText_email.getText().toString();
            password = editText_password.getText().toString();

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

            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        finish();
                        //startActivity(new Intent(getApplicationContext(), wholesaler_home.class));
                    }
                }
            });
        }
        if(v==tvv){
            Intent i= new Intent(wholesaler_signup.this,wholesalerlogin.class);
            startActivity(i);
        }
    }
}
