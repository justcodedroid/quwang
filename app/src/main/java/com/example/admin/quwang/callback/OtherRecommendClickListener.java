package com.example.admin.quwang.callback;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.quwang.bean.AdListBean;
import com.example.admin.quwang.bean.OtherRecommendListBean;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.utils.ActivityRouter;
import com.example.admin.quwang.utils.ShangPinXiangQingUtils;
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
      ActivityRouter.router(context,bean.getType(),bean.getLink_url(),0,0);
    };
    public void onItemClick(AdListBean bean){
        ActivityRouter.router(context,bean.getType(),bean.getLink_url(),0,0);
    }
}
