package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/3.
 */

public interface FaXianModel {
    void getFaXianBean(OnLoadFinishListenr<FaXianBean> onLoadFinishListenr);
}
