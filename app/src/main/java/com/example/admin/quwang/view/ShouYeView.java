package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.EveryOneBuyBean;
import com.example.admin.quwang.bean.HotDailyBean;
import com.example.admin.quwang.bean.HotListBean;
import com.example.admin.quwang.bean.OtherRecommendListBean;
import com.example.admin.quwang.bean.PromotionListBean;
import com.example.admin.quwang.bean.ShangPinBean;
import com.example.admin.quwang.bean.TopAdsBean;
import com.example.admin.quwang.view.extend.Banner;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public interface ShouYeView extends BaseView {

    void relashBannersData(List<TopAdsBean> top_ads);
    void relashHotListData(List<HotListBean> hotListBeanList);
    void relashHotDaily(List<HotDailyBean> hotDailyBeanList);
    void relashRetaimeTime(long time);
    void relashPromotionList(List<PromotionListBean> promotionListBeanList);
    void relashOthRecommendList(List<OtherRecommendListBean> otherRecommendListBeanList);
    void relashEveryOneButList(List<EveryOneBuyBean> everyOneBuyBeanList);
    void relashRecommendList(List<ShangPinBean> shangPinBeanList);
}
