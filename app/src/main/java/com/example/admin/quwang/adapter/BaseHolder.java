package com.example.admin.quwang.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by admin on 2017/4/1.
 */

public abstract class BaseHolder<B, T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    T bind;

    public BaseHolder(T bind) {
        super(bind.getRoot());
        this.bind = bind;
    }

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public void bind(B data) {
        bindData(bind, data);
        bind.executePendingBindings();
    }

    protected abstract void bindData(T bind, B data);
}
