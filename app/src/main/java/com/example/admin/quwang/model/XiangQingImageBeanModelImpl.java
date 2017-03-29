package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingImageBeanModelImpl implements XiangQingImageResultBeanModel {
    @Override
    public void loadXiangQingImageBeans(int goods_id, OnLoadFinishListenr<XiangQingImageResultBean> onLoadFinishListenr) {
        HttpUtils.loadXiangQingImageBeans(goods_id,onLoadFinishListenr);
    }
}
