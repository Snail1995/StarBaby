package com.xiaofeng.startbaby.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.xiaofeng.startbaby.fragments.base.LazyLoadFragment;

import java.util.List;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/5/8.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<LazyLoadFragment> mFrgments;

    public HomeViewPagerAdapter(FragmentManager fm, List<LazyLoadFragment> fragments) {
        super(fm);
        mFrgments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFrgments.get(position);
    }

    @Override
    public int getCount() {
        return mFrgments != null ? mFrgments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFrgments.get(position).getFragmentTitle();
    }
}
