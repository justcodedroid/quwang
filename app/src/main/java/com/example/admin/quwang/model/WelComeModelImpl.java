package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/3/25.
 */

public class WelComeModelImpl implements WelComeModel {
    @Override
    public void loadWelComdeBean(OnLoadFinishListenr<WelcomeBean> listenr) {
        HttpUtils.loadWelComdeBean(listenr);
    }
}
