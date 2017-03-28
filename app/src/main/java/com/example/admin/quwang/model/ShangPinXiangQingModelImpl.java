package com.example.admin.quwang.model;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.view.fragment.PingJiaFragment;
import com.example.admin.quwang.view.fragment.ShangPinFragment;
import com.example.admin.quwang.view.fragment.XiangQingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinXiangQingModelImpl implements ShangPinXiangQingModel {
    @Override
    public void loadShangPinXiangQingFragments(int goods_id, OnLoadFinishListenr<List<Fragment>> onLoadFinishListenr) {
        List<Fragment> list=new ArrayList<>();
        list.add(new ShangPinFragment().setGoods_id(goods_id));
        list.add(new XiangQingFragment().setGoods_id(goods_id));
        list.add(new PingJiaFragment().setGoods_id(goods_id));
        onLoadFinishListenr.onSuccess(list, HttpModel.NORMAL);
    }
}
