package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/27.
 */

public class WebModelImpl implements WebModel {
    @Override
    public void loadWebResultBean(String id, OnLoadFinishListenr<WebResultBean> webResultBeanOnLoadFinishListenr) {
        HttpUtils.loadWebResultBean(id,webResultBeanOnLoadFinishListenr);
    }
}
