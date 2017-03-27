package com.example.admin.quwang.presenter;

import android.util.Log;

import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.WebModel;
import com.example.admin.quwang.model.WebModelImpl;
import com.example.admin.quwang.view.WebView;

/**
 * Created by admin on 2017/3/27.
 */

public class WebPresenter implements OnLoadFinishListenr<WebResultBean> {
    WebModel webModel = new WebModelImpl();
    private WebView webView;

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public void getWebResultBean(String topicId) {
        webView.showLoading();
        webModel.loadWebResultBean(topicId, this);
    }

    @Override
    public void onSuccess(WebResultBean bean, int type) {
        webView.relashWebView(bean);
        webView.showNormal();
    }

    @Override
    public void onError(String msg, int errorCode) {
        Log.e("tag","请求网页出错---->"+msg+"-----<"+errorCode);
        webView.showError();
    }
}
