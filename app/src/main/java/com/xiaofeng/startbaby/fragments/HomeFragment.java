package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.HomeViewPagerAdapter;
import com.xiaofeng.startbaby.fragments.base.LazyLoadFragment;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private Activity mActivity;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    private List<String> tabTitle = new ArrayList<>();
    private TextView mHomeSearchText;

    private List<LazyLoadFragment> mFrgments;
    private HomeViewPagerAdapter mViewPagerAdapter;

    public HomeFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
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
        View ret = inflater.inflate(R.layout.fragment_home, container, false);
        initView(ret);
        initData();
        initListener();
        return ret;
    }

    private void initView(View ret) {
        mTabLayout = ((TabLayout) ret.findViewById(R.id.home_tab_layout));
        mViewPager = ((ViewPager) ret.findViewById(R.id.home_view_pager));
        mHomeSearchText = (TextView) ret.findViewById(R.id.home_text_search);
    }

    private void initData() {
        mFrgments = new ArrayList<>();
        mViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(), mFrgments);
        mViewPager.setOffscreenPageLimit(0);
        // 两者关联
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mViewPagerAdapter);
        mViewPager.setAdapter(mViewPagerAdapter);
        // 设置可以滑动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
    }

    private void initViewPager() {
        for (int i = 0; i < 2; i++) {
            mFrgments.add(new HomeRecommendFragment());
            mFrgments.add(new HomeEssenceFragment());
            mFrgments.add(new HomeTrainFragment());
            mFrgments.add(new HomeExChangeFragment());
        }
        mViewPagerAdapter.notifyDataSetChanged();
    }

    private void initListener() {
        mHomeSearchText.setOnClickListener(this);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.activity_argeen_ment:
                break;
            case R.id.home_text_search:
                Intent intent = new Intent();
                intent.setClassName(getContext(), "com.xiaofeng.startbaby.ui.HomeSearchActivity");
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
