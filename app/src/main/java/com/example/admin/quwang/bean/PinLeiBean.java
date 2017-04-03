package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/31.
 */

public class PinLeiBean {
    private int c_page_next;
    private int c_total;
    private String link_url;
    private int page_total;
    private List<SimpleShangPinBean> goods_list;
    private List<CatBean> cat_list;
    private GuoLvTiaoJian screening;
    private AdInfo ad_info;

    public AdInfo getAd_info() {
        return ad_info;
    }

    public void setAd_info(AdInfo ad_info) {
        this.ad_info = ad_info;
    }

    public static class AdInfo {
        private String img_url;
        private String link_url;
        private String main_title;
        private String subtitle;
        private int type;
        private String type_name;

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

    public int getC_page_next() {
        return c_page_next;
    }

    public void setC_page_next(int c_page_next) {
        this.c_page_next = c_page_next;
    }

    public int getC_total() {
        return c_total;
    }

    public void setC_total(int c_total) {
        this.c_total = c_total;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public List<SimpleShangPinBean> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<SimpleShangPinBean> goods_list) {
        this.goods_list = goods_list;
    }

    public List<CatBean> getCat_list() {
        return cat_list;
    }

    public void setCat_list(List<CatBean> cat_list) {
        this.cat_list = cat_list;
    }

    public GuoLvTiaoJian getScreening() {
        return screening;
    }

    public void setScreening(GuoLvTiaoJian screening) {
        this.screening = screening;
    }

    public static class SimpleShangPinBean {
        private float app_price;
        private int comment_num;
        private int goods_id;
        private String goods_name;
        private int hot;
        private String img_url;
        private int is_free_shipping;
        private int is_new;
        private int promote;
        private int sold_num;
        private int vedio;

        public float getApp_price() {
            return app_price;
        }

        public void setApp_price(float app_price) {
            this.app_price = app_price;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getHot() {
            return hot;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getIs_free_shipping() {
            return is_free_shipping;
        }

        public void setHot(int ht) {
            this.hot = ht;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int is_free_shipping() {
            return is_free_shipping;
        }

        public void setIs_free_shipping(int is_free_shipping) {
            this.is_free_shipping = is_free_shipping;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public int getPromote() {
            return promote;
        }

        public void setPromote(int promote) {
            this.promote = promote;
        }

        public int getSold_num() {
            return sold_num;
        }

        public void setSold_num(int sold_num) {
            this.sold_num = sold_num;
        }

        public int getVedio() {
            return vedio;
        }

        public void setVedio(int vedio) {
            this.vedio = vedio;
        }
    }

    public static class GuoLvTiaoJian {
        private List<BrandBean> brands;
        private List<Characteristic> characteristic;
        private List<PriceGrade> price_grade;

        public List<BrandBean> getBrands() {
            return brands;
        }

        public void setBrands(List<BrandBean> brands) {
            this.brands = brands;
        }

        public List<Characteristic> getCharacteristic() {
            return characteristic;
        }

        public void setCharacteristic(List<Characteristic> characteristic) {
            this.characteristic = characteristic;
        }

        public List<PriceGrade> getPrice_grade() {
            return price_grade;
        }

        public void setPrice_grade(List<PriceGrade> price_grade) {
            this.price_grade = price_grade;
        }
    }

}
