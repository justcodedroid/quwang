package com.example.admin.quwang.adapter;

import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.callback.PinLeiItemClickListener;
import com.example.admin.quwang.databinding.ItemGridStyleBinding;

/**
 * Created by admin on 2017/4/2.
 */

public class PinLeiGridHolder extends BaseStyleHolder<PinLeiBean.SimpleShangPinBean, ItemGridStyleBinding> {
    public PinLeiGridHolder(ItemGridStyleBinding bind) {
        super(bind);
    }

    @Override
    protected void bindData(ItemGridStyleBinding bind, PinLeiBean.SimpleShangPinBean data) {
        bind.setShangpin(data);
        bind.setListener(new PinLeiItemClickListener(bind.getRoot().getContext()));
    }
}
