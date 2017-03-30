package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/30.
 */

public interface ShangPinModel  {
void loadShangPinXiangQingBean(int goodsId,int special_id,int special_type, OnLoadFinishListenr<BaseBean<ShangPinXiangQingBean>> listenr);
}
