package com.example.admin.quwang.callback;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.quwang.bean.EveryOneBuyBean;

/**
 * Created by admin on 2017/3/27.
 */

public class EveryOneBuyClickListener {
    Context ctx;

    public EveryOneBuyClickListener(Context ctx) {
        this.ctx = ctx;
    }
    public void onItemClick(EveryOneBuyBean buyBean){
        Toast.makeText(ctx, ""+buyBean.getMain_title(), Toast.LENGTH_SHORT).show();
    }
}
