package com.xiaofeng.startbaby.util;

import android.widget.Toast;

import com.xiaofeng.startbaby.StartBabyApplication;


/**
 * Created by lcodecore on 2017/2/28.
 */

public class ToastUtil {
    public static void show(String msg){
        Toast.makeText(StartBabyApplication.appContext, msg, Toast.LENGTH_SHORT).show();
    }
}
