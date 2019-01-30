package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class classification extends AppCompatActivity {
    private Button customer;
    private Button vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        customer = (Button) findViewById(R.id.customer);
        vendor = (Button) findViewById(R.id.vendor);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(classification.this, customerlogin.class);
                startActivity(i);
            }
        });
        vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(classification.this, vendor_login.class);
                startActivity(i);
            }
        });
    }
}

