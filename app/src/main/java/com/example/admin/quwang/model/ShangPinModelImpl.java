package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/30.
 */

public class ShangPinModelImpl implements ShangPinModel {
    @Override
    public void loadShangPinXiangQingBean(int goodsId,int special_id,int special_type, OnLoadFinishListenr<BaseBean<ShangPinXiangQingBean>> listenr) {
        HttpUtils.loadShangPinXiangQingBean(goodsId, special_id, special_type, listenr);
    }
}
