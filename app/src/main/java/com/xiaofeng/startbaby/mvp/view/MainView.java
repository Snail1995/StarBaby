package com.xiaofeng.startbaby.mvp.view;

import com.xiaofeng.startbaby.mvp.model.MainModel;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public interface MainView extends BaseView {
    void getDataSuccess(MainModel modle);
    void getDataFail(String msg);
}
