package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.FaXianBean;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */

public interface FaXianView extends BaseView {
void relashHotRecommand(List<FaXianBean.DataBean.HotRecommendBean> hotRecommendBeanList);
    void relashTopicBeans(List<FaXianBean.DataBean.HotTopicBean> topicBeanList);
    void relashMan(List<FaXianBean.DataBean.ManBean> manBeanList);
    void relashWoman(List<FaXianBean.DataBean.ManBean> womanList);
}
