package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public  class OtherRecommendListBean {
    /**
     * main_title : 男用兵器&凸点推荐
     * subtitle : 少年快入寝，春宵一刻值千金
     * img_url : http://img.api.m.qu.cn/images/api/20170302/ea7b4fae8484aa3d3b9e3035460ff9f4.jpeg
     * link_url : 111
     * type : 6
     * ad_list : [{"link_url":"6267","main_title":"双穴美臀","subtitle":"性感诱惑","img_url":"http://img.api.m.qu.cn/images/api/20160726/b025590d1b92b08c31074a57b6539051.jpeg","type":1,"type_name":"商品"},{"link_url":"7577","main_title":"一器两用","subtitle":"飞机杯和增大器","img_url":"http://img.api.m.qu.cn/images/api/20160513/2551b3fc9694d72013d429d7ae3c03b3.jpeg","type":1,"type_name":"商品"},{"link_url":"4776","main_title":"兽兽私处","subtitle":"嫩模高潮名器","img_url":"http://img.api.m.qu.cn/images/api/20160513/fb09f523615bdcfce20539d4873c73a0.jpeg","type":1,"type_name":"商品"},{"link_url":"1453","main_title":"前列腺刺激","subtitle":"体验双重快感","img_url":"http://img.api.m.qu.cn/images/api/20160802/24eb33c068224758379d14fd238e249a.png","type":1,"type_name":"商品"},{"link_url":"136","main_title":"飞机杯专场","subtitle":"自嗨必备","img_url":"http://img.api.m.qu.cn/images/api/20160802/93fa5c0bdb4739dee6ac822f393647f9.png","type":6,"type_name":"专题"}]
     */


    private String main_title;
    private String subtitle;
    private String img_url;
    private String link_url;
    private int type;
    private List<AdListBean> ad_list;

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

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<AdListBean> getAd_list() {
        return ad_list;
    }

    public void setAd_list(List<AdListBean> ad_list) {
        this.ad_list = ad_list;
    }


}