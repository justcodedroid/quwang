package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/4/3.
 */

public class ShouCangBean {

    /**
     * code : 200
     * message : 收藏成功
     * data : {"collection_id":"302681"}
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
         * collection_id : 302681
         */

        private String collection_id;

        public String getCollection_id() {
            return collection_id;
        }

        public void setCollection_id(String collection_id) {
            this.collection_id = collection_id;
        }
    }
}
