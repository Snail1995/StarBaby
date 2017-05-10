package com.xiaofeng.startbaby.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.StartBabyApplication;
import com.xiaofeng.startbaby.fragments.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTrainFragment extends LazyLoadFragment {


    public HomeTrainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_train, container, false);
    }

    @Override
    protected int setContentView() {
        int ret = R.layout.fragment_home_train;
        return ret;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void stopLoad() {

    }

    @Override
    public String getFragmentTitle() {
        return StartBabyApplication.FRAGMENT_TITLR_STRING[1];

    }
}
