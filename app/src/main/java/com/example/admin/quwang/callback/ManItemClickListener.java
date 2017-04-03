package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.utils.PinLeiUtils;

/**
 * Created by admin on 2017/4/3.
 */

public class ManItemClickListener {
    Context context;

    public ManItemClickListener(Context context) {
        this.context = context;
    }
    public void to(FaXianBean.DataBean.ManBean manBean){
        PinLeiUtils.startPinLeiActivity(context,manBean.getLink_url(),manBean.getAd_id());
    }
}
