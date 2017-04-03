package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.Categorybean;

import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public interface AllCategoryView extends BaseView {
    void relashAllCategoryBeans(List<Categorybean.SubCategoryBean> list);
}
