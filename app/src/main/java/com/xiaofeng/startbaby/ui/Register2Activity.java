package com.xiaofeng.startbaby.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;

public class Register2Activity extends AppCompatActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(this, getMyColor(R.color.colorPrimaryO), true);
        setSupportActionBar(mToolBar);
        initView();
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.register2_tool_bar);
    }


    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

}
