package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/29.
 */

public interface XiangQingParameterModel {
    void loadXiangQingParamterBeans(int goods_id, OnLoadFinishListenr<XiangQingResultBean> onLoadFinishListenr);
}
