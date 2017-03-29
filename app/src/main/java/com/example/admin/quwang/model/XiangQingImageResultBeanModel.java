package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/29.
 */

public interface XiangQingImageResultBeanModel {
    void loadXiangQingImageBeans(int goods_id, OnLoadFinishListenr<XiangQingImageResultBean> onLoadFinishListenr);
}
