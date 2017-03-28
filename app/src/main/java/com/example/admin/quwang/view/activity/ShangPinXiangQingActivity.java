package com.example.admin.quwang.view.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;
import com.example.admin.quwang.databinding.ActivityShangPinXiangQingBinding;
import com.example.admin.quwang.presenter.ShangPinXiangQingPresenter;
import com.example.admin.quwang.view.ShangPinXiangQingView;

import java.util.List;

public class ShangPinXiangQingActivity extends BaseActivity<ActivityShangPinXiangQingBinding> implements ShangPinXiangQingView {

    private ShangPinXiangQingPresenter shangPinXiangQingPresenter;

    @Override
    protected void initImpl() {
        int goods_id = getIntent().getIntExtra("goods_id", 0);
        shangPinXiangQingPresenter = new ShangPinXiangQingPresenter();
        shangPinXiangQingPresenter.setShangPinXiangQingView(this);
        shangPinXiangQingPresenter.loadShangPinXiangQingFragments(goods_id);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shang_pin_xiang_qing;
    }

    @Override
    public void relashShangPinXiangQingFragments(List<Fragment> list) {
        bind.pager.setAdapter(new ShangPinXiangQingAdapter(getSupportFragmentManager(), list));
        bind.tab.setupWithViewPager(bind.pager);
    }
}
