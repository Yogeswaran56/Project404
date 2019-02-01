package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class OrderListView extends AppCompatActivity implements View.OnClickListener{

    private CardView cd1,cd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_view);
        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd1.setOnClickListener(this);
        cd2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == cd1) {
            startActivity(new Intent(this, ratingOrder.class));
        }
        //if (v == cd2) {
        //   startActivity(new Intent(this, schedule.class));
        //}
    }


}
