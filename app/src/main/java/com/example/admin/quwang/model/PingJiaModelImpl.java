package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class PingJiaModelImpl implements PingJiaModel {
    @Override
    public void loadPingJiaList(int goods_id, int page, OnLoadFinishListenr<List<PingJiaBean>> listOnLoadFinishListenr) {
        HttpUtils.loadPingJiaResultBean(goods_id,page,listOnLoadFinishListenr);
    }
}
