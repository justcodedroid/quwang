package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public class Categorybean {
    private String cat_name;
    private List<SubCategoryBean> sub_category;


    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<SubCategoryBean> getSub_category() {
        return sub_category;
    }

    public void setSub_category(List<SubCategoryBean> sub_category) {
        this.sub_category = sub_category;
    }

    public static class SubCategoryBean {
        private String cat_img;
        private String cat_name;
        private int is_hot;
        private String link_url;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        private int type;

        public String getCat_img() {
            return cat_img;
        }

        public void setCat_img(String cat_img) {
            this.cat_img = cat_img;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public int getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(int is_hot) {
            this.is_hot = is_hot;
        }

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }
    }

}
