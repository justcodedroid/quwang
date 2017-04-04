package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/4.
 */

public class AddGouWuCheModelmpl implements AddGouWuCheModel {
    @Override
    public void addGouWuche(int goods_id, int specid, int goods_number, String action, int special_type, int special_id, int zt_id, int referer_type, OnLoadFinishListenr<AddCaetBean> onLoadFinishListenr) {
        HttpUtils.addGouWuChe(goods_id,specid,goods_number,action,special_type,special_id,zt_id,referer_type,onLoadFinishListenr);
    }
}
