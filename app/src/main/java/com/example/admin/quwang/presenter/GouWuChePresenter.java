package com.example.admin.quwang.presenter;

import android.widget.Toast;

import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.AddGouWuCheModel;
import com.example.admin.quwang.model.AddGouWuCheModelmpl;
import com.example.admin.quwang.model.GouWuCheModel;
import com.example.admin.quwang.model.GouWuCheModelImpl;
import com.example.admin.quwang.view.GouWuCheView;

import java.util.List;
import java.util.Objects;

/**
 * Created by admin on 2017/4/5.
 */

public class GouWuChePresenter implements OnLoadFinishListenr<GouWuCheBean> {
    GouWuCheModel gouWuCheModel = new GouWuCheModelImpl();

    GouWuCheView gouWuCheView;

    public void setGouWuCheView(GouWuCheView gouWuCheView) {
        this.gouWuCheView = gouWuCheView;
    }

    public void getGouWuChe() {
        gouWuCheView.showLoading();
        gouWuCheModel.getGouWuChe(this);
    }

    public void add(final int recid) {
        gouWuCheView.showLoadingDialog();
        gouWuCheModel.increaseGouWuChe(recid, new OnLoadFinishListenr<BaseBean<Object>>() {
            @Override
            public void onSuccess(BaseBean<Object> bean, int type) {
                gouWuCheView.add(recid);
                gouWuCheView.dissmissLoadingDialog();
            }

            @Override
            public void onError(String msg, int errorCode) {
                gouWuCheView.dissmissLoadingDialog();
                gouWuCheView.showMessage(msg + "");
            }
        });
    }

    public void min(final int recid) {
        gouWuCheView.showLoadingDialog();
        gouWuCheModel.desearceGouWuChe(recid, new OnLoadFinishListenr<BaseBean<Object>>() {
            @Override
            public void onSuccess(BaseBean<Object> bean, int type) {
                gouWuCheView.min(recid);
                gouWuCheView.dissmissLoadingDialog();
            }

            @Override
            public void onError(String msg, int errorCode) {
                gouWuCheView.dissmissLoadingDialog();
                gouWuCheView.showMessage(msg + "");
            }
        });
    }

    @Override
    public void onSuccess(GouWuCheBean bean, int type) {
        List<GouWuCheBean.DataBean.CartsListBean> carts_list = bean.getData().getCarts_list();
        if (carts_list == null || carts_list.size() == 0) {
            gouWuCheView.showNoData();
        } else {
            gouWuCheView.relashGouWuChe(bean);
        }
        gouWuCheView.showNormal();
    }

    public void delete(final int recid) {
        gouWuCheView.showLoadingDialog();
        gouWuCheModel.deleteGouWuChe(recid, new OnLoadFinishListenr<BaseBean<Object>>() {
            @Override
            public void onSuccess(BaseBean<Object> bean, int type) {
                gouWuCheView.dissmissLoadingDialog();
                gouWuCheView.deleteSuccess(recid);
                gouWuCheView.showMessage(bean.getMessage() + "");
            }

            @Override
            public void onError(String msg, int errorCode) {
                gouWuCheView.dissmissLoadingDialog();
                gouWuCheView.showMessage(msg + "");
            }
        });
    }

    @Override
    public void onError(String msg, int errorCode) {
        gouWuCheView.showError();
    }
}