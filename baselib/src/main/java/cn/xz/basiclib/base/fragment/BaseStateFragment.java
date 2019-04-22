package cn.xz.basiclib.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xz.basiclib.base.BaseStateView;
import cn.xz.basiclib.widget.loadsir.EmptyCallback;
import cn.xz.basiclib.widget.loadsir.LoadingCallback;
import cn.xz.basiclib.widget.loadsir.RetryCallback;
import cn.xz.basiclib.widget.loadsir.callback.Callback;
import cn.xz.basiclib.widget.loadsir.core.LoadService;
import cn.xz.basiclib.widget.loadsir.core.LoadSir;

/**
 * description: 包含状态加载图的Fragment基类
 *
 * @author vane
 * @since 2018/2/6
 */

public abstract class BaseStateFragment extends BaseFragment implements BaseStateView {

    public LoadService loadService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (contentView() != null) {
            loadService = LoadSir.getDefault().register(contentView(), new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    loadService.showCallback(LoadingCallback.class);
                    //do retry logic...
                    //callback
                    obtainData();
                }
            });
        }
        return mContentView;

    }


    @Override
    public void showRetry() {
        if (loadService != null)
            loadService.showCallback(RetryCallback.class);
    }

    @Override
    public void showContent() {
        if (loadService != null)
            loadService.showSuccess();
    }

    @Override
    public void showEmpty() {
        if (loadService != null)
            loadService.showCallback(EmptyCallback.class);
    }

    @Override
    public void showLoading() {
        if (loadService != null)
            loadService.showCallback(LoadingCallback.class);
    }
}
