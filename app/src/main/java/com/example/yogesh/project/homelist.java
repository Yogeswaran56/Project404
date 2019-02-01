package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class homelist extends AppCompatActivity implements View.OnClickListener{
    private CardView veg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelist);
        veg = findViewById(R.id.vegecard);

        veg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == veg) {
            startActivity(new Intent(this, vegetables.class));
        }
    }
}
