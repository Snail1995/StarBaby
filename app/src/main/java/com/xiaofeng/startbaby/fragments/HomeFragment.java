package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.TabsRecycleAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public static final int TYPE_STATES_1 = 1;
    public static final int TYPE_STATES_2 = 2;

    private Activity mActivity;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private CheckBox mCheckBox;

    // 2代表 RecyGSON， 1代表 显示
    private int type = TYPE_STATES_1;
    private LinearLayout mSortLayout;
    private LinearLayout mPagerLayout;

    private List<String> tabTitle = new ArrayList<>();

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
//        EventBus.getDefault().register(getActivity());
        initView(ret);
        initData();
        initListener();
        return ret;
    }

    private void initView(View ret) {
        mTabLayout = ((TabLayout) ret.findViewById(R.id.home_tab_layout));
        mViewPager = ((ViewPager) ret.findViewById(R.id.home_view_pager));
        mRecyclerView = ((RecyclerView) ret.findViewById(R.id.home_recy_view));
        mCheckBox = ((CheckBox) ret.findViewById(R.id.home_tab_check));
        mSortLayout = ((LinearLayout) ret.findViewById(R.id.home_sort_layout));
        mPagerLayout = ((LinearLayout) ret.findViewById(R.id.home_recy_layout));
    }

    private void initData() {
        TabsRecycleAdapter tabsAdapter = new TabsRecycleAdapter();
        mRecyclerView.setAdapter(tabsAdapter);
        // 两者关联
        mTabLayout.setupWithViewPager(mViewPager);
        // 设置可以滑动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    private void initListener() {
        mCheckBox.setOnClickListener(this);

    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.home_tab_check:
                moniterSort();
                break;
        }
    }

    private void moniterSort() {
        mCheckBox.setBackgroundResource(R.drawable.up);
        if (type == TYPE_STATES_1) {
            mSortLayout.setVisibility(View.VISIBLE);
            mPagerLayout.setVisibility(View.GONE);
            type = TYPE_STATES_2;
        } else if (type == TYPE_STATES_2) {
            mSortLayout.setVisibility(View.GONE);
            mPagerLayout.setVisibility(View.VISIBLE);
            type = TYPE_STATES_1;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
