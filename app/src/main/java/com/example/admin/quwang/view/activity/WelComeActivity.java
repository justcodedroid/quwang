package com.example.admin.quwang.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.databinding.ActivityMainBinding;
import com.example.admin.quwang.presenter.WelcomePresenter;
import com.example.admin.quwang.view.WelcomeView;

import java.util.Locale;

import it.xabaras.android.logger.Logger;

public class WelComeActivity extends BaseActivity<ActivityMainBinding> implements WelcomeView {
    private WelcomePresenter presenter;
    private  int leftTime=3;
    Handler delayHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(leftTime==0){
                toMain(null);
            }else {
                bind.skipTv.setText("跳过\n"+leftTime+"s");
                leftTime--;
                delayHandler.sendEmptyMessageDelayed(0,1000);
            }
        }
    };
    @Override
    protected void initImpl() {
        setFullScreen();
        presenter = new WelcomePresenter();
        presenter.setWelComeView(this);
        presenter.loadWelComeBean();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void RelashData(WelcomeBean welcomeBean) {
        bind.setWelcomebean(welcomeBean.getData().getStart_ads_list());
        delayHandler.sendEmptyMessageDelayed(0,1000);
    }

    @Override
    public void showError(String msg, int errorCode) {
        toMain(null);
    }

    public void toMain(View v) {
        delayHandler.removeCallbacksAndMessages(null);
        startACT(MainActivity.class.getName(),true);
    }

    @Override
    protected void onDestroy() {

        delayHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

}
