package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/26.
 */

public  class TopAdsBean {
    /**
     * link_url : 96
     * main_title : 2016延时排行榜
     * subtitle : 压抑了这么久？这次让她喊破喉咙！
     * img_url : http://img.api.m.qu.cn/images/api/20160810/d7b015c83e2b4570d2f61e14dd537079.jpeg
     * type : 6
     * type_name : 专题
     */

    private String link_url;
    private String main_title;
    private String subtitle;
    private String img_url;
    private int type;
    private String type_name;

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
