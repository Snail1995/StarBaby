package com.xiaofeng.startbaby.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.githang.statusbar.StatusBarCompat;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.HomeViewPagerAdapter;
import com.xiaofeng.startbaby.adapter.ViewPagerAdapter;
import com.xiaofeng.startbaby.fragments.community.ExChangeFragment;
import com.xiaofeng.startbaby.fragments.community.FollowFragment;
import com.xiaofeng.startbaby.fragments.community.KnowFragment;
import com.xiaofeng.startbaby.fragments.community.TrianFragment;
import com.xiaofeng.startbaby.mvpouther.BasePresenter;
import com.xiaofeng.startbaby.mvpouther.MvpFragment;
import com.xiaofeng.startbaby.util.MenuBean;
import com.xiaofeng.startbaby.view.TabAdapter;
import com.xiaofeng.startbaby.view.VerticalTabLayout;
import com.xiaofeng.startbaby.view.widget.QTabView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends MvpFragment {
    private static final String TAG = "CommunityFragment";

    private Activity mActivity;
    private VerticalTabLayout mTabLayout;
    private ViewPager mViewPager;

    List<Fragment> mFragments = new ArrayList<>();

    public CommunityFragment() {
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
        View ret = inflater.inflate(R.layout.fragment_community, container, false);
        initData();
        initTabLayout(ret);
        return ret;

    }

    private void initData() {
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

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    class MyPagerAdapter extends FragmentPagerAdapter implements TabAdapter {
        List<MenuBean> menus;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            menus = new ArrayList<>();
            // 可以在条目上添加图片
            Collections.addAll(menus, new MenuBean(0, 5, "我的关注")
                    , new MenuBean(0, 5, "认识自闭症")
                    , new MenuBean(0, 5, "自闭症训练")
                    , new MenuBean(0, 5, "自闭症交流"));
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public int getBadge(int position) {
            return position * 10;
        }

        @Override
        public QTabView.TabIcon getIcon(int position) {
            MenuBean menu = menus.get(position);
            return new QTabView.TabIcon.Builder()
                    .setIcon(menu.mSelectIcon, menu.mNormalIcon)
                    .setIconGravity(Gravity.LEFT)
                    .setIconMargin(dp2px(5))
                    .setIconSize(dp2px(20), dp2px(20))
                    .build();
        }

        @Override
        public QTabView.TabTitle getTitle(int position) {
            MenuBean menu = menus.get(position);
            return new QTabView.TabTitle.Builder(getContext())
                    .setContent(menu.mTitle)
                    .setTextColor(0xFF41ACE4, 0xFF757575)
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return 0;
        }


        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            TextView tv = new TextView(getContext());
//            // 加载的ViewPager 的布局
//            tv.setText("" + position + "fhj");
//            container.addView(tv);
////            Fragment fragment = mFragments.get(position);
////            container.addView(fragment);
//            return tv;
//        }

//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
    }

    protected int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
