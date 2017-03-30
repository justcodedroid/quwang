package com.example.admin.quwang.view.activity;

import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.WebBean;
import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.databinding.ActivityWebBinding;
import com.example.admin.quwang.presenter.WebPresenter;
import com.example.admin.quwang.utils.ShangPinXiangQingUtils;
import com.example.admin.quwang.view.WebView;

public class WebActivity extends BaseActivity<ActivityWebBinding> implements WebView {

    private WebBean webBean;
    private WebPresenter webPresenter;
    private WebChromeClient webChromeClient = new WebChromeClient() {
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
        bind.wv.addJavascriptInterface(new Android(), "zt");
        bind.wv.setWebViewClient(new WebViewClient());
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

    private class Android {
        @JavascriptInterface
        public void clickOnTopic(int goodsid, int speical_type, int specialId, int goods_attr) {
            ShangPinXiangQingUtils.startShangPingXiangQingActivity(WebActivity.this, goodsid, speical_type, specialId);
        }

        @JavascriptInterface
        public void clickOnLogin() {
            Toast.makeText(WebActivity.this, "登陆", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void clickOnCart() {
            Toast.makeText(WebActivity.this, "购物车", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void clickOnBonus() {
            Toast.makeText(WebActivity.this, "查看优惠卷", Toast.LENGTH_SHORT).show();
        }
    }
}
