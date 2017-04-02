package com.example.admin.quwang.adapter;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.example.admin.quwang.bean.PinLeiBean;

/**
 * Created by admin on 2017/4/2.
 */

public abstract class BaseStyleHolder<B extends PinLeiBean.SimpleShangPinBean,T extends ViewDataBinding> extends BaseHolder<B,T> {
    public BaseStyleHolder(T bind) {
        super(bind);
    }

    public BaseStyleHolder(View itemView) {
        super(itemView);
    }

}
