package com.xiaofeng.startbaby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.base.BaseActivity;

import java.net.URL;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {

    private TextView mFastLogin;
    private ImageView mLoginGoBack;
    private Toolbar mToolBar;
    private EditText mLoginUser;
    private EditText mLoginPass;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(this, getMyColor(R.color.colorPrimaryO), true);
        ActionBar actionBar = getSupportActionBar();
        setSupportActionBar(mToolBar);
        initView();
        initData();
        initListener();
    }


    private void initListener() {
        mFastLogin.setOnClickListener(this);
        mLoginGoBack.setOnClickListener(this);
        mLoginPass.addTextChangedListener(this);
    }

    private void initData() {
        /*mFastLogin.setText(Html.fromHtml("<font color=\'#858585\'> " + getMyString(R.string.user_no_number) + "</font>" +
                "<a href='http://www.baidu.com'>" + getMyString(R.string.fast_login)
                + "</a>"));
        // 必须有这句话，否则链接都将不会起作用
        mFastLogin.setMovementMethod(LinkMovementMethod.getInstance());*/

        SpannableString ss = new SpannableString("没有帐号? 点击注册");
        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        }, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //SPAN_EXCLUSIVE_EXCLUSIVE从字符串0-text1.length任意位置触发点击事件

        mFastLogin.setText(ss);
        mFastLogin.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.login_tool_bar);
        mLoginUser = (EditText) findViewById(R.id.login_edit_user);
        mLoginPass = (EditText) findViewById(R.id.login_edit_pass);
        mBtnLogin = (Button) findViewById(R.id.login_btn_login);
        mFastLogin = (TextView) findViewById(R.id.fastLogin);
        mLoginGoBack = (ImageView) findViewById(R.id.login_go_back);


    }

    private String getMyString(int id) {
        return getResources().getString(id);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fastLogin:
                break;
            case R.id.login_go_back:
                finish();
                break;
        }
    }

    // EditText的监听事件
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        int length = charSequence.length();
        if (length >= 6) {
            mBtnLogin.setEnabled(true);
            mBtnLogin.setBackgroundColor(getMyColor(R.color.loginTrue));
        } else {
            mBtnLogin.setEnabled(false);
            mBtnLogin.setBackgroundColor(getMyColor(R.color.loginFalse));
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
