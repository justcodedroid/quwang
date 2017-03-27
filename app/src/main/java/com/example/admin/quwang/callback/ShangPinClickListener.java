package com.example.admin.quwang.callback;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.quwang.bean.ShangPinBean;

/**
 * Created by admin on 2017/3/27.
 */

public class ShangPinClickListener {
    Context context;

    public ShangPinClickListener(Context context) {
        this.context = context;
    }
    public void onItemClick(ShangPinBean shangPinBean){
        Toast.makeText(context, ""+shangPinBean.getGoods_name(), Toast.LENGTH_SHORT).show();
    }
}
