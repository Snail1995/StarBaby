package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private Activity mActivity;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(mActivity, getMyColor(R.color.colorPrimary), false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

}
