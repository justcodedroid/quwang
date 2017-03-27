package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.WelComeModel;
import com.example.admin.quwang.model.WelComeModelImpl;
import com.example.admin.quwang.view.WelcomeView;

/**
 * Created by admin on 2017/3/25.
 */

public class WelcomePresenter implements OnLoadFinishListenr<WelcomeBean> {
    WelComeModel model = new WelComeModelImpl();
    WelcomeView welcomeView;

    public void setWelComeView(WelcomeView welComeView) {
        this.welcomeView = welComeView;
    }

    public void loadWelComeBean() {
        model.loadWelComdeBean(this);
    }

    @Override
    public void onSuccess(WelcomeBean bean, int type) {
        welcomeView.RelashData(bean);
    }

    @Override
    public void onError(String msg, int errorCode) {
        welcomeView.showError(msg, errorCode);
    }
}
