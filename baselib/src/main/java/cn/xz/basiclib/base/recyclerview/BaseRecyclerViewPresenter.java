package cn.xz.basiclib.base.recyclerview;

import android.support.annotation.NonNull;

/**
 * @author Dankal Android Developer
 */
public abstract class BaseRecyclerViewPresenter<M> implements BaseRecyclerViewContract.RecyclerViewPresenter {

    public BaseRecyclerViewContract.RecyclerViewView<M> myView;

    @Override
    public void attachView(@NonNull BaseRecyclerViewContract.RecyclerViewView view) {
        this.myView = view;
    }

    @Override
    public void detachView() {
        myView = null;
    }


}
