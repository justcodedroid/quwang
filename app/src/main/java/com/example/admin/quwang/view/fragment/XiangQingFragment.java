package com.example.admin.quwang.view.fragment;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;
import com.example.admin.quwang.databinding.FragmentXiangQingBinding;

/**
 * Created by admin on 2017/3/28.
 */

public class XiangQingFragment extends BaseFragment<FragmentXiangQingBinding> {
    int goods_id;

    public XiangQingFragment setGoods_id(int goods_id) {
        this.goods_id = goods_id;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiang_qing;
    }

    @Override
    protected void initImpl() {

    }
}
