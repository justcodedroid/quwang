package com.example.admin.quwang.callback;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.quwang.bean.ShangPinBean;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.utils.ActivityRouter;
import com.example.admin.quwang.utils.ShangPinXiangQingUtils;

/**
 * Created by admin on 2017/3/27.
 */

public class ShangPinClickListener {
    Context context;

    public ShangPinClickListener(Context context) {
        this.context = context;
    }

    public void onItemClick(ShangPinBean shangPinBean) {
        ActivityRouter.router(context, HttpModel.TYPESHANGPINGXIANGQING, shangPinBean.getGoods_id() + "");
    }
}
