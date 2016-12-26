package com.xiaofeng.startbaby.mvpouther;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class BasePresenter<V> {
    private V mvpView;

    public void attachView(V view) {
        this.mvpView = view;
    }

    public void detachView() {
        if (this.mvpView != null) {
            this.mvpView = null;
        }
    }
}
