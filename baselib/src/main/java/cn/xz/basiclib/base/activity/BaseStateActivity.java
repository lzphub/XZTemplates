package cn.xz.basiclib.base.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

import cn.xz.basiclib.base.BaseStateView;
import cn.xz.basiclib.widget.loadsir.EmptyCallback;
import cn.xz.basiclib.widget.loadsir.LoadingCallback;
import cn.xz.basiclib.widget.loadsir.RetryCallback;
import cn.xz.basiclib.widget.loadsir.callback.Callback;
import cn.xz.basiclib.widget.loadsir.core.LoadService;
import cn.xz.basiclib.widget.loadsir.core.LoadSir;


/**
 * description: 具备 加载状态界面 的Activity基类
 *
 * @author Dankal Android Developer
 * @since 2018/1/30
 */

public abstract class BaseStateActivity extends BaseActivity implements BaseStateView {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

    @Override
    public void showRetry() {
        if (loadService == null) return;
        loadService.showCallback(RetryCallback.class);
    }

    @Override
    public void showEmpty() {
        if (loadService == null) return;
        loadService.showCallback(EmptyCallback.class);
    }

    @Override
    public void showContent() {
        if (loadService == null) return;
        loadService.showSuccess();
    }

    @Override
    public void showLoading() {
        if (loadService != null) {
            loadService.showCallback(LoadingCallback.class);
        }
    }


}
