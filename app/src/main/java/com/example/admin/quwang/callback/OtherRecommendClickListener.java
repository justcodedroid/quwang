package com.example.admin.quwang.callback;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.quwang.bean.AdListBean;
import com.example.admin.quwang.bean.OtherRecommendListBean;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.utils.WebUtils;

/**
 * Created by admin on 2017/3/27.
 */

public class OtherRecommendClickListener {
    Context context;
    public OtherRecommendClickListener(Context context){
        this.context=context;
    }
    public void onMoreClick(OtherRecommendListBean bean){

        Toast.makeText(context, ""+bean.getMain_title(), Toast.LENGTH_SHORT).show();
    };
    public void onItemClick(AdListBean bean){
        int type = bean.getType();
        if(type== HttpModel.TYPEWEB){
            WebUtils.startWebActivity(context,bean.getLink_url(),bean.getMain_title());
        }
        Log.e("tag",type+"");
        if(type==HttpModel.TYPESHANGPINGXIANGQING){
            Toast.makeText(context, "商品详情--》", Toast.LENGTH_SHORT).show();

        }
    }
}
