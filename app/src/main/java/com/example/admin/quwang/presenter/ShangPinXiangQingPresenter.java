package com.example.admin.quwang.presenter;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;
import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.bean.ShouCangBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.AddGouWuCheModel;
import com.example.admin.quwang.model.AddGouWuCheModelmpl;
import com.example.admin.quwang.model.ShangPinXiangQingModel;
import com.example.admin.quwang.model.ShangPinXiangQingModelImpl;
import com.example.admin.quwang.model.ShouCangModel;
import com.example.admin.quwang.model.ShouCangModelImpl;
import com.example.admin.quwang.view.ShangPinXiangQingView;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinXiangQingPresenter implements OnLoadFinishListenr<List<Fragment>> {
    ShangPinXiangQingModel shangPinXiangQingModel = new ShangPinXiangQingModelImpl();
    ShouCangModel shouCangModel=new ShouCangModelImpl();
    ShangPinXiangQingView shangPinXiangQingView;
    AddGouWuCheModel addGouWuCheModel=new AddGouWuCheModelmpl();
    OnLoadFinishListenr<ShouCangBean> shouCangBeanOnLoadFinishListenr=new OnLoadFinishListenr<ShouCangBean>() {
        @Override
        public void onSuccess(ShouCangBean bean, int type) {
        shangPinXiangQingView.shoucangSuccess("收藏成功",bean.getData().getCollection_id());
        }

        @Override
        public void onError(String msg, int errorCode) {
        shangPinXiangQingView.shoucangFailed("收藏失败"+msg);
        }
    };


    public void setShangPinXiangQingView(ShangPinXiangQingView shangPinXiangQingView) {
        this.shangPinXiangQingView = shangPinXiangQingView;
    }

    public void loadShangPinXiangQingFragments(int goods_id,int specialId,int specialType) {
        shangPinXiangQingView.showLoading();
        shangPinXiangQingModel.loadShangPinXiangQingFragments(goods_id,specialId,specialType, this);
    }
    public void shouCang(int goodsId){
        shouCangModel.shouCang(goodsId,shouCangBeanOnLoadFinishListenr);
    }

    @Override
    public void onSuccess(List<Fragment> bean, int type) {
        shangPinXiangQingView.relashShangPinXiangQingFragments(bean);

        shangPinXiangQingView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        shangPinXiangQingView.showError();
    }
}
