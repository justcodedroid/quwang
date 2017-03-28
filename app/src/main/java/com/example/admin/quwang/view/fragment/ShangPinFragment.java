package com.example.admin.quwang.view.fragment;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinFragment extends BaseFragment<FragmentShangPinBinding> {
    int goods_id;

    public ShangPinFragment setGoods_id(int goods_id) {
        this.goods_id = goods_id;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shang_pin;
    }

    @Override
    protected void initImpl() {

    }
}
