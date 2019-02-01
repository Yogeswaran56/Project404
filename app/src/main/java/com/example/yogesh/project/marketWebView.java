package com.example.yogesh.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class marketWebView extends AppCompatActivity {

    private WebView wbview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_web_view);

        wbview = (WebView)findViewById(R.id.webview);
        wbview.loadUrl("http://www.livechennai.com/Vegetable_price_chennai.asp");
    }
}
