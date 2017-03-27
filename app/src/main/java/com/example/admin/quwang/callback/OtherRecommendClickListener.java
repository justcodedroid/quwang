package com.example.admin.quwang.callback;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.quwang.bean.AdListBean;
import com.example.admin.quwang.bean.OtherRecommendListBean;

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
        Toast.makeText(context, ""+bean.getMain_title(), Toast.LENGTH_SHORT).show();
    }
}
