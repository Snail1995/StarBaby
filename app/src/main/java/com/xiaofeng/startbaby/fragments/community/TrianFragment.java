package com.xiaofeng.startbaby.fragments.community;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.community.RecyclerViewAdapter;
import com.xiaofeng.startbaby.model.CommunityInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrianFragment extends Fragment {
    public static final String URL = "http://gd.kuaisulu.com/mobcent/app/web/index.php?r=forum/forumlist";
    private List<CommunityInfo.CommunityInfoImpl> mInfos = new ArrayList<>();

    private RecyclerView mRecycler;
    private RecyclerViewAdapter mAdapter;

    public TrianFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_trian, container, false);
        initView(ret);
        initData();
        return ret;
    }

    private void initData() {
        mAdapter = new RecyclerViewAdapter(mInfos, getContext());
        mRecycler.setAdapter(mAdapter);
    }


    private void initView(View ret) {
        mRecycler = (RecyclerView) ret.findViewById(R.id.follow_recycler_view);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CommunityInfo info) {
        mInfos = info.getList().get(2).getBoard_list();
        mAdapter.notifyDataSetChanged();
        String img = mInfos.get(1).getBoard_img();
        Log.d("TAG", "onEvent: " + img);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}
