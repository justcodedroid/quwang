package com.example.admin.quwang.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.databinding.ActivityDetailsBinding;
import com.example.admin.quwang.presenter.DetatilsPresenter;
import com.example.admin.quwang.view.DetailsView;
import com.example.admin.quwang.view.extend.SuperScrollerView;

/**
 * Created by admin on 2017/3/27.
 */

public class DetatilsActivity extends BaseActivity<ActivityDetailsBinding> implements DetailsView {

    private DetatilsPresenter presenter;

    @Override
    protected void initImpl() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        presenter = new DetatilsPresenter();
        presenter.setDetailsView(this);
        loadData();
    }

    private void loadData() {
        int id = getIntent().getIntExtra("id", 0);
        presenter.loadDeatilsBean(id);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }


    @Override
    public void relashInfoDatas(DetailsBean.InfoBean infoBean) {
        bind.setInfobean(infoBean);
    }

    @Override
    public void relashWebView(String infoContent) {
        bind.wv.getSettings().setJavaScriptEnabled(true);
        bind.wv.addJavascriptInterface(new Andrroid(), "android");

        bind.wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bind.wv.loadUrl("javascript:" + "" +
                        "var imgs=document.getElementsByTagName('img');" +
                        "var arr=new Array(imgs.length);" +
                        "for (var i=0;i<imgs.length;i++){" +
                        "var img=imgs[i];" +
                        "arr[i]=img.src;" +
                        "img.onclick=function(){" +
                        "android.show(" +
                        "this.src," +
                        "arr" +
                        ");" +
                        "};" +

                        "};" +
                        "");

            }
        });

        bind.wv.loadDataWithBaseURL(null, infoContent, "text/html", "utf-8", "");
    }

    class Andrroid {
        @JavascriptInterface
        public void show(String img, String[] imgs) {
            Intent intent = new Intent(DetatilsActivity.this, TuPianYuLanActivity.class);
            intent.putExtra("img", img);
            intent.putExtra("imgs", imgs);
            startActivity(intent);
        }
    }

    @Override
    public void onRetryClick() {
        super.onRetryClick();
        loadData();
    }
}
