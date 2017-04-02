package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.CatBean;
import com.example.admin.quwang.utils.ActivityRouter;
import com.example.admin.quwang.utils.PinLeiUtils;

/**
 * Created by admin on 2017/4/2.
 */

public class CatItemClickListener {
    Context context;

    public CatItemClickListener(Context context) {
        this.context = context;
    }
    public void toPinLeiActivity(CatBean catBean){
        PinLeiUtils.startPinLeiActivity(context,catBean.getLink_url(),0);
    }
}
