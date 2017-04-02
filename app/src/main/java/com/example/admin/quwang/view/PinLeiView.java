package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.CatBean;
import com.example.admin.quwang.bean.PinLeiBean;

import java.util.List;

/**
 * Created by admin on 2017/4/1.
 */

public interface PinLeiView extends BaseView{
    void realshShangPinBeans(List<PinLeiBean.SimpleShangPinBean> simpleShangPinBeens,int type);
    void relashCatBeans(List<CatBean> catBeanList);
    void showError(String msg);
}
