package cn.dankal.basiclib.base;

import android.support.v7.widget.RecyclerView;

import cn.dankal.basiclib.R;
import cn.dankal.basiclib.base.activity.BaseRecyclerViewActivity;
import cn.dankal.basiclib.common.OnFinishLoadDataListener;
import cn.dankal.basiclib.widget.swipetoloadlayout.OnLoadMoreListener;
import cn.dankal.basiclib.widget.swipetoloadlayout.OnRefreshListener;

/**
 * @author Dankal Android Developer
 * @since 2018/7/17
 */

public abstract class BaseRvActivity<M> extends BaseRecyclerViewActivity<M> implements
        OnRefreshListener, OnLoadMoreListener,
        OnFinishLoadDataListener {

    @Override
    public void initComponents() {
        recyclerView =  findViewById(R.id.swipe_target);
        swipeToLoadLayout = findViewById(R.id.swipe_toload_layout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        super.initComponents();
    }

    @Override
    public Object contentView() {
        return swipeToLoadLayout;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }



    @Override
    public void onRefresh() {
        _onRefresh();
    }

    @Override
    public void onLoadMore() {
        _onLoadMore();
    }

    @Override
    public OnFinishLoadDataListener setOnFinishLoadDataListener() {
        return this;
    }

    @Override
    public void finishRefresh() {
        swipeToLoadLayout.setRefreshing(false);
    }

    @Override
    public void finishLoadMore() {
        swipeToLoadLayout.setLoadingMore(false);
    }

}
