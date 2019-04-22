package cn.xz.basiclib.base.recyclerview;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.xz.basiclib.base.BasePresenter;
import cn.xz.basiclib.base.BaseStateView;
import cn.xz.basiclib.common.OnFinishLoadDataListener;

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

        void notLoadMore();

    }

}