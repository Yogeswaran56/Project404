package com.example.yogesh.project;

import android.content.Intent;
import android.provider.ContactsContract;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vendor_signup extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReferenceVendorId;
    private EditText editText_username,editText_email,editText_password,editText_phno;
    private String username,email,password;
    private long phno;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        editText_username = findViewById(R.id.v_username);
        editText_email = findViewById(R.id.v_email_id);
        editText_password = findViewById(R.id.v_password);
        editText_phno = findViewById(R.id.v_phone_number);
        btn = findViewById(R.id.signup_btn);

        btn.setOnClickListener(this);
    }

    public void vendorInformationAdd() {
        try{
            String userId = firebaseAuth.getCurrentUser().getUid();
            databaseReferenceVendorId = FirebaseDatabase.getInstance().getReference("vendors").child(userId).child("information");

            username = editText_username.getText().toString();
            phno = Long.parseLong(editText_phno.getText().toString());

            personalInformation vendorInfo = new personalInformation(username, phno);
            databaseReferenceVendorId.setValue(vendorInfo);
        }
        catch (Exception e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        if(v == btn){
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
                        vendorInformationAdd();
                        finish();
                        startActivity(new Intent(getApplicationContext(), Welcome_screen.class));
                    }
                }
            });
        }
    }
}
