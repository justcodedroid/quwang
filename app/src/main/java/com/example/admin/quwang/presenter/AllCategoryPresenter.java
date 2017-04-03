package com.example.admin.quwang.presenter;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.CategoryList;
import com.example.admin.quwang.bean.Categorybean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.AllCategoryImpl;
import com.example.admin.quwang.model.AllCategoryModel;
import com.example.admin.quwang.view.AllCategoryView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public class AllCategoryPresenter implements OnLoadFinishListenr<BaseBean<CategoryList>> {
    AllCategoryModel allCategoryModel = new AllCategoryImpl();
    AllCategoryView allCategoryView;

    public void setAllCategoryView(AllCategoryView allCategoryView) {
        this.allCategoryView = allCategoryView;
    }

    public void loadAllCategoryBeans() {
        allCategoryView.showNormal();
        allCategoryModel.loadAllCategoryBeans(this);
    }

    @Override
    public void onSuccess(BaseBean<CategoryList> bean, int type) {
        List<Categorybean> category_list = bean.getData().getCategory_list();
        List<Categorybean.SubCategoryBean> list = new ArrayList<>();
        for (int i = 0; i < category_list.size(); i++) {
            Categorybean categorybean = category_list.get(i);
            Categorybean.SubCategoryBean parent = new Categorybean.SubCategoryBean();
            parent.setCat_name(categorybean.getCat_name());
            parent.setType(1);
            list.add(parent);
            list.addAll(categorybean.getSub_category());
        }
        allCategoryView.relashAllCategoryBeans(list);
        allCategoryView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        allCategoryView.showError();
    }
}
