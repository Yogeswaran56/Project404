package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class homelist extends AppCompatActivity implements View.OnClickListener {
    private CardView vegecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelist);
        vegecard = findViewById(R.id.vegecard);


        vegecard.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View view) {
        if(view == vegecard) {
            startActivity(new Intent(this, vegetables.class));
        }
    }
}
