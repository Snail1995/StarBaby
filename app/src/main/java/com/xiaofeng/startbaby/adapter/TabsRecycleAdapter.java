package com.xiaofeng.startbaby.adapter;

/**
 * Created by Administrator on 2017/1/10 0010.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xiaofeng.startbaby.interfaces.OnMoveAndSwipedListener;

/**
 * 首页Recycleview 拖动排序的适配器
 */
public class TabsRecycleAdapter extends RecyclerView.Adapter<TabsRecycleAdapter.TabViewHolder> implements OnMoveAndSwipedListener {
    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * @param fromPosition
     * @param toPosition
     * @return
     */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
//        Collections.swap(, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    public class TabViewHolder extends RecyclerView.ViewHolder {

        public TabViewHolder(View itemView) {
            super(itemView);
        }
    }
}
