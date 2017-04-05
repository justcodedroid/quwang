package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/5.
 */

public class GouWuCheModelImpl implements GouWuCheModel {
    @Override
    public void getGouWuChe(OnLoadFinishListenr<GouWuCheBean> onLoadFinishListenr) {
        HttpUtils.getGouWuChe(onLoadFinishListenr);
    }

    @Override
    public void deleteGouWuChe(int recid, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        HttpUtils.deleteWouWuChe(recid, listenr);
    }

    @Override
    public void increaseGouWuChe(int recid, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        HttpUtils.increaseGouWuChe(recid, listenr);
    }

    @Override
    public void desearceGouWuChe(int recid, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        HttpUtils.decreaseGouWuChe(recid, listenr);
    }


}
