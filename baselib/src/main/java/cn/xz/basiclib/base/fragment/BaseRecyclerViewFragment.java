package cn.xz.basiclib.base.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import cn.xz.basiclib.R;
import cn.xz.basiclib.base.recyclerview.BaseRecyclerViewAdapter;
import cn.xz.basiclib.base.recyclerview.BaseRecyclerViewContract;
import cn.xz.basiclib.base.recyclerview.BaseRecyclerViewPresenter;
import cn.xz.basiclib.common.OnFinishLoadDataListener;
import cn.xz.basiclib.util.AppUtils;
import cn.xz.basiclib.widget.swipetoloadlayout.SwipeToLoadLayout;


/**
 * 列表类型通用的Fragment
 *
 * @author fred
 */
public abstract class BaseRecyclerViewFragment<M> extends BaseLazyLoadFragment
        implements BaseRecyclerViewContract.RecyclerViewView<M> {

    protected BaseRecyclerViewAdapter<M> mAdapter;
    protected BaseRecyclerViewPresenter mPresenter;
    protected OnFinishLoadDataListener onFinishLoadDataListener;

    public RecyclerView recyclerView;
    public SwipeToLoadLayout swipeToLoadLayout;

    private LocalBroadcastManager broadcastManager;
    private UpdateDataReceiver updateDataReceiver;

    private List<M> mData = new ArrayList<>();
    private int pageIndex = 1;
    private boolean isUpdateList = false;
    private boolean isRefresh = true;
    public static final String PAGE_SIZE="20";


    @Override
    public void initComponents() {
        mPresenter = getPresenter();
        if (mPresenter != null) mPresenter.attachView(this);

        mAdapter = getAdapter();
        recyclerView = getRecyclerView();


        if (mAdapter != null && recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(mAdapter);
        }
        onFinishLoadDataListener = setOnFinishLoadDataListener();

        showLoading();

        registerReceiver();
    }

    @Override
    public Object contentView() {
        swipeToLoadLayout = mContentView.findViewById(R.id.swipe_toload_layout);
        return swipeToLoadLayout;
    }

    @Override
    public RecyclerView getRecyclerView() {
        recyclerView = mContentView.findViewById(R.id.swipe_target);
        return recyclerView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    /**
     * 如果要改变数据
     */
    public String recevierIntentFilter() {
        return null;
    }

    private void registerReceiver() {
        if (!TextUtils.isEmpty(recevierIntentFilter())) {
            broadcastManager = LocalBroadcastManager.getInstance(AppUtils.getApp());
            updateDataReceiver = new UpdateDataReceiver();
            broadcastManager.registerReceiver(updateDataReceiver,
                    new IntentFilter(recevierIntentFilter()));
        }
    }


    class UpdateDataReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            isUpdateList = true;
        }
    }

    @Override
    public void obtainData() {
        super.obtainData();
        pageIndex = 1;
        mPresenter.requestData(String.valueOf(pageIndex));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isUpdateList && !isFirstLoad) {
            _onRefresh();
        }
        isUpdateList = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (broadcastManager != null)
            broadcastManager.unregisterReceiver(updateDataReceiver);
        if (mPresenter != null) mPresenter.detachView();
    }


    @Override
    public void render(List<M> t) {
        showContent();
        if (isRefresh) {
            if (onFinishLoadDataListener != null)
                onFinishLoadDataListener.finishRefresh();
            if (t != null && t.size() > 0) {
                if (mAdapter != null) {
                    mData = t;
                    mAdapter.updateData(mData);
                }
            } else {
                if (mAdapter != null)
                    mAdapter.clearData();
            }
        } else {
            if (onFinishLoadDataListener != null)
                onFinishLoadDataListener.finishLoadMore();
            if (t != null && t.size() > 0) {
                mData.addAll(t);
                if (mAdapter != null) mAdapter.updateData(t);
            }
        }
        if (mAdapter != null && mAdapter.isEmpty()) {
            showEmpty();
        }
    }

    @Override
    public void _onRefresh() {
        pageIndex = 1;
        isRefresh = true;
        if (mPresenter != null) mPresenter.requestData(String.valueOf(pageIndex));
    }

    @Override
    public void _onLoadMore() {
        pageIndex++;
        isRefresh = false;
        if (mPresenter != null) mPresenter.requestData(String.valueOf(pageIndex));
    }
}
