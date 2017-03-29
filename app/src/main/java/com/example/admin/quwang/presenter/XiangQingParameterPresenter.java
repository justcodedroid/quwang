package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.XiangQingImageBeanModelImpl;
import com.example.admin.quwang.model.XiangQingImageResultBeanModel;
import com.example.admin.quwang.model.XiangQingParameterModel;
import com.example.admin.quwang.model.XiangQingParameterModelImpl;
import com.example.admin.quwang.view.XiangQingView;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingParameterPresenter {
    XiangQingParameterModel xiangQingParameterModel = new XiangQingParameterModelImpl();
    XiangQingImageResultBeanModel xiangQingImageResultBeanModel = new XiangQingImageBeanModelImpl();
    private int goods_id;
    private XiangQingView xiangQingView;
    OnLoadFinishListenr<XiangQingImageResultBean> xiangQingImageResultBeanOnLoadFinishListenr = new OnLoadFinishListenr<XiangQingImageResultBean>() {
        @Override
        public void onSuccess(XiangQingImageResultBean bean, int type) {
            xiangQingView.relashImageBeans(bean.getData());
            xiangQingView.showNormal();
        }

        @Override
        public void onError(String msg, int errorCode) {
            xiangQingView.showError();
        }
    };

    OnLoadFinishListenr<XiangQingResultBean> xiangQingResultBeanOnLoadFinishListenr = new OnLoadFinishListenr<XiangQingResultBean>() {
        @Override
        public void onSuccess(XiangQingResultBean bean, int type) {
            xiangQingView.relashParameterBeans(bean.getData().getParameter());
            xiangQingImageResultBeanModel.loadXiangQingImageBeans(goods_id, xiangQingImageResultBeanOnLoadFinishListenr);
        }

        @Override
        public void onError(String msg, int errorCode) {
            xiangQingView.showError();
        }
    };


    public void setXiangQingView(XiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
    }

    public void getXiangQingParameterBeans(int goods_id) {
        this.goods_id = goods_id;
        xiangQingView.showLoading();
        xiangQingParameterModel.loadXiangQingParamterBeans(goods_id, xiangQingResultBeanOnLoadFinishListenr);
    }
}
