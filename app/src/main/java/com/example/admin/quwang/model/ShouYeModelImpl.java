package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.ShouYeBean;
import com.example.admin.quwang.bean.TopAdsBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class ShouYeModelImpl implements ShouYeModel {


    @Override
    public void getShouYeBean(OnLoadFinishListenr<ShouYeBean> listenr) {
      HttpUtils.LoadShouYeBean(listenr);
    }
}
