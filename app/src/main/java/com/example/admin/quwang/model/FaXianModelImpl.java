package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/3.
 */

public class FaXianModelImpl implements FaXianModel {
    @Override
    public void getFaXianBean(OnLoadFinishListenr<FaXianBean> onLoadFinishListenr) {
        HttpUtils.loadFaXianBean(onLoadFinishListenr);
    }
}
