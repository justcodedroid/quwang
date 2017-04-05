package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.GouWuCheModel;
import com.example.admin.quwang.model.GouWuCheModelImpl;
import com.example.admin.quwang.view.SimpleGouWuCheView;

/**
 * Created by admin on 2017/4/5.
 */

public class SimpleGouWuChePresenter implements OnLoadFinishListenr<GouWuCheBean> {
    GouWuCheModel gouWuCheModel = new GouWuCheModelImpl();
    SimpleGouWuCheView simpleGouWuCheView;

    public void setSimpleGouWuCheView(SimpleGouWuCheView simpleGouWuCheView) {
        this.simpleGouWuCheView = simpleGouWuCheView;
    }

    public void getGouWuCheCount() {
        gouWuCheModel.getGouWuChe(this);
    }

    @Override
    public void onSuccess(GouWuCheBean bean, int type) {
        simpleGouWuCheView.relashCount(bean.getData().getCarts_count());
    }

    @Override
    public void onError(String msg, int errorCode) {

    }
}

