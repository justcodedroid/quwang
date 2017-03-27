package com.example.admin.quwang.utils;

import android.content.Context;

/**
 * Created by admin on 2017/3/27.
 */

public class DimenUtils {
    public static int dp2px(Context ctx,int dp){
        return (int) (ctx.getResources().getDisplayMetrics().density*dp+0.5f);
    }
}
