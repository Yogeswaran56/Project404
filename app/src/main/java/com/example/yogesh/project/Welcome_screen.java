package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Welcome_screen extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private CardView cardView_schedule, cardView_summary, cardView_update, cardView_orders, cardView_addproducts, cardView_dashboard, cardView_transport;
    private Button button_logout;
    private CardView card_market,card_weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, vendor_login.class));
        }

        cardView_schedule = findViewById(R.id.card_schedule);
        cardView_summary = findViewById(R.id.card_summary);
        cardView_update = findViewById(R.id.card_update);
        cardView_addproducts = findViewById(R.id.card_products);
        cardView_dashboard = findViewById(R.id.card_dashboard);
        cardView_orders = findViewById(R.id.card_orders);
        card_market = findViewById(R.id.card_marketview);
        card_weather = findViewById(R.id.card_weather);
        button_logout = findViewById(R.id.btn_logout);
        cardView_transport = findViewById(R.id.card_transport);

        cardView_transport.setOnClickListener(this);
        cardView_dashboard.setOnClickListener(this);
        cardView_schedule.setOnClickListener(this);
        cardView_summary.setOnClickListener(this);
        cardView_orders.setOnClickListener(this);
        cardView_addproducts.setOnClickListener(this);
        cardView_update.setOnClickListener(this);
        cardView_summary.setOnClickListener(this);
        card_market.setOnClickListener(this);
        card_weather.setOnClickListener(this);
        button_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == cardView_schedule) {
            startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_addproducts) {
                startActivity(new Intent(this, add_products.class));
        }

        if(v == cardView_dashboard) {
            startActivity(new Intent(this, dashboard.class));
        }

        if(v == cardView_orders) {
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_summary) {
            //startActivity(new Intent(this, schedule.class));
        }

        if(v == cardView_update) {
            startActivity(new Intent(this, daily_update.class));
        }

        if(v == card_market) {
            startActivity(new Intent(this, marketWebView.class));
        }

        if(v == card_weather) {
            startActivity(new Intent(this, weatherwebview.class));
        }

        if(v == cardView_transport) {
            startActivity(new Intent(this, transport.class));
        }

        if(v == button_logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, vendor_login.class));
        }
    }
}
