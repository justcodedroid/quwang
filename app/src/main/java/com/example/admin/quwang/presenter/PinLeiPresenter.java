package com.example.admin.quwang.presenter;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.PinLeiModel;
import com.example.admin.quwang.model.PinLeiModelImpl;
import com.example.admin.quwang.utils.HttpUtils;
import com.example.admin.quwang.view.PinLeiView;

import java.util.Map;

/**
 * Created by admin on 2017/4/1.
 */

public class PinLeiPresenter implements OnLoadFinishListenr<BaseBean<PinLeiBean>> {
    PinLeiModel pinLeiModel = new PinLeiModelImpl();
    PinLeiView pinLeiView;
    int page = 1;

    public void setPinLeiView(PinLeiView pinLeiView) {
        this.pinLeiView = pinLeiView;
    }

    public void getPinLeiBean(String type, String sort, int ad_id, Map<String, String> map) {
        if (page == 1) {
            pinLeiView.showLoading();
        }
        pinLeiModel.loadPinLeiBean(type, sort, ad_id, page, map, this);
    }

    public void regetPinLeiBean(String type, String sort, int ad_id, Map<String, String> map) {
        page = 1;
        getPinLeiBean(type, sort, ad_id, map);
    }


    @Override
    public void onSuccess(BaseBean<PinLeiBean> bean, int type) {
        int normalType = HttpUtils.getNormalType(bean.getData().getGoods_list(), page);
        if (page == 1) {
            pinLeiView.showNormal();
            pinLeiView.relashAdInfo(bean.getData().getAd_info());
            pinLeiView.relashCatBeans(bean.getData().getCat_list());
        }
        pinLeiView.realshShangPinBeans(bean.getData().getGoods_list(), normalType);
        page++;
    }

    @Override
    public void onError(String msg, int errorCode) {
        Log.e("error", msg + "----->");
        if (page == 1)
            pinLeiView.showError();
        else
            pinLeiView.showError(msg);
    }
}
