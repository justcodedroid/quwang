package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.GoodsAttrModel;
import com.example.admin.quwang.model.GoodsAttrModelImpl;
import com.example.admin.quwang.view.GoodsAttrView;

/**
 * Created by admin on 2017/4/4.
 */

public class GoodsAttrPresenter implements OnLoadFinishListenr<GoodsAttrBean> {
    GoodsAttrModel goodsAttrModel = new GoodsAttrModelImpl();
    GoodsAttrView goodsAttrView;

    public void setGoodsAttrView(GoodsAttrView goodsAttrView) {
        this.goodsAttrView = goodsAttrView;
    }
    public void loadGoodsAttr(int goodsId){
        goodsAttrView.showLoadingDialog();
        goodsAttrModel.getGoodsAttr(goodsId,this);
    }

    @Override
    public void onSuccess(GoodsAttrBean bean, int type) {
        goodsAttrView.relashGoodsAttr(bean);
        goodsAttrView.dismissLoadingDialog();
    }

    @Override
    public void onError(String msg, int errorCode) {
        goodsAttrView.dismissLoadingDialog();
        goodsAttrView.showGoodsAttrError(msg+"");
    }
}
