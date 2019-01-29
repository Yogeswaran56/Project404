package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Welcome_screen extends AppCompatActivity implements View.OnClickListener {

    CardView cardView_schedule, cardView_summary, cardView_update, cardView_orders, cardView_addproducts, cardView_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        cardView_schedule = findViewById(R.id.card_schedule);
        cardView_summary = findViewById(R.id.card_summary);
        cardView_update = findViewById(R.id.card_update);
        cardView_addproducts = findViewById(R.id.card_products);
        cardView_dashboard = findViewById(R.id.card_dashboard);
        cardView_orders = findViewById(R.id.card_orders);

        cardView_schedule.setOnClickListener(this);
        cardView_summary.setOnClickListener(this);
        cardView_orders.setOnClickListener(this);
        cardView_addproducts.setOnClickListener(this);
        cardView_update.setOnClickListener(this);
        cardView_summary.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == cardView_schedule) {
            finish();
            startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_addproducts) {
            finish();
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_dashboard) {
            finish();
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_orders) {
            finish();
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_summary) {
            finish();
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_update) {
            finish();
            //startActivity(new Intent(this, schedule.class));
        }
    }
}
