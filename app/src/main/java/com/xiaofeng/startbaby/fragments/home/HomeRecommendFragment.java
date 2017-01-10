package com.xiaofeng.startbaby.fragments.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.mvpouther.BasePresenter;
import com.xiaofeng.startbaby.mvpouther.MvpFragment;

public class HomeRecommendFragment extends MvpFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_home_recommend, container, false);

        return ret;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    /*@Override
    protected String getTitle() {
        return "推荐";
    }*/
}
