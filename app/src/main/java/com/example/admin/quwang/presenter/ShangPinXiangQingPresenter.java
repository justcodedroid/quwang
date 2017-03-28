package com.example.admin.quwang.presenter;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.ShangPinXiangQingModel;
import com.example.admin.quwang.model.ShangPinXiangQingModelImpl;
import com.example.admin.quwang.view.ShangPinXiangQingView;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinXiangQingPresenter implements OnLoadFinishListenr<List<Fragment>> {
    ShangPinXiangQingModel shangPinXiangQingModel = new ShangPinXiangQingModelImpl();
    ShangPinXiangQingView shangPinXiangQingView;

    public void setShangPinXiangQingView(ShangPinXiangQingView shangPinXiangQingView) {
        this.shangPinXiangQingView = shangPinXiangQingView;
    }

    public void loadShangPinXiangQingFragments(int goods_id) {
        shangPinXiangQingView.showLoading();
        shangPinXiangQingModel.loadShangPinXiangQingFragments(goods_id, this);
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
