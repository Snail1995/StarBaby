package com.xiaofeng.startbaby.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Gravity;

import com.xiaofeng.startbaby.fragments.base.LazyLoadFragment;
import com.xiaofeng.startbaby.util.MenuBean;
import com.xiaofeng.startbaby.view.TabAdapter;
import com.xiaofeng.startbaby.view.widget.QTabView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/5/8.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter implements TabAdapter {
    private List<Fragment> mFrgments;
    List<MenuBean> menus;
    private Context mContext;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, Context context) {
        super(fm);
        mFrgments = fragments;
        mContext = context;
        menus = new ArrayList<>();
        // 可以在条目上添加图片
        Collections.addAll(menus, new MenuBean(0, 5, "我的关注")
                , new MenuBean(0, 5, "认识自闭症")
                , new MenuBean(0, 5, "自闭症训练")
                , new MenuBean(0, 5, "自闭症交流"));
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
        return new QTabView.TabTitle.Builder(mContext)
                .setContent(menu.mTitle)
                .setTextColor(0xFF41ACE4, 0xFF757575)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }

    protected int dp2px(float dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
