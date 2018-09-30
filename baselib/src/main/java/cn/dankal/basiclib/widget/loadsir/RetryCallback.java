package cn.dankal.basiclib.widget.loadsir;


import android.content.Context;
import android.view.View;

import cn.dankal.basiclib.R;
import cn.dankal.basiclib.widget.loadsir.callback.Callback;


public class RetryCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_retry;
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return false;
    }
}
