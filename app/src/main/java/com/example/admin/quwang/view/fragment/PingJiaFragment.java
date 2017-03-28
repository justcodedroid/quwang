package com.example.admin.quwang.view.fragment;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentPingJiaBinding;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;

/**
 * Created by admin on 2017/3/28.
 */

public class PingJiaFragment extends BaseFragment<FragmentPingJiaBinding> {

    int goods_id;

    public PingJiaFragment setGoods_id(int goods_id) {
        this.goods_id = goods_id;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ping_jia;
    }

    @Override
    protected void initImpl() {

    }
}
