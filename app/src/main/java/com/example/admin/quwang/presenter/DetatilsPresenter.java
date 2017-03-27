package com.example.admin.quwang.presenter;

import android.util.Log;

import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.DetailsModel;
import com.example.admin.quwang.model.DetailsModelImpl;
import com.example.admin.quwang.view.DetailsView;

/**
 * Created by admin on 2017/3/27.
 */

public class DetatilsPresenter implements OnLoadFinishListenr<DetailsBean> {
    DetailsModel detailsModel=new DetailsModelImpl();
    private DetailsView detailsView;

    public void setDetailsView(DetailsView detailsView){
    this.detailsView=detailsView;
    };
    public void loadDeatilsBean(int id){
        detailsView.showLoading();
        detailsModel.loadDetailsBean(id,this);
    }

    @Override
    public void onSuccess(DetailsBean bean, int type) {
        detailsView.relashInfoDatas(bean.getData().getInfo());
        detailsView.relashWebView(bean.getData().getInfo().getContent());
        detailsView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        Log.e("tag",errorCode+"---->"+msg);
        detailsView.showError();
    }
}
