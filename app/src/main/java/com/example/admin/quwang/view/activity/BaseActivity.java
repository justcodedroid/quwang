package com.example.admin.quwang.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.ActivityBaseBinding;
import com.example.admin.quwang.utils.IMMLeaks;
import com.example.admin.quwang.view.BaseView;
import com.example.admin.quwang.view.extend.StateLayout;

/**
 * Created by admin on 2017/3/25.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements BaseView, StateLayout.OnRetryClickListener {
    protected T bind;
    private ActivityBaseBinding basebind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        basebind = DataBindingUtil.setContentView(this, R.layout.activity_base);
        basebind.statusLayout.setOnRetryClickListener(this);
        bind = DataBindingUtil.inflate(LayoutInflater.from(this), getLayoutId(), basebind.containerParent, true);
        initImpl();
//        IMMLeaks.fixFocusedViewLeak(getApplication());
    }

    protected abstract void initImpl();


    public abstract int getLayoutId();

    public void setFullScreen() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attributes);
    }

    protected void startACT(String activity, boolean finish) {
        Intent intent = new Intent();
        intent.setClassName(this, activity);
        startActivity(intent);
        if (finish)
            finish();
    }

    public void replaceFragment(int fragmentGroup, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(fragmentGroup, fragment).commit();
    }

    @Override
    public void showError() {
        basebind.statusLayout.switchToError();
    }

    @Override
    public void showLoading() {
        basebind.statusLayout.swicthToLoading();
    }

    @Override
    public void showNormal() {
        basebind.statusLayout.switchToNormal();
    }

    @Override
    public void onRetryClick() {

    }

    public void finish(View v) {
        finish();
    }
}
