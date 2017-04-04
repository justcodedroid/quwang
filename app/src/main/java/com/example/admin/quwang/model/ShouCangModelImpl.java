package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.ShouCangBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/3.
 */

public class ShouCangModelImpl implements ShouCangModel {
    @Override
    public void shouCang(int goods_id, OnLoadFinishListenr<ShouCangBean> onLoadFinishListenr) {
        HttpUtils.shouCang(goods_id,onLoadFinishListenr);
    }
}
