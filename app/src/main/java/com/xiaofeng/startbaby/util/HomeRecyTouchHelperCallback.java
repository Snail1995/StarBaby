package com.xiaofeng.startbaby.util;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.xiaofeng.startbaby.interfaces.OnMoveAndSwipedListener;

/**
 * 首页中RecycleView的拖拽排序事件
 */
public class HomeRecyTouchHelperCallback extends ItemTouchHelper.Callback {

    private OnMoveAndSwipedListener mAdapter;

    public HomeRecyTouchHelperCallback(OnMoveAndSwipedListener adapter) {
        this.mAdapter = adapter;
    }

    /**
     * 拖动与侧滑的方向
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 如果是ListView样式的RecyclerView
        // 设置拖拽方向为上下
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // 将方向参数设置进去
        // 我这里没有进行侧滑的处理，所以将 makeMovementFlags(dragFlags, swipeFlags)中第二个参数设置为0，表示不进行侧滑操作
        return makeMovementFlags(dragFlags, 0);
    }

    /**
     * 拖动回调的方法
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // 如果两个item不是一个类型的，我们让他不可以拖拽
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 侧滑时回调的方法
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
