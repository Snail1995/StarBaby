package com.xiaofeng.startbaby.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xiaofeng.startbaby.R;

public class ArgeenMentActivity extends AppCompatActivity {

    private WebView mWebView;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argeen_ment);
        mWebView = (WebView) findViewById(R.id.argeenment);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mUrl = "file:///android_asset/agreenment.html";
        mWebView.loadUrl(mUrl);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 进行网址拦截，
                if (url.trim().equals("http://www.baidu.com/")) {
                    // 可以跳入Activity， 或者重定向
                }
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        if (mWebView.canGoForward()) {
            mWebView.goForward();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
