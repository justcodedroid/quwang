package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.DetailsBean;

/**
 * Created by admin on 2017/3/27.
 */

public interface DetailsView extends BaseView{
    void relashInfoDatas(DetailsBean.InfoBean infoBean);
    void relashWebView(String infoContent);
}
