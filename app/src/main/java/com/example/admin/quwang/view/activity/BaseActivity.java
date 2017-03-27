package com.example.admin.quwang.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by admin on 2017/3/25.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, getLayoutId());
        initImpl();
    }

    protected abstract void initImpl();


    public abstract int getLayoutId();
    public void setFullScreen(){
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags|=WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attributes);
    }
    protected void startACT(String activity,boolean finish) {
        Intent intent=new Intent();
        intent.setClassName(this,activity);
        startActivity(intent);
        if(finish)
            finish();
    }
    public void replaceFragment(int fragmentGroup,Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(fragmentGroup,fragment).commit();
    }
}
