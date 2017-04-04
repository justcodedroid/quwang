package com.example.admin.quwang.presenter;

import android.util.Log;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.ShangPinModel;
import com.example.admin.quwang.model.ShangPinModelImpl;
import com.example.admin.quwang.utils.HttpUtils;
import com.example.admin.quwang.view.ShangPinView;

import java.lang.ref.SoftReference;

/**
 * Created by admin on 2017/3/30.
 */

public class ShangPinPresenter implements OnLoadFinishListenr<BaseBean<ShangPinXiangQingBean>> {
    ShangPinModel shangPinModel = new ShangPinModelImpl();
    SoftReference<ShangPinView> shangPinView;

    public void setShangPinView(ShangPinView shangPinView) {
        this.shangPinView = new SoftReference<ShangPinView>(shangPinView);
    }

    public void getShangPinXiangQingBean(int goodsid, int special_id, int special_type) {
        ShangPinView shangPinView = this.shangPinView.get();
        if(shangPinView==null)return;
        shangPinView.showLoading();

        HttpUtils.loadShangPinXiangQingBean(goodsid, special_id, special_type, this);
    }

    @Override
    public void onSuccess(BaseBean<ShangPinXiangQingBean> bean, int type) {
        ShangPinView shangPinView = this.shangPinView.get();
        if(shangPinView==null)return;
        shangPinView.relashGoodsGallery(bean.getData().getGoods_gallery());
        shangPinView.relashGoodsInfo(bean.getData().getGoods_info());
        shangPinView.relashQuanBean(bean.getData().getBonus_info());
        shangPinView.relashPingJia(bean.getData().getComment_list(), bean.getData().getComment_count());
        shangPinView.relashTuiJian(bean.getData().getRecommend_goods());
        shangPinView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        ShangPinView shangPinView = this.shangPinView.get();
        if(shangPinView==null)return;
        shangPinView.showError();
        Log.e("error", msg+"---->"+errorCode);

    }

}
