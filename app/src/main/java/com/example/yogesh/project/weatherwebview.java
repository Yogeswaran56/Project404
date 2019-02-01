package com.example.yogesh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class weatherwebview extends AppCompatActivity {

    private WebView weatherview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherwebview);

        weatherview = (WebView)findViewById(R.id.weather);
        weatherview.loadUrl("https://www.weatheronline.in/TamilNadu.htm");
    }
}
