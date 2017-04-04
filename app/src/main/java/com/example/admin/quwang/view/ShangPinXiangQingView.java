package com.example.admin.quwang.view;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public interface ShangPinXiangQingView extends BaseView{
void relashShangPinXiangQingFragments(List<Fragment> list);
    void shoucangSuccess(String msg, String collectionId);
    void shoucangFailed(String msg);
    void shouGouWuChe(String msg);
    void showLoadingDialog();
    void  dismissLoadingDialog();
}
