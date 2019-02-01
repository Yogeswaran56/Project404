package com.example.yogesh.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class marketWebView extends AppCompatActivity {

    private WebView wbview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_web_view);

        try{
            wbview = (WebView)findViewById(R.id.webview);
            wbview.loadUrl("http://www.livechennai.com/Vegetable_price_chennai.asp");
        }
        catch (Exception e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
