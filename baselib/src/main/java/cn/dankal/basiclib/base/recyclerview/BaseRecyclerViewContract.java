package cn.dankal.basiclib.base.recyclerview;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.dankal.basiclib.base.BasePresenter;
import cn.dankal.basiclib.base.BaseStateView;
import cn.dankal.basiclib.common.OnFinishLoadDataListener;

/**
 * @author Dankal Android Developer
 */
public interface BaseRecyclerViewContract {

    interface RecyclerViewPresenter extends BasePresenter<RecyclerViewView> {

        void requestData(String pageIndex);

    }

    interface RecyclerViewView<M> extends BaseStateView {
        BaseRecyclerViewPresenter<M> getPresenter();

        BaseRecyclerViewAdapter<M> getAdapter();

        RecyclerView getRecyclerView();

        OnFinishLoadDataListener setOnFinishLoadDataListener();

        void _onRefresh();

        void _onLoadMore();

        void render(List<M> t);

    }

}