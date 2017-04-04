package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.ShouCangBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/3.
 */

public interface ShouCangModel {
    void shouCang(int goods_id, OnLoadFinishListenr<ShouCangBean> onLoadFinishListenr);
}
