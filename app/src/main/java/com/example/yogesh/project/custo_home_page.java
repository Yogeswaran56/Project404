package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class custo_home_page extends AppCompatActivity {
    private Button prod;
    private Button announce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_home_page);
        try {
            prod = (Button) findViewById(R.id.prod);
            announce = (Button) findViewById(R.id.announce);
            prod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(custo_home_page.this, homelist.class);
                    startActivity(i);
                }
            });
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
}
