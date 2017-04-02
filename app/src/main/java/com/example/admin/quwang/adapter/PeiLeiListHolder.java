package com.example.admin.quwang.adapter;

import android.view.View;

import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.callback.PinLeiItemClickListener;
import com.example.admin.quwang.databinding.ItemListPinleiBinding;

/**
 * Created by admin on 2017/4/1.
 */

public class PeiLeiListHolder extends BaseStyleHolder<PinLeiBean.SimpleShangPinBean,ItemListPinleiBinding> {
    public PeiLeiListHolder(ItemListPinleiBinding bind) {
        super(bind);
    }

    public PeiLeiListHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void bindData(ItemListPinleiBinding bind, PinLeiBean.SimpleShangPinBean data) {
    bind.setBean(data);
        bind.setListener(new PinLeiItemClickListener(bind.getRoot().getContext()));
    }
}
