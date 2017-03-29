package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class PingJiaBean {
    private String add_time;
    private String avatar;
//    private List<String> comment_img_list;
    private String rank_name;
    private String region;
    private String user_comment;
    private String user_name;

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

//    public List<String> getComment_img_list() {
//        return comment_img_list;
//    }
//
//    public void setComment_img_list(List<String> comment_img_list) {
//        this.comment_img_list = comment_img_list;
//    }

    public String getRank_name() {
        return rank_name;
    }

    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
