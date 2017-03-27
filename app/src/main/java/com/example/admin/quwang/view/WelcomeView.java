package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.WelcomeBean;

/**
 * Created by admin on 2017/3/25.
 */

public interface WelcomeView {
    void RelashData(WelcomeBean welcomeBean);
    void showError(String msg,int errorCode);
}
