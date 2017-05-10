package com.xiaofeng.startbaby.fragments;


import android.support.v4.app.Fragment;

import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.StartBabyApplication;
import com.xiaofeng.startbaby.fragments.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeEssenceFragment extends LazyLoadFragment {


    public HomeEssenceFragment() {
        // Required empty public constructor
    }

    @Override
    protected int setContentView() {
        int ret = 0;
        ret = R.layout.fragment_home_essence;
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
        return StartBabyApplication.FRAGMENT_TITLR_STRING[3];
    }
}
