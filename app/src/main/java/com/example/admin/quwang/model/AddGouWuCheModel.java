package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/4.
 */

public interface AddGouWuCheModel {
    void addGouWuche(int goods_id, int specid, int goods_number, String action, int special_type, int special_id, int zt_id, int referer_type, OnLoadFinishListenr<AddCaetBean> onLoadFinishListenr);
}
