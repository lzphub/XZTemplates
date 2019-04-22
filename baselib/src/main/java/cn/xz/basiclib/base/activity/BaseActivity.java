package cn.xz.basiclib.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import butterknife.ButterKnife;
import cn.xz.basiclib.XZUserManager;
import cn.xz.basiclib.R;
import cn.xz.basiclib.base.BaseView;
import cn.xz.basiclib.util.ActivityUtils;
import cn.xz.basiclib.util.DKHandler;
import cn.xz.basiclib.util.TitleBarUtils;
import cn.xz.basiclib.util.ToastUtils;
import cn.xz.basiclib.widget.TipDialog;
import cn.xz.basiclib.widget.statubar.QMUIStatusBarHelper;
import cn.xz.basiclib.widget.titlebar.ITitleBar;
import cn.xz.basiclib.widget.titlebar.NoBackTitle;
import cn.xz.basiclib.widget.titlebar.SingleTextTitle;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Dankal Android Developer
 * @since 2018/7/3
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected TipDialog loadingDialog;
    private CompositeDisposable mDisposables = new CompositeDisposable();
    private int titleBarResId=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());

            //ButterKnife绑定
            ButterKnife.bind(this);

            initStatusBar();
            //初始化组件
            initComponents();

            obtainData();
        }
    }
    protected void initStatusBar() {
        TitleBarUtils.compat(this, getResources().getColor(R.color.color00));
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
    }


    /**
     * setContentView(LayoutResId)
     *
     * @return LayoutResId
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化组件
     */
    protected abstract void initComponents();

    /**
     * 添加标题栏
     */
    public void addTitleBar(ITitleBar iTitleBar) {
        if (iTitleBar == null) return;

        titleBarResId = iTitleBar.getViewResId();

        View toolbarContainer = TitleBarUtils.init(this, titleBarResId);

        toolbarContainer.findViewById(R.id.iv_onback)
                .setOnClickListener(view -> onBackPressed());

        iTitleBar.onBindTitleBar(toolbarContainer);
    }

    //添加没有返回的标题
    public void addTitleBar2(ITitleBar iTitleBar) {
        if (iTitleBar == null) return;

        titleBarResId = iTitleBar.getViewResId();

        View toolbarContainer = TitleBarUtils.init(this, titleBarResId);

        iTitleBar.onBindTitleBar(toolbarContainer);
    }

    public void addSindleTitleBar(String title) {
        addTitleBar(new SingleTextTitle(title));
    }

    public void addNoBackTitleBar(String title){
        addTitleBar2(new NoBackTitle(title));
    }

    public void obtainData() {}

    @Override
    public void showLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
        loadingDialog = new TipDialog.Builder(this)
                .setIconType(TipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        loadingDialog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showToast(String message) {
        try {
            ToastUtils.showShort(message);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void tokenInvalid() {
//        EMClient.getInstance().logout(true);
        XZUserManager.resetUserInfo();
        ActivityUtils.finishAllActivities();
        try {
            startActivity(new Intent(this,
                    Class.forName(getString(R.string.login_activity_path))));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addNetworkRequest(Disposable d) {
        mDisposables.add(d);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposables != null) mDisposables.clear();
    }

    @Override
    protected void onPause() {
        ToastUtils.cancel();
        super.onPause();
    }

    protected void postDelayedToFinish() {
        new DKHandler(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }
}
