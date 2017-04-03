package com.example.admin.quwang.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.AllCategoryAdapter;
import com.example.admin.quwang.bean.Categorybean;
import com.example.admin.quwang.databinding.ActivityAllCategoryBinding;
import com.example.admin.quwang.presenter.AllCategoryPresenter;
import com.example.admin.quwang.view.AllCategoryView;

import java.util.List;

public class AllCategoryActivity extends BaseActivity<ActivityAllCategoryBinding> implements AllCategoryView {


    private AllCategoryPresenter presenter;

    @Override
    protected void initImpl() {
        presenter = new AllCategoryPresenter();
        presenter.setAllCategoryView(this);
        presenter.loadAllCategoryBeans();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_category;
    }

    @Override
    public void relashAllCategoryBeans(List<Categorybean.SubCategoryBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        bind.recycler.setLayoutManager(gridLayoutManager);
        bind.recycler.setAdapter(new AllCategoryAdapter(list, this, gridLayoutManager));
    }

    @Override
    public void onRetryClick() {
        super.onRetryClick();
        presenter.loadAllCategoryBeans();
    }
}
