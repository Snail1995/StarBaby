package com.xiaofeng.startbaby.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.xiaofeng.startbaby.R;
import com.xiaofeng.startbaby.adapter.base.BaseRecyclerAdapter;
import com.xiaofeng.startbaby.adapter.base.CommonHolder;
import com.xiaofeng.startbaby.model.Photo;
import com.xiaofeng.startbaby.util.ToastUtil;

import butterknife.Bind;

/**
 * Created by lcodecore on 2016/12/7.
 */

public class PhotoAdapter extends BaseRecyclerAdapter<Photo> {
    @Override
    public CommonHolder<Photo> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Photo> {

        @Bind(R.id.tv_info)
        TextView tv_info;

        @Bind(R.id.iv_pic)
        ImageView iv_pic;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_home_recommend_recycler);
        }

        @Override
        public void bindData(Photo photo) {
            iv_pic.setImageResource(photo.imgSrc);
            tv_info.setText(photo.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //点击事件
                    ToastUtil.show("item clicked!");
                }
            });
        }
    }
}