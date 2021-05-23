package com.vmate.thenewsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vmate.thenewsapp.R;

public class MYWebview extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    String url;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywebview);

        initi();


    }

    private void initi() {

        webView = findViewById(R.id.web);
        progressBar = findViewById(R.id.progress);
        textView = findViewById(R.id.title);
        progressBar.setVisibility(View.VISIBLE);
        setwebview();


}

    private void setwebview() {
        url = getIntent().getExtras().getString("url","");
     //   String title = getIntent().getExtras().getString("title","");

       // textView.setText(title);

        if (url.equals("") || url.equals(null))
        {
            Toast.makeText(this, "News not found", Toast.LENGTH_SHORT).show();
        }
        else {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {

                    progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(MYWebview.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            webView.loadUrl(url);

        }
    }
    }