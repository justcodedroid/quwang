package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/4/4.
 */

public class AddCaetBean {

    /**
     * code : 200
     * message : 添加购物车成功
     * data : {"rec_id":"2895661"}
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
         * rec_id : 2895661
         */

        private String rec_id;

        public String getRec_id() {
            return rec_id;
        }

        public void setRec_id(String rec_id) {
            this.rec_id = rec_id;
        }
    }
}
