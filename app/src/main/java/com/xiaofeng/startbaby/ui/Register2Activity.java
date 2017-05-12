package com.xiaofeng.startbaby.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;

public class Register2Activity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolBar;
    private ImageView mIamgeBack;

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
        mIamgeBack = (ImageView) findViewById(R.id.register_go_back);
        initEvent();
    }

    private void initEvent() {
        mIamgeBack.setOnClickListener(this);
    }


    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_go_back:
                finish();
                break;
        }
    }
}
