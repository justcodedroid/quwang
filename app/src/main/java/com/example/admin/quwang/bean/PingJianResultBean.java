package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class PingJianResultBean {
    private int code;
    private String message;
    private PingJiaDataBean data;

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

    public PingJiaDataBean getData() {
        return data;
    }

    public void setData(PingJiaDataBean data) {
        this.data = data;
    }

    public static class PingJiaDataBean {
        private int comment_count;
        private int page_total;
        private List<PingJiaBean> comment_list;

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getPage_total() {
            return page_total;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }

        public List<PingJiaBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<PingJiaBean> comment_list) {
            this.comment_list = comment_list;
        }
    }
}
