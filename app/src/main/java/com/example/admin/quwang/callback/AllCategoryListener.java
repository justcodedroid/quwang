package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.Categorybean;
import com.example.admin.quwang.utils.PinLeiUtils;

/**
 * Created by admin on 2017/4/2.
 */

public class AllCategoryListener {
    Context context;

    public AllCategoryListener(Context context) {
        this.context = context;
    }
    public void toPinLeiActivity(Categorybean.SubCategoryBean subCategoryBean){
        PinLeiUtils.startPinLeiActivity(context,subCategoryBean.getLink_url(),0);
    }
}
