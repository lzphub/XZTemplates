package cn.xz.basiclib.widget.loadsir;


import cn.xz.basiclib.R;
import cn.xz.basiclib.widget.loadsir.callback.Callback;

public class EmptyCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }
}
