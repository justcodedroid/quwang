package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.FaXianModel;
import com.example.admin.quwang.model.FaXianModelImpl;
import com.example.admin.quwang.view.FaXianView;

/**
 * Created by admin on 2017/4/3.
 */

public class FaXianPresenter implements OnLoadFinishListenr<FaXianBean> {
    FaXianModel faXianModel = new FaXianModelImpl();
    FaXianView faXianView;

    public void setFaXianView(FaXianView faXianView) {
        this.faXianView = faXianView;
    }

    public void getFaXianBean() {
        faXianView.showLoading();
        faXianModel.getFaXianBean(this);
    }

    @Override
    public void onSuccess(FaXianBean bean, int type) {
        faXianView.relashHotRecommand(bean.getData().getHot_recommend());
        faXianView.relashTopicBeans(bean.getData().getHot_topic());
        faXianView.relashMan(bean.getData().getMan());
        faXianView.relashWoman(bean.getData().getWoman());
        faXianView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        faXianView.showError();
    }
}
