package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/25.
 */

public class WelcomeBean {

    /**
     * code : 200
     * message :
     * data : {"ads_status":1,"start_ads_list":{"time":5,"link_url":"10201","main_title":"趣网替代包APP启动广告","subtitle":"趣网替代包APP启动广告","img_url":"http://img.api.m.qu.cn/images/api/20170223/d7ac78c5e2907a1a589cc61e836c2bbd.jpeg","type":"1","type_name":"商品"}}
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
         * ads_status : 1
         * start_ads_list : {"time":5,"link_url":"10201","main_title":"趣网替代包APP启动广告","subtitle":"趣网替代包APP启动广告","img_url":"http://img.api.m.qu.cn/images/api/20170223/d7ac78c5e2907a1a589cc61e836c2bbd.jpeg","type":"1","type_name":"商品"}
         */

        private int ads_status;
        private StartAdsListBean start_ads_list;

        public int getAds_status() {
            return ads_status;
        }

        public void setAds_status(int ads_status) {
            this.ads_status = ads_status;
        }

        public StartAdsListBean getStart_ads_list() {
            return start_ads_list;
        }

        public void setStart_ads_list(StartAdsListBean start_ads_list) {
            this.start_ads_list = start_ads_list;
        }

        public static class StartAdsListBean {
            /**
             * time : 5
             * link_url : 10201
             * main_title : 趣网替代包APP启动广告
             * subtitle : 趣网替代包APP启动广告
             * img_url : http://img.api.m.qu.cn/images/api/20170223/d7ac78c5e2907a1a589cc61e836c2bbd.jpeg
             * type : 1
             * type_name : 商品
             */

            private int time;
            private String link_url;
            private String main_title;
            private String subtitle;
            private String img_url;
            private String type;
            private String type_name;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }
    }
}
