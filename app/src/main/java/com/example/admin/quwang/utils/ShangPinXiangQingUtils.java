package com.example.admin.quwang.utils;

import android.content.Context;
import android.content.Intent;

import com.example.admin.quwang.view.activity.ShangPinXiangQingActivity;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinXiangQingUtils {
    public static void startShangPingXiangQingActivity(Context context, int goods_id) {
        Intent intent = new Intent(context, ShangPinXiangQingActivity.class);
        intent.putExtra("goods_id", goods_id);
        context.startActivity(intent);

    }
}
