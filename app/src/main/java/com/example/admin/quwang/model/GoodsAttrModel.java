package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/4.
 */

public interface GoodsAttrModel {
    void getGoodsAttr(int goodsId, OnLoadFinishListenr<GoodsAttrBean> onLoadFinishListenr);
}
