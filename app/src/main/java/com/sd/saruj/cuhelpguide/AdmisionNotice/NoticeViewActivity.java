package com.sd.saruj.cuhelpguide.AdmisionNotice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sd.saruj.cuhelpguide.R;

public class NoticeViewActivity extends AppCompatActivity {

    private Toolbar noticeViewToolbar;

    private WebView webView;
    private ProgressBar progressBar;
    private String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_view);

        noticeViewToolbar = findViewById(R.id.notice_view_toolbar);
        setSupportActionBar(noticeViewToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Admission Notice");

        webView = findViewById(R.id.notice_view_WebView);
        progressBar = findViewById(R.id.notice_view_ProgressBar);
        progressBar.setVisibility(View.VISIBLE);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient());

//        final int position = getIntent().getIntExtra("position",0);
         url = getIntent().getStringExtra("url");
//        Log.e("TAG", " url:  "+ url +"  position:  "+ position ) ;


        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                //===========   this link is remove pdf download option
//                webView.loadUrl("javascript:(function() { " +
//                        "document.querySelector('[role=\"toolbar\"]').remove();})()");
                progressBar.setVisibility(View.GONE);
            }
        });
        //https://docs.google.com/viewerng/viewer?embedded=true&url=
        //this link for show from pdf in web page
//        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+MainActivity.list.get(position).getPdfUrl());
        //========   thsi link for google drive..
        webView.loadUrl(url);

    }
}
