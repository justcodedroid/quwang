package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/27.
 */

public class DetailsModelImpl implements DetailsModel {
    @Override
    public void loadDetailsBean(int id, OnLoadFinishListenr<DetailsBean> listener) {
        HttpUtils.loadDeatilsBean(id,listener);
    }
}
