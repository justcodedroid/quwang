package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.utils.PinLeiUtils;

/**
 * Created by admin on 2017/4/3.
 */

public class HotRecommendListener {
    public Context context;

    public HotRecommendListener(Context context) {
        this.context = context;
    }
    public void to(FaXianBean.DataBean.HotRecommendBean bean){
        PinLeiUtils.startPinLeiActivity(context,bean.getLink_url(),bean.getAd_id());
    }
}
