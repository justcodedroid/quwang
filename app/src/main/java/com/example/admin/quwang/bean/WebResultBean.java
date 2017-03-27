package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/27.
 */

public class WebResultBean {

    /**
     * code : 200
     * message :
     * data : {"link_url":"http://api.m.qu.cn/common/lugame/?part=1&app_type=2&version=3.2.0&new_event_trigger=1"}
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
         * link_url : http://api.m.qu.cn/common/lugame/?part=1&app_type=2&version=3.2.0&new_event_trigger=1
         */

        private String link_url;

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }
    }
}
