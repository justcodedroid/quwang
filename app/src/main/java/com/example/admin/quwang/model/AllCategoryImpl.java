package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.CategoryList;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.utils.HttpUtils;

/**
 * Created by admin on 2017/4/2.
 */

public class AllCategoryImpl implements AllCategoryModel {
    @Override
    public void loadAllCategoryBeans(OnLoadFinishListenr<BaseBean<CategoryList>> listenr) {
        HttpUtils.loadAllCategoryBeans(listenr);
    }
}
