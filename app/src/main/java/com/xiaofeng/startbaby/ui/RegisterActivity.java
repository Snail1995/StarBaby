package com.xiaofeng.startbaby.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private TextView mRegisterAgreenment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(this, getMyColor(R.color.colorPrimaryO), true);
        setSupportActionBar(mToolBar);
        initView();
        initData();
    }

    private void initData() {

        String str = "点击“注册”按钮，即代表你同意《星baby使用协议》";
        SpannableString ss = new SpannableString(str);
        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, ArgeenMentActivity.class));
            }
        }, 15, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //SPAN_EXCLUSIVE_EXCLUSIVE从字符串0-text1.length任意位置触发点击事件

        mRegisterAgreenment.setText(ss);
        // 必须有这句话，否则链接都将不会起作用
        mRegisterAgreenment.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.register_tool_bar);
        mRegisterAgreenment = (TextView) findViewById(R.id.fastRegister);
    }


    private String getMyString(int id) {
        return getResources().getString(id);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }
}
