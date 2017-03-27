package com.example.admin.quwang.presenter;

import android.util.Log;

import com.example.admin.quwang.bean.ShouYeBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.ShouYeModel;
import com.example.admin.quwang.model.ShouYeModelImpl;
import com.example.admin.quwang.view.ShouYeView;

/**
 * Created by admin on 2017/3/26.
 */

public class ShouYePresenter implements OnLoadFinishListenr<ShouYeBean> {
    ShouYeModel shouYeModel=new ShouYeModelImpl();
    private ShouYeView shouYeView;

    public void setShouYeView(ShouYeView shouYeView){
        this.shouYeView=shouYeView;
    }
    public void loadShouYe(){
        shouYeView.showLoading();
        shouYeModel.getShouYeBean(this);
    }

    @Override
    public void onSuccess(ShouYeBean bean, int type) {
        shouYeView.relashBannersData(bean.getData().getTop_ads());
        shouYeView.relashHotListData(bean.getData().getHot_list());
        shouYeView.relashHotDaily(bean.getData().getHot_daily());
        shouYeView.relashRetaimeTime(bean.getData().getRemaining_time());
        shouYeView.relashPromotionList(bean.getData().getPromotion_list());
        shouYeView.relashOthRecommendList(bean.getData().getOther_recommend_list());
        shouYeView.relashEveryOneButList(bean.getData().getEveryone_is_buying());
        shouYeView.relashRecommendList(bean.getData().getProduct_recommendation());
        shouYeView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        shouYeView.showError();
    }

}
