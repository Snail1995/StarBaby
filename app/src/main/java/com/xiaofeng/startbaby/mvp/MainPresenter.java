package com.xiaofeng.startbaby.mvp;

import com.xiaofeng.startbaby.mvpouther.BasePresenter;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class MainPresenter extends BasePresenter<MainView>{
    public MainPresenter(MainView view) {
        attachView(view);
    }

    // 本Presenter 是对应与MainActivity的业务逻辑处理

}
