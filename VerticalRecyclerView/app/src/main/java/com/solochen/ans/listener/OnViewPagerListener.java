package com.solochen.ans.listener;

/**
 * Created by chenshaolong on 2018/8/7.
 */

public interface OnViewPagerListener {

    /*初始化完成*/
    void onInitComplete();

    /*释放的监听*/
    void onPageRelease(boolean isNext, int position);

    /*选中的监听以及判断是否滑动到底部*/
    void onPageSelected(int position, boolean isBottom);

}
