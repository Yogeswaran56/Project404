package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class custo_home_page extends AppCompatActivity implements  View.OnClickListener{
    private Button prod;
    private Button announce, button_logout;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_home_page);
        try {
            prod = (Button) findViewById(R.id.prod);
            announce = (Button) findViewById(R.id.announce);
            button_logout = findViewById(R.id.btn_logout_customer);
            firebaseAuth = FirebaseAuth.getInstance();

            button_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(getApplicationContext(), customerlogin.class));
                    }
                    catch(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            prod.setOnClickListener(this);
            /*prod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent i = new Intent(custo_home_page.this, homelist.class);
                        startActivity(i);
                    }
                    catch(Exception e){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });*/
            announce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(custo_home_page.this, custom_announcementList.class);
                    startActivity(i);
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==prod){
            try {
                Intent i = new Intent(custo_home_page.this, homelist.class);
                startActivity(i);
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
