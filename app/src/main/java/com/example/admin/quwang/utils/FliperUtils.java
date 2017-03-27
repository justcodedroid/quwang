package com.example.admin.quwang.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.quwang.bean.HotDailyBean;
import com.example.admin.quwang.databinding.ItemHotDailyBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class FliperUtils {
    public static List<View> convertToHotDailyView(List<HotDailyBean> hotDailyBeen, Context context){
        List<View> list=new ArrayList<>();
        LayoutInflater inflater=LayoutInflater.from(context);
        for (int i = 0; i < hotDailyBeen.size(); i++) {
            HotDailyBean hotDailyBean = hotDailyBeen.get(i);
            ItemHotDailyBinding binding = ItemHotDailyBinding.inflate(inflater);
            binding.setHotdaily(hotDailyBean);
            list.add(binding.getRoot());
        }
        return list;
    }
}
