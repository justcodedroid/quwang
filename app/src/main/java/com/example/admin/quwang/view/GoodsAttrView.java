package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.GoodsAttrBean;

/**
 * Created by admin on 2017/4/4.
 */

public interface GoodsAttrView  {
    void showLoadingDialog();
    void dismissLoadingDialog();
    void showGoodsAttrError(String msg);
    void relashGoodsAttr(GoodsAttrBean goodsAttrBean);
}
