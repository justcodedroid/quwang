package com.example.admin.quwang.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.quwang.bean.OtherRecommendListBean;
import com.example.admin.quwang.databinding.ItemOtherRecommandBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class SuperListViewUtils {
    public static List<View> convertOtherRecommandViews(List<OtherRecommendListBean> listBeanList, Context context){
        List<View> list=new ArrayList<>();
        LayoutInflater inflater=LayoutInflater.from(context);
        for (int i = 0; i < listBeanList.size(); i++) {
            ItemOtherRecommandBinding inflate = ItemOtherRecommandBinding.inflate(inflater);
            inflate.setRecommandbean(listBeanList.get(i));
            list.add(inflate.getRoot());
        }
        return list;

    }
}
