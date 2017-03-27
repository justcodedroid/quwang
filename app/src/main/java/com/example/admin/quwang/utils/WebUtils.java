package com.example.admin.quwang.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.admin.quwang.bean.WebBean;
import com.example.admin.quwang.view.activity.WebActivity;

/**
 * Created by admin on 2017/3/27.
 */

public class WebUtils {
    public static void startWebActivity(Context context,String link_url,String title){
        Intent intent=new Intent(context, WebActivity.class);
        WebBean webBean = new WebBean();
        webBean.setLinkurl(link_url);
        webBean.setTitle(title);
        intent.putExtra("webbean",webBean);
       context.startActivity(intent);
    }

    public static void startOtherWebActivity(Context a, String link_url) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link_url));
        a.startActivity(intent);
    }
}
