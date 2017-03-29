package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingParameterModelImpl implements XiangQingParameterModel {
    @Override
    public void loadXiangQingParamterBeans(int goods_id, OnLoadFinishListenr<XiangQingResultBean> loadFinishListenr) {
        HttpUtils.loadXiangQingParameterBeans(goods_id,loadFinishListenr);
    }
}
