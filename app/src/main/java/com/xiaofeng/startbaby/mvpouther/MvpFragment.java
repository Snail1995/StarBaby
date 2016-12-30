package com.xiaofeng.startbaby.mvpouther;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xiaofeng.startbaby.base.BaseFragment;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mvpPresenter = createPresenter();
        }
    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
