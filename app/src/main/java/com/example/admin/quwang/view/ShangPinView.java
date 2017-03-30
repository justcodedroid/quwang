package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.GoodsInfo;
import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.bean.RecommendGood;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */

public interface ShangPinView extends BaseView{

    void relashGoodsGallery(List<String> goodsGalllery);
    void relashGoodsInfo(GoodsInfo goodsInfo);
    void relashQuanBean(ShangPinXiangQingBean.BonusInfoGroup bonusInfoGroup);
    void relashPingJia(List<PingJiaBean> pingJiaBeanList,int commentCount);
    void relashTuiJian(List<RecommendGood> recommendGoodList);
}
