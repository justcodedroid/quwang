package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/3/25.
 */

public interface WelComeModel {
    void loadWelComdeBean(OnLoadFinishListenr<WelcomeBean> listenr);
}
