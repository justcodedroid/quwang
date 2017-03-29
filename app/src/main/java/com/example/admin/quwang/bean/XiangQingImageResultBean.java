package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingImageResultBean {
    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean{
        private String vedio_url;
        private List<ImageBean> url_list;

        public String getVedio_url() {
            return vedio_url;
        }

        public void setVedio_url(String vedio_url) {
            this.vedio_url = vedio_url;
        }

        public List<ImageBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<ImageBean> url_list) {
            this.url_list = url_list;
        }
    }
    public static class ImageBean{
        private int img_height;
        private int img_with;
        private String  img_url;

        public int getImg_height() {
            return img_height;
        }

        public void setImg_height(int img_height) {
            this.img_height = img_height;
        }

        public int getImg_with() {
            return img_with;
        }

        public void setImg_with(int img_width) {
            this.img_with = img_width;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }
    }
 }
