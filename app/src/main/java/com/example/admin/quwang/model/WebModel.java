package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/27.
 */

public interface WebModel {
    void loadWebResultBean(String id, OnLoadFinishListenr<WebResultBean> webResultBeanOnLoadFinishListenr);
}
