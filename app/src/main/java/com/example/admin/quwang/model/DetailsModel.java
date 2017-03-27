package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/27.
 */

public interface DetailsModel {
    void loadDetailsBean(int id, OnLoadFinishListenr<DetailsBean> listener);
}
