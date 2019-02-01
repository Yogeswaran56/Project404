package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ratingOrder extends AppCompatActivity implements View.OnClickListener {
    private Button btnrating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_order);
        btnrating = (Button) findViewById(R.id.btnrating);
        btnrating.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btnrating){
            Intent i = new Intent(ratingOrder.this, custo_home_page.class);
            startActivity(i);
        }

    }
}
