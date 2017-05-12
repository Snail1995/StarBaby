package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.ViewPagerAdapter;
import com.xiaofeng.startbaby.client.CommunityClientAPI;
import com.xiaofeng.startbaby.fragments.community.ExChangeFragment;
import com.xiaofeng.startbaby.fragments.community.FollowFragment;
import com.xiaofeng.startbaby.fragments.community.KnowFragment;
import com.xiaofeng.startbaby.fragments.community.TrianFragment;
import com.xiaofeng.startbaby.model.CommunityInfo;
import com.xiaofeng.startbaby.mvpouther.BasePresenter;
import com.xiaofeng.startbaby.mvpouther.MvpFragment;
import com.xiaofeng.startbaby.view.VerticalTabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends MvpFragment {
    private static final String TAG = "CommunityFragment";
    public static final String URL = "http://gd.kuaisulu.com/mobcent/app/web/index.php?r=forum/forumlist";

    private Activity mActivity;
    private VerticalTabLayout mTabLayout;
    private ViewPager mViewPager;

    List<Fragment> mFragments = new ArrayList<>();
    private FrameLayout mProgressBarLayout;

    public CommunityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        // 修改StateBar的状态栏颜色
        StatusBarCompat.setStatusBarColor(mActivity, getMyColor(R.color.colorPrimary), false);
//        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_community, container, false);
        initData();
        initTabLayout(ret);
//        mProgressBarLayout = ((FrameLayout) ret.findViewById(R.id.progress_bar_layout));
        return ret;

    }

    private void initData() {
        CommunityClientAPI.getCommunityData(URL);
        mFragments.add(new FollowFragment());
        mFragments.add(new KnowFragment());
        mFragments.add(new TrianFragment());
        mFragments.add(new ExChangeFragment());
    }


    private void initTabLayout(View ret) {
        mTabLayout = (VerticalTabLayout) ret.findViewById(R.id.tablayout);
        mViewPager = ((ViewPager) ret.findViewById(R.id.viewpager));
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), mFragments, getContext()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private int getMyColor(int id) {
        return getResources().getColor(id);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(CommunityInfo info) {
//        if (info != null) {
//            mProgressBarLayout.setVisibility(View.INVISIBLE);
//        }
//    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onDestroy() {
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
