package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/26.
 */

public  class PromotionListBean {
    /**
     * img_url : http://s-api.dddua.com/t/300x300/images/201609/source_img/10096_P_1474959821664.jpg
     * goods_id : 10096
     * goods_attr : 111866
     * goods_name : 取悦 黑武士男用锁精震动套环 水晶套夫妻高潮套
     * special_type : 1
     * special_id : 13661
     * app_price : 42
     */

    private String img_url;
    private int goods_id;
    private int goods_attr;
    private String goods_name;
    private int special_type;
    private String special_id;
    private int app_price;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_attr() {
        return goods_attr;
    }

    public void setGoods_attr(int goods_attr) {
        this.goods_attr = goods_attr;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getSpecial_type() {
        return special_type;
    }

    public void setSpecial_type(int special_type) {
        this.special_type = special_type;
    }

    public String getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(String special_id) {
        this.special_id = special_id;
    }

    public int getApp_price() {
        return app_price;
    }

    public void setApp_price(int app_price) {
        this.app_price = app_price;
    }
}
