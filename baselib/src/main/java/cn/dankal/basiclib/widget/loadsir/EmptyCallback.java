package cn.dankal.basiclib.widget.loadsir;


import cn.dankal.basiclib.R;
import cn.dankal.basiclib.widget.loadsir.callback.Callback;

public class EmptyCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }
}
