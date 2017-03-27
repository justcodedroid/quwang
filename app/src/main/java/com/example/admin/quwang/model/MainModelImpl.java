package com.example.admin.quwang.model;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.view.fragment.FaXianFragment;
import com.example.admin.quwang.view.fragment.GouWuCheFragment;
import com.example.admin.quwang.view.fragment.ShouYeFragment;
import com.example.admin.quwang.view.fragment.WoDeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class MainModelImpl implements MainModel {
    @Override
    public void loadMainFragment(OnLoadFinishListenr<List<Fragment>> listenr) {
        List<Fragment> list=new ArrayList<>();
        list.add(new ShouYeFragment());
        list.add(new FaXianFragment());
        list.add(new GouWuCheFragment());
        list.add(new WoDeFragment());
        listenr.onSuccess(list, HttpModel.NORMAL);
    }
}
