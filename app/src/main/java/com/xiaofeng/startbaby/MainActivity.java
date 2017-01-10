package com.xiaofeng.startbaby;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.xiaofeng.startbaby.fragments.CommunityFragment;
import com.xiaofeng.startbaby.fragments.HomeFragment;
import com.xiaofeng.startbaby.fragments.PersonFragment;
import com.xiaofeng.startbaby.fragments.VideoFragment;
import com.xiaofeng.startbaby.mvp.model.MainModel;
import com.xiaofeng.startbaby.mvp.prestener.MainPresenter;
import com.xiaofeng.startbaby.mvp.view.MainView;
import com.xiaofeng.startbaby.mvpouther.MvpActivity;

import java.util.ArrayList;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView, RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private RadioButton mRadioHome;
    private RadioButton mRadioVideo;
    private RadioButton mRadioCommunity;
    private RadioButton mRadioPerson;
    private FragmentManager mFragmentManager;


    private ArrayList<Fragment> mFragments;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_raoup);
        mRadioHome = (RadioButton) findViewById(R.id.main_radio_1);
        mRadioVideo = (RadioButton) findViewById(R.id.main_radio_2);
        mRadioCommunity = (RadioButton) findViewById(R.id.main_radio_3);
        mRadioPerson = (RadioButton) findViewById(R.id.main_radio_4);
//        mRecyclerView = (RecyclerView) findViewById(R.id.person_recycler_view);
    }

    private void initListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void initData() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.main_frag, new HomeFragment());
        transaction.commit();
        setDrawable(R.drawable.home_2, R.id.main_radio_1, R.color.colorPrimary);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment fragment = getInstanceByIndex(checkedId);
        transaction.replace(R.id.main_frag, fragment);
        transaction.commit();
    }

    public Fragment getInstanceByIndex(int index) {
        Fragment ret = null;
        switch (index) {
            case R.id.main_radio_1:
                ret = new HomeFragment();
                setDrawable(R.drawable.home_2, R.id.main_radio_1, R.color.colorPrimary);
                setDrawable(R.drawable.video, R.id.main_radio_2, R.color.black);
                setDrawable(R.drawable.community, R.id.main_radio_3, R.color.black);
                setDrawable(R.drawable.person, R.id.main_radio_4, R.color.black);
                break;
            case R.id.main_radio_2:
                ret = new VideoFragment();
                setDrawable(R.drawable.home, R.id.main_radio_1, R.color.black);
                setDrawable(R.drawable.video_2, R.id.main_radio_2, R.color.colorPrimary);
                setDrawable(R.drawable.community, R.id.main_radio_3, R.color.black);
                setDrawable(R.drawable.person, R.id.main_radio_4, R.color.black);
                break;
            case R.id.main_radio_3:
                ret = new CommunityFragment();
                setDrawable(R.drawable.home, R.id.main_radio_1, R.color.black);
                setDrawable(R.drawable.video, R.id.main_radio_2, R.color.black);
                setDrawable(R.drawable.community_2, R.id.main_radio_3, R.color.colorPrimary);
                setDrawable(R.drawable.person, R.id.main_radio_4, R.color.black);
                break;
            case R.id.main_radio_4:
                ret = new PersonFragment();
                setDrawable(R.drawable.home, R.id.main_radio_1, R.color.black);
                setDrawable(R.drawable.video, R.id.main_radio_2, R.color.black);
                setDrawable(R.drawable.community, R.id.main_radio_3, R.color.black);
                setDrawable(R.drawable.person_2, R.id.main_radio_4, R.color.colorPrimary);
                break;
            default:
                ret = null;
                break;
        }
        return ret;
    }

    private void setDrawable(int checkedPic, int checkedId, int color) {
        Drawable mDrawable = null;
        switch (checkedId) {
            case R.id.main_radio_1:
                mDrawable = getResources().getDrawable(checkedPic);
                mRadioHome.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable, null, null);
                mRadioHome.setTextColor(getTextColor(color));
                break;
            case R.id.main_radio_2:
                mDrawable = getResources().getDrawable(checkedPic);
                mRadioVideo.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable, null, null);
                mRadioVideo.setTextColor(getTextColor(color));
                break;
            case R.id.main_radio_3:
                mDrawable = getResources().getDrawable(checkedPic);
                mRadioCommunity.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable, null, null);
                mRadioCommunity.setTextColor(getTextColor(color));
                break;
            case R.id.main_radio_4:
                mDrawable = getResources().getDrawable(checkedPic);
                mRadioPerson.setCompoundDrawablesWithIntrinsicBounds(null, mDrawable, null, null);
                mRadioPerson.setTextColor(getTextColor(color));
                break;
        }
    }

    private int getTextColor(int colorPrimary) {
        int color = getResources().getColor(colorPrimary);
        return color;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(MainModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

}
