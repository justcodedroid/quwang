package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/26.
 */

public  class AdListBean {
    /**
     * link_url : 6267
     * main_title : 双穴美臀
     * subtitle : 性感诱惑
     * img_url : http://img.api.m.qu.cn/images/api/20160726/b025590d1b92b08c31074a57b6539051.jpeg
     * type : 1
     * type_name : 商品
     */

    private String link_url;
    private String main_title;
    private String subtitle;
    private String img_url;
    private int type;
    private String type_name;
    private String goods_price;

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }
    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
