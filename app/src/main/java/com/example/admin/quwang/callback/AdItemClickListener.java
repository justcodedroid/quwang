package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.utils.ActivityRouter;

/**
 * Created by admin on 2017/4/3.
 */

public class AdItemClickListener {
    Context context;

    public AdItemClickListener(Context context) {
        this.context = context;
    }
    public void to(PinLeiBean.AdInfo info){
        ActivityRouter.router(context,info.getType(),info.getLink_url(),0,0);
    }
}
