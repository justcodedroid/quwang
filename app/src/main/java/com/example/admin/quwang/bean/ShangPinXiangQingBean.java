package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */

public class ShangPinXiangQingBean {
    private  int comment_count;
    private int package_total;
    private BonusInfoGroup bonus_info;
    private List<PingJiaBean> comment_list;
    private List<GoodsAD> goods_ad;
    private GoodsFloatAD goods_float_ad;
    private List<String> goods_gallery;
    private GoodsInfo goods_info;
    private List<RecommendGood> recommend_goods;

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getPackage_total() {
        return package_total;
    }

    public void setPackage_total(int package_total) {
        this.package_total = package_total;
    }

    public BonusInfoGroup getBonus_info() {
        return bonus_info;
    }

    public void setBonus_info(BonusInfoGroup bonus_info) {
        this.bonus_info = bonus_info;
    }

    public List<PingJiaBean> getComment_list() {
        return comment_list;
    }

    public void setComment_list(List<PingJiaBean> comment_list) {
        this.comment_list = comment_list;
    }

    public List<GoodsAD> getGoods_ad() {
        return goods_ad;
    }

    public void setGoods_ad(List<GoodsAD> goods_ad) {
        this.goods_ad = goods_ad;
    }

    public GoodsFloatAD getGoods_float_ad() {
        return goods_float_ad;
    }

    public void setGoods_float_ad(GoodsFloatAD goods_float_ad) {
        this.goods_float_ad = goods_float_ad;
    }

    public List<String> getGoods_gallery() {
        return goods_gallery;
    }

    public void setGoods_gallery(List<String> goods_gallery) {
        this.goods_gallery = goods_gallery;
    }

    public GoodsInfo getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(GoodsInfo goods_info) {
        this.goods_info = goods_info;
    }

    public List<RecommendGood> getRecommend_goods() {
        return recommend_goods;
    }

    public void setRecommend_goods(List<RecommendGood> recommend_goods) {
        this.recommend_goods = recommend_goods;
    }

    public static class BonusInfoGroup{
        private List<BonusInfo> already_receive;
        private List<BonusInfo> can_receive;

        public List<BonusInfo> getAlready_receive() {
            return already_receive;
        }

        public void setAlready_receive(List<BonusInfo> already_receive) {
            this.already_receive = already_receive;
        }

        public List<BonusInfo> getCan_receive() {
            return can_receive;
        }

        public void setCan_receive(List<BonusInfo> can_receive) {
            this.can_receive = can_receive;
        }
    }
}
