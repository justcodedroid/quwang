package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.utils.ActivityRouter;

/**
 * Created by admin on 2017/4/2.
 */

public class PinLeiItemClickListener {
    Context context;

    public PinLeiItemClickListener(Context context) {
        this.context = context;
    }
    public void to(PinLeiBean.SimpleShangPinBean bean){
        ActivityRouter.router(context, HttpModel.TYPESHANGPINGXIANGQING,bean.getGoods_id()+"",0,0);
    }

}
