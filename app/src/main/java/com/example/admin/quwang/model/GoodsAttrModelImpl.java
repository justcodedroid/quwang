package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/4.
 */

public class GoodsAttrModelImpl implements GoodsAttrModel {
    @Override
    public void getGoodsAttr(int goodsId, OnLoadFinishListenr<GoodsAttrBean> onLoadFinishListenr) {
        HttpUtils.getGoodsAttr(goodsId,onLoadFinishListenr);
    }
}
