package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class wholesaler_home extends AppCompatActivity {
    private CardView sellingprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesaler_home);

        sellingprice=(Button)findViewById(R.id.selling_price);
        sellingprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(wholesaler_home.this,add_products.class);
                startActivity(i);
            }
        });


    }
}
