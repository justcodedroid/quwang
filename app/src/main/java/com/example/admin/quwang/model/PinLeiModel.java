package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

import java.util.Map;

/**
 * Created by admin on 2017/4/1.
 */

public interface PinLeiModel {
void loadPinLeiBean(String type, String sort, int ad_id, int page, Map<String,String> map, OnLoadFinishListenr<BaseBean<PinLeiBean>> listenr);
}
