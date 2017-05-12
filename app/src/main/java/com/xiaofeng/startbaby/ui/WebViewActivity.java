package com.xiaofeng.startbaby.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.xiaofeng.startbaby.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadUrl("http://gd.kuaisulu.com/mobcent/app/web/index.php?r=webapp/share&tid=72389&forumKey=");

    }
}
