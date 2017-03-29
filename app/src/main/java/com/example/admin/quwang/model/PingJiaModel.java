package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public interface PingJiaModel {
    void loadPingJiaList(int goods_id, int page, OnLoadFinishListenr<List<PingJiaBean>> listOnLoadFinishListenr);
}
