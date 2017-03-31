package com.example.admin.quwang.callback;

import android.content.Context;
import android.content.Intent;

import com.example.admin.quwang.view.activity.PingJiaActivity;

/**
 * Created by admin on 2017/3/30.
 */

public class AllPingJiaListener {
    Context context;

    public AllPingJiaListener(Context context) {
        this.context = context;
    }

    public void toPingJiaActivity(int goodsId) {
        Intent intent = new Intent(context, PingJiaActivity.class);
        intent.putExtra("goods_id", goodsId);
        context.startActivity(intent);
    }
}
