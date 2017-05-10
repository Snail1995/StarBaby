package com.xiaofeng.startbaby;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class StartBabyApplication extends Application {
    public static final String[] FRAGMENT_TITLR_STRING = {"推荐", "精华", "训练", "交流"};
    public static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
}


