package com.example.admin.quwang.presenter;

import android.util.Log;

import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.AddGouWuCheModel;
import com.example.admin.quwang.model.AddGouWuCheModelmpl;
import com.example.admin.quwang.view.ShangPinXiangQingView;

import java.net.URLDecoder;

/**
 * Created by admin on 2017/4/4.
 */

public class AddGouWuChePresenter implements OnLoadFinishListenr<AddCaetBean> {
    AddGouWuCheModel addGouWuCheModel=new AddGouWuCheModelmpl();
    ShangPinXiangQingView xiangQingView;

    public void setXiangQingView(ShangPinXiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
    }
    public void addGouWuche(int goods_id, int specid, int goods_number, String action, int special_type, int special_id, int zt_id, int referer_type){
        xiangQingView.showLoadingDialog();
        addGouWuCheModel.addGouWuche(goods_id,specid,goods_number,action,special_type,special_id,zt_id,referer_type,this);
    }

    @Override
    public void onSuccess(AddCaetBean bean, int type) {
        xiangQingView.dismissLoadingDialog();
        xiangQingView.shouGouWuChe(bean.getMessage());
    }

    @Override
    public void onError(String msg, int errorCode) {
//        Log.e("tag","tiannjia shibai==>"+msg);
        xiangQingView.dismissLoadingDialog();
        xiangQingView.shouGouWuChe(URLDecoder.decode(msg));
    }
}
