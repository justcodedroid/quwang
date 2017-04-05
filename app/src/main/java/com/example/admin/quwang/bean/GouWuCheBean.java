package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/4/5.
 */

public class GouWuCheBean {

    /**
     * code : 200
     * message :
     * data : {"carts_list":[{"rec_id":2901876,"goods_id":5445,"is_special":0,"is_free_shipping":0,"special_type":0,"special_id":0,"goods_number":1,"goods_name":"omysky 梦青春USB直插式跳蛋","app_price":99,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201610%2Fsource_img%2F5445_P_1476955549507.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=890a007235442e583369c6dfbfaf52bfffdb3db9","goods_spec_name":"选择颜色:粉色","goods_attr_price":0,"expiry_at":0,"extension_code":"","is_expiry":1,"expire_msg":""},{"rec_id":2901871,"goods_id":5445,"is_special":0,"is_free_shipping":0,"special_type":0,"special_id":0,"goods_number":1,"goods_name":"omysky 梦青春USB直插式跳蛋","app_price":99,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201610%2Fsource_img%2F5445_P_1476955549507.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=890a007235442e583369c6dfbfaf52bfffdb3db9","goods_spec_name":"选择颜色:玫红色","goods_attr_price":0,"expiry_at":0,"extension_code":"","is_expiry":1,"expire_msg":""},{"rec_id":2901866,"goods_id":10086,"is_special":1,"is_free_shipping":0,"special_type":1,"special_id":14151,"goods_number":1,"goods_name":"取悦 震动刺激2代持久型锻炼器","app_price":49,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201609%2Fsource_img%2F10086_P_1474876684739.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=11a2f0fcd1b85d586f6554326d5e63246601e6ab","goods_spec_name":"","goods_attr_price":0,"expiry_at":1491398270,"extension_code":"","is_expiry":1,"expire_msg":"活动将于2017-04-05 09:20:44过期"}],"bonus_info":{"can_receive":[],"already_receive":[{"type_id":126,"type_name":"APP新人专享券80元","type_money":80,"use_start_date":1487904713,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":400,"bonus_description":"全场通用, 满400元可用"},{"type_id":121,"type_name":"APP新人专享券50元","type_money":50,"use_start_date":1487904664,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":300,"bonus_description":"全场通用, 满300元可用"},{"type_id":116,"type_name":"APP新人专享券30元","type_money":30,"use_start_date":1487904595,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":200,"bonus_description":"全场通用, 满200元可用"}],"shopping_fee":39,"shopping_fee_description":"在线支付满39元即可包邮"},"carts_count":3}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * carts_list : [{"rec_id":2901876,"goods_id":5445,"is_special":0,"is_free_shipping":0,"special_type":0,"special_id":0,"goods_number":1,"goods_name":"omysky 梦青春USB直插式跳蛋","app_price":99,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201610%2Fsource_img%2F5445_P_1476955549507.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=890a007235442e583369c6dfbfaf52bfffdb3db9","goods_spec_name":"选择颜色:粉色","goods_attr_price":0,"expiry_at":0,"extension_code":"","is_expiry":1,"expire_msg":""},{"rec_id":2901871,"goods_id":5445,"is_special":0,"is_free_shipping":0,"special_type":0,"special_id":0,"goods_number":1,"goods_name":"omysky 梦青春USB直插式跳蛋","app_price":99,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201610%2Fsource_img%2F5445_P_1476955549507.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=890a007235442e583369c6dfbfaf52bfffdb3db9","goods_spec_name":"选择颜色:玫红色","goods_attr_price":0,"expiry_at":0,"extension_code":"","is_expiry":1,"expire_msg":""},{"rec_id":2901866,"goods_id":10086,"is_special":1,"is_free_shipping":0,"special_type":1,"special_id":14151,"goods_number":1,"goods_name":"取悦 震动刺激2代持久型锻炼器","app_price":49,"goods_img":"http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201609%2Fsource_img%2F10086_P_1474876684739.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=11a2f0fcd1b85d586f6554326d5e63246601e6ab","goods_spec_name":"","goods_attr_price":0,"expiry_at":1491398270,"extension_code":"","is_expiry":1,"expire_msg":"活动将于2017-04-05 09:20:44过期"}]
         * bonus_info : {"can_receive":[],"already_receive":[{"type_id":126,"type_name":"APP新人专享券80元","type_money":80,"use_start_date":1487904713,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":400,"bonus_description":"全场通用, 满400元可用"},{"type_id":121,"type_name":"APP新人专享券50元","type_money":50,"use_start_date":1487904664,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":300,"bonus_description":"全场通用, 满300元可用"},{"type_id":116,"type_name":"APP新人专享券30元","type_money":30,"use_start_date":1487904595,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":200,"bonus_description":"全场通用, 满200元可用"}],"shopping_fee":39,"shopping_fee_description":"在线支付满39元即可包邮"}
         * carts_count : 3
         */

        private BonusInfoBean bonus_info;
        private int carts_count;
        private List<CartsListBean> carts_list;

        public BonusInfoBean getBonus_info() {
            return bonus_info;
        }

        public void setBonus_info(BonusInfoBean bonus_info) {
            this.bonus_info = bonus_info;
        }

        public int getCarts_count() {
            return carts_count;
        }

        public void setCarts_count(int carts_count) {
            this.carts_count = carts_count;
        }

        public List<CartsListBean> getCarts_list() {
            return carts_list;
        }

        public void setCarts_list(List<CartsListBean> carts_list) {
            this.carts_list = carts_list;
        }

        public static class BonusInfoBean {
            /**
             * can_receive : []
             * already_receive : [{"type_id":126,"type_name":"APP新人专享券80元","type_money":80,"use_start_date":1487904713,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":400,"bonus_description":"全场通用, 满400元可用"},{"type_id":121,"type_name":"APP新人专享券50元","type_money":50,"use_start_date":1487904664,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":300,"bonus_description":"全场通用, 满300元可用"},{"type_id":116,"type_name":"APP新人专享券30元","type_money":30,"use_start_date":1487904595,"use_end_date":1491667199,"due_days":"自领取后7日有效","min_goods_amount":200,"bonus_description":"全场通用, 满200元可用"}]
             * shopping_fee : 39
             * shopping_fee_description : 在线支付满39元即可包邮
             */

            private int shopping_fee;
            private String shopping_fee_description;
            private List<?> can_receive;
            private List<AlreadyReceiveBean> already_receive;

            public int getShopping_fee() {
                return shopping_fee;
            }

            public void setShopping_fee(int shopping_fee) {
                this.shopping_fee = shopping_fee;
            }

            public String getShopping_fee_description() {
                return shopping_fee_description;
            }

            public void setShopping_fee_description(String shopping_fee_description) {
                this.shopping_fee_description = shopping_fee_description;
            }

            public List<?> getCan_receive() {
                return can_receive;
            }

            public void setCan_receive(List<?> can_receive) {
                this.can_receive = can_receive;
            }

            public List<AlreadyReceiveBean> getAlready_receive() {
                return already_receive;
            }

            public void setAlready_receive(List<AlreadyReceiveBean> already_receive) {
                this.already_receive = already_receive;
            }

            public static class AlreadyReceiveBean {
                /**
                 * type_id : 126
                 * type_name : APP新人专享券80元
                 * type_money : 80
                 * use_start_date : 1487904713
                 * use_end_date : 1491667199
                 * due_days : 自领取后7日有效
                 * min_goods_amount : 400
                 * bonus_description : 全场通用, 满400元可用
                 */

                private int type_id;
                private String type_name;
                private int type_money;
                private int use_start_date;
                private int use_end_date;
                private String due_days;
                private int min_goods_amount;
                private String bonus_description;

                public int getType_id() {
                    return type_id;
                }

                public void setType_id(int type_id) {
                    this.type_id = type_id;
                }

                public String getType_name() {
                    return type_name;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }

                public int getType_money() {
                    return type_money;
                }

                public void setType_money(int type_money) {
                    this.type_money = type_money;
                }

                public int getUse_start_date() {
                    return use_start_date;
                }

                public void setUse_start_date(int use_start_date) {
                    this.use_start_date = use_start_date;
                }

                public int getUse_end_date() {
                    return use_end_date;
                }

                public void setUse_end_date(int use_end_date) {
                    this.use_end_date = use_end_date;
                }

                public String getDue_days() {
                    return due_days;
                }

                public void setDue_days(String due_days) {
                    this.due_days = due_days;
                }

                public int getMin_goods_amount() {
                    return min_goods_amount;
                }

                public void setMin_goods_amount(int min_goods_amount) {
                    this.min_goods_amount = min_goods_amount;
                }

                public String getBonus_description() {
                    return bonus_description;
                }

                public void setBonus_description(String bonus_description) {
                    this.bonus_description = bonus_description;
                }
            }
        }

        public static class CartsListBean {
            /**
             * rec_id : 2901876
             * goods_id : 5445
             * is_special : 0
             * is_free_shipping : 0
             * special_type : 0
             * special_id : 0
             * goods_number : 1
             * goods_name : omysky 梦青春USB直插式跳蛋
             * app_price : 99
             * goods_img : http://t.dddua.com/?url=http%3A%2F%2Fs-api.dddua.com%2Fimages%2F201610%2Fsource_img%2F5445_P_1476955549507.jpg&mode=clip&w=240&h=240&prog=1&client=qu&fmt=webp&sig=890a007235442e583369c6dfbfaf52bfffdb3db9
             * goods_spec_name : 选择颜色:粉色
             * goods_attr_price : 0
             * expiry_at : 0
             * extension_code :
             * is_expiry : 1
             * expire_msg :
             */

            private int rec_id;
            private int goods_id;
            private int is_special;
            private int is_free_shipping;
            private int special_type;
            private int special_id;
            private int goods_number;
            private String goods_name;
            private int app_price;
            private String goods_img;
            private String goods_spec_name;
            private int goods_attr_price;
            private int expiry_at;
            private String extension_code;
            private int is_expiry;
            private String expire_msg;
            private boolean checked;

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public int getRec_id() {
                return rec_id;
            }

            public void setRec_id(int rec_id) {
                this.rec_id = rec_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getIs_special() {
                return is_special;
            }

            public void setIs_special(int is_special) {
                this.is_special = is_special;
            }

            public int getIs_free_shipping() {
                return is_free_shipping;
            }

            public void setIs_free_shipping(int is_free_shipping) {
                this.is_free_shipping = is_free_shipping;
            }

            public int getSpecial_type() {
                return special_type;
            }

            public void setSpecial_type(int special_type) {
                this.special_type = special_type;
            }

            public int getSpecial_id() {
                return special_id;
            }

            public void setSpecial_id(int special_id) {
                this.special_id = special_id;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getApp_price() {
                return app_price;
            }

            public void setApp_price(int app_price) {
                this.app_price = app_price;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public String getGoods_spec_name() {
                return goods_spec_name;
            }

            public void setGoods_spec_name(String goods_spec_name) {
                this.goods_spec_name = goods_spec_name;
            }

            public int getGoods_attr_price() {
                return goods_attr_price;
            }

            public void setGoods_attr_price(int goods_attr_price) {
                this.goods_attr_price = goods_attr_price;
            }

            public int getExpiry_at() {
                return expiry_at;
            }

            public void setExpiry_at(int expiry_at) {
                this.expiry_at = expiry_at;
            }

            public String getExtension_code() {
                return extension_code;
            }

            public void setExtension_code(String extension_code) {
                this.extension_code = extension_code;
            }

            public int getIs_expiry() {
                return is_expiry;
            }

            public void setIs_expiry(int is_expiry) {
                this.is_expiry = is_expiry;
            }

            public String getExpire_msg() {
                return expire_msg;
            }

            public void setExpire_msg(String expire_msg) {
                this.expire_msg = expire_msg;
            }
        }
    }
}
