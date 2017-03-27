package com.example.admin.quwang.model;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.callback.OnLoadFinishListenr;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public interface MainModel {
    void loadMainFragment(OnLoadFinishListenr<List<Fragment>> listenr);
}
