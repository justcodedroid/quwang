package com.example.admin.quwang.callback;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.quwang.bean.EveryOneBuyBean;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.utils.ActivityRouter;

/**
 * Created by admin on 2017/3/27.
 */

public class EveryOneBuyClickListener {
    Context ctx;

    public EveryOneBuyClickListener(Context ctx) {
        this.ctx = ctx;
    }
    public void onItemClick(EveryOneBuyBean buyBean){
        ActivityRouter.router(ctx,buyBean.getType(),buyBean.getLink_url(),0,0);
    }
}
