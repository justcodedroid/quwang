package com.example.admin.quwang.model;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.CategoryList;
import com.example.admin.quwang.callback.OnLoadFinishListenr;

/**
 * Created by admin on 2017/4/2.
 */

public interface AllCategoryModel {
    void loadAllCategoryBeans(OnLoadFinishListenr<BaseBean<CategoryList>> listenr);
}
