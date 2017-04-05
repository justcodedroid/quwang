package com.example.admin.quwang.adapter;

import android.view.View;

import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.databinding.ItemGouwuchBinding;

/**
 * Created by admin on 2017/4/5.
 */

public class GouWuCheHolder extends BaseHolder<GouWuCheBean.DataBean.CartsListBean, ItemGouwuchBinding> {
    public GouWuCheHolder(ItemGouwuchBinding bind) {
        super(bind);
    }

    public GouWuCheHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void bindData(ItemGouwuchBinding bind, GouWuCheBean.DataBean.CartsListBean data) {
        bind.setBean(data);
    }
}
