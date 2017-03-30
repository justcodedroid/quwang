package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/30.
 */

public class RecommendGood {
    private float app_price;
    private int goods_id;
    private String goods_img;
    private String goods_name;

    public float getApp_price() {
        return app_price;
    }

    public void setApp_price(float app_price) {
        this.app_price = app_price;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
}
