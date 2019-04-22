package cn.xz.basiclib.base.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    private int viewType;
    private boolean isRecycled;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public BaseRecyclerViewHolder(Context context, ViewGroup viewGroup, int layoutResId) {
        super(LayoutInflater
                .from(context)
                .inflate(layoutResId, viewGroup, false));
    }

    public BaseRecyclerViewHolder(Context context, int layoutResId) {
        this(context, null, layoutResId);
    }

    public BaseRecyclerViewHolder(View itemView, int viewType) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.viewType = viewType;
    }

    public final <V extends View> V findViewById(int resid) {
        if (resid > 0 && itemView != null) {
            return itemView.findViewById(resid);
        }
        return null;
    }

    public abstract void onBindData(T data, int position);

    protected int getViewType() {
        return viewType;
    }

    protected Context getContext() {
        return itemView.getContext();
    }

    public boolean isRecycled() {
        return isRecycled;
    }

    public void setRecycled(boolean recycled) {
        isRecycled = recycled;
    }
}
