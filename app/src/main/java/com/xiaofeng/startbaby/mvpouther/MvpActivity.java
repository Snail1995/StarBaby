package com.xiaofeng.startbaby.mvpouther;

import android.os.Bundle;

import com.xiaofeng.startbaby.base.BaseActivity;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mvpPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
