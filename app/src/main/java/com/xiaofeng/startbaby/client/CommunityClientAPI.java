package com.xiaofeng.startbaby.client;

import android.util.Log;

import com.google.gson.Gson;
import com.xiaofeng.startbaby.client.impl.OkHttpUtilmpl;
import com.xiaofeng.startbaby.model.CommunityInfo;
import com.xiaofeng.startbaby.mvp.view.BaseView;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/5/13.
 */

public class CommunityClientAPI {
    private static final String TAG = "CommunityClientAPI";
    private static AbstractHttpUtil sHttpUtil;

    static {
        // TODO: 创建特定的网络类库的支持
        sHttpUtil = new OkHttpUtilmpl();
    }

    public CommunityClientAPI() {
    }

    public static void getCommunityData(String url) {
        sHttpUtil.doGetDataAsync(url, new HttpCallback() {
            @Override
            public void onSuccess(String url, int code, byte[] data) {
                try {
                    String str = new String(data, "UTF-8");
                    JSONObject json = new JSONObject(str);
                    JSONArray list = json.optJSONArray("list");
//                    Log.d(TAG, "onSuccess: " + list.toString());
                    Gson gson = new Gson();
                    CommunityInfo info = gson.fromJson(json.toString(), CommunityInfo.class);
                    String img = info.getList().get(0).getBoard_list().get(0).getBoard_img();
                    Log.d(TAG, "onSuccess: " + img);
                    EventBus.getDefault().post(info);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail() {
            }
        });
    }
}
