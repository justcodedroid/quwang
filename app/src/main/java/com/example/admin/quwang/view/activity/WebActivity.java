package com.example.admin.quwang.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.WebBean;
import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.databinding.ActivityWebBinding;
import com.example.admin.quwang.presenter.WebPresenter;
import com.example.admin.quwang.view.WebView;

public class WebActivity extends BaseActivity<ActivityWebBinding> implements WebView {

    private WebBean webBean;
    private WebPresenter webPresenter;
    private WebChromeClient webChromeClient= new WebChromeClient() {
        @Override
        public void onProgressChanged(android.webkit.WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100) {
                bind.pb.setVisibility(View.GONE);
            } else {
                bind.pb.setVisibility(View.VISIBLE);
                bind.pb.setProgress(newProgress);
            }

        }

        @Override
        public void onReceivedTitle(android.webkit.WebView view, String title) {
            super.onReceivedTitle(view, title);
            bind.setTitle(title);
        }
    };
    @Override
    protected void initImpl() {
        init();
        initwebview();
        initPresenter();
    }

    private void init() {
        webBean = getIntent().getParcelableExtra("webbean");

    }

    private void initPresenter() {
        webPresenter = new WebPresenter();
        webPresenter.setWebView(this);
        webPresenter.getWebResultBean(webBean.getLinkurl());
    }

    private void initwebview() {
        bind.wv.getSettings().setJavaScriptEnabled(true);
        bind.wv.setWebChromeClient(new WebChromeClient());
        bind.wv.setWebChromeClient(webChromeClient);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }


    @Override
    public void relashWebView(WebResultBean bean) {
        String link_url = bean.getData().getLink_url();
        bind.wv.loadUrl(link_url);
    }
}
