package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.model.PingJiaModel;
import com.example.admin.quwang.model.PingJiaModelImpl;
import com.example.admin.quwang.view.PingJianView;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class PingJiaPresenter implements OnLoadFinishListenr<List<PingJiaBean>> {
    PingJiaModel pingJiaModel = new PingJiaModelImpl();
    PingJianView pingJianView;

    public void setPingJianView(PingJianView pingJianView) {
        this.pingJianView = pingJianView;
    }

    public void getPingJiaList(int goods_id, int page) {
        if (page == 1) {
            pingJianView.showLoading();
        }
        pingJiaModel.loadPingJiaList(goods_id, page, this);
    }

    @Override
    public void onSuccess(List<PingJiaBean> bean, int type) {
        pingJianView.relashPingJiaList(bean, type);
        pingJianView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        if (errorCode == HttpModel.RELASHFAILED) {
            pingJianView.showError();
        }
    }
}
