package com.xiaofeng.startbaby.adapter.community;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.model.CommunityInfo;

import java.util.List;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/5/13.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<CommunityInfo.CommunityInfoImpl> mCommunityInfos;
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;

    public RecyclerViewAdapter(List<CommunityInfo.CommunityInfoImpl> communityInfos, Context context) {
        mCommunityInfos = communityInfos;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_recommend_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommunityInfo.CommunityInfoImpl info = mCommunityInfos.get(position);
        Glide.with(mContext)
                .load(info.getBoard_img())
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(holder.mImage);
        holder.mCount.setText(info.getFavNum());
        holder.mTitle.setText(info.getBoard_name());
        Log.d(TAG, "onBindViewHolder: " + info.getBoard_img());
    }

    @Override
    public int getItemCount() {
        return mCommunityInfos != null ? mCommunityInfos.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImage;
        private final TextView mTitle;
        private final TextView mCount;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.item_commend_image);
            mTitle = ((TextView) itemView.findViewById(R.id.item_commend_title));
            mCount = ((TextView) itemView.findViewById(R.id.item_commend_count));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO： 点击跳入新的Activity，
                }
            });
        }
    }
}
