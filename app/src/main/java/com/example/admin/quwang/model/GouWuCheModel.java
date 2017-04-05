package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/5.
 */

public interface GouWuCheModel {
    void getGouWuChe(OnLoadFinishListenr<GouWuCheBean> onLoadFinishListenr);
    void deleteGouWuChe(int recid,OnLoadFinishListenr<BaseBean<Object>> listenr);
    public void increaseGouWuChe(int recid,OnLoadFinishListenr<BaseBean<Object>> listenr);
    public void desearceGouWuChe(int recid,OnLoadFinishListenr<BaseBean<Object>> listenr);
}
