package com.example.admin.quwang.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.quwang.bean.TopAdsBean;
import com.example.admin.quwang.databinding.ItemBannerBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class BannerUtils {
    public static List<View> convert(List<TopAdsBean> list, Context ctx) {
        List<View> views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        for (int i = 0; i < list.size(); i++) {
            ItemBannerBinding binding = ItemBannerBinding.inflate(inflater);
            binding.setTopads(list.get(i));
            views.add(binding.getRoot());
        }
        return views;
    }

    public static void increateData(List list) {
        if (list.size() == 1) {
            list.addAll(list);
            list.addAll(list);
        }
        if (list.size() == 2) {
            list.addAll(list);
        }
    }
}
