package com.example.admin.quwang.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.bean.HotListBean;
import com.example.admin.quwang.bean.PromotionListBean;
import com.example.admin.quwang.bean.RecommendGood;
import com.example.admin.quwang.callback.HotRecommendListener;
import com.example.admin.quwang.callback.TopicItemClickListener;
import com.example.admin.quwang.databinding.ItemFaxianLvBinding;
import com.example.admin.quwang.databinding.ItemHotListBinding;
import com.example.admin.quwang.databinding.ItemPromotionBinding;
import com.example.admin.quwang.databinding.ItemTopicBinding;
import com.example.admin.quwang.databinding.ItemTuijianBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class HorizontalListViewUtils {
    public static List<View> convertHotListViews(List<HotListBean> hotListBeanList, Context context) {
        List<View> list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < hotListBeanList.size(); i++) {
            ItemHotListBinding binding = ItemHotListBinding.inflate(inflater);
            binding.setHotlist(hotListBeanList.get(i));
            list.add(binding.getRoot());
        }
        return list;
    }

    public static List<View> convertPromotionList(List<PromotionListBean> promotionListBeanList, Activity a) {
        List<View> list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(a);
        for (int i = 0; i < promotionListBeanList.size(); i++) {
            PromotionListBean promotionListBean = promotionListBeanList.get(i);
            ItemPromotionBinding inflate = ItemPromotionBinding.inflate(inflater);
            inflate.setPromotionbean(promotionListBean);
            list.add(inflate.getRoot());
        }
        return list;
    }

    public static List<View> convertTuiJianViews(List<RecommendGood> recommendGoodList, Context a) {
        List<View> list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(a);
        for (int i = 0; i < recommendGoodList.size(); i++) {
            RecommendGood recommendGood = recommendGoodList.get(i);
            ItemTuijianBinding inflate = ItemTuijianBinding.inflate(inflater);
            inflate.setGoodbean(recommendGood);
            list.add(inflate.getRoot());
        }
        return list;
    }

    public static List<View> convertRecommendViews(List<FaXianBean.DataBean.HotRecommendBean> hotRecommendBeanList,Context a) {
        List<View> list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(a);
        for (int i = 0; i < hotRecommendBeanList.size(); i++) {
            ItemFaxianLvBinding inflate = ItemFaxianLvBinding.inflate(inflater);
            inflate.setHot(hotRecommendBeanList.get(i));
            inflate.setClick(new HotRecommendListener(a));
            list.add(inflate.getRoot());
        }
        return list;
    }

    public static List<View> convertTopicViews(List<FaXianBean.DataBean.HotTopicBean> topicBeanList, Context a) {
        List<View> list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(a);
        for (int i = 0; i < topicBeanList.size(); i++) {
            ItemTopicBinding inflate = ItemTopicBinding.inflate(inflater);
            inflate.setTopic(topicBeanList.get(i));
            inflate.setClick(new TopicItemClickListener(a));
            list.add(inflate.getRoot());
        }
        return list;
    }
}
