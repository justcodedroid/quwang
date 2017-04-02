package com.example.admin.quwang.utils;

import android.content.Context;
import android.content.Intent;

import com.example.admin.quwang.view.activity.PinLeiActivity;

/**
 * Created by admin on 2017/4/1.
 */

public class PinLeiUtils {
    public static void startPinLeiActivity(Context context, String pinleiid, int ad_id) {
        Intent intent = new Intent(context, PinLeiActivity.class);
        intent.putExtra("pinleiid", pinleiid);
        intent.putExtra("ad", ad_id);
        context.startActivity(intent);
    }
}
