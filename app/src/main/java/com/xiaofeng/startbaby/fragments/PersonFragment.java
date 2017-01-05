package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.base.BaseFragment;
import com.xiaofeng.startbaby.ui.LoginActivity;
import com.xiaofeng.startbaby.ui.PersonDetailsActivity;
import com.xiaofeng.startbaby.util.ConstantUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment implements View.OnClickListener {


    private View mUserPic;
    private Context mContext;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;
    private Activity mActivity;

    public PersonFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mActivity = getActivity();
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(mActivity, getMyColor(R.color.white), true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_person, container, false);
        initView(ret);
        initListener();
        initData();
        return ret;
    }

    private void initData() {
        mSp = mContext.getSharedPreferences(ConstantUtils.LOGIN_STATE, Context.MODE_PRIVATE);
        mEditor = mSp.edit();
    }

    private void initListener() {
        mUserPic.setOnClickListener(this);
    }

    private void initView(View ret) {
        mUserPic = ret.findViewById(R.id.person_user_image);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.person_user_image:
                boolean isLogin = mSp.getBoolean("isLogin", false);
                Intent intent = null;
                if (isLogin) {
                    intent = new Intent(mContext, PersonDetailsActivity.class);
                } else {
                    intent = new Intent(mContext, LoginActivity.class);
                }
                startActivity(intent);
                break;
        }
    }


    private String getMyString(int id) {
        return getResources().getString(id);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }
}
