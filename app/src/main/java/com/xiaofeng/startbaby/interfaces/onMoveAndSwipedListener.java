package com.xiaofeng.startbaby.interfaces;

/**
 * Created by Administrator on 2017/1/10 0010.
 */

/**
 * 如果我们设置了非0的dragFlags ，那么当item被拖拽的时候会不断的回调onMove方法，
 * 所以我们需要同时Adapter做出相应的改变，对mItems数据做出交换的操作，
 * 因此我们需要一个回调接口来继续回调Adapter中的方法。
 */
public interface OnMoveAndSwipedListener {
    boolean onItemMove(int fromPosition, int toPosition);
}
