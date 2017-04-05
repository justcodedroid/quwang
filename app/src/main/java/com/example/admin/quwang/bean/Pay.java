package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/4/5.
 */

public class Pay {

    /**
     * code : 200
     * message :
     * data : {"pay_id":"4","alipay_string":"_input_charset=utf-8&body=趣网商城APP商品&it_b_pay=30m&notify_url=http://api.m.qu.cn/orders/alipaycallback&out_trade_no=4825081&partner=2088421731205933&payment_type=1&seller_id=quwang@hongju.cc &service=mobile.securitypay.pay&show_url=m.alipay.com&subject=趣网商城APP商品&total_fee=777.00&sign=UnzjgMzpz5iIgc6xcXj0x%2B1WJVT0OJYR3uys2FrKwiP%2BokAhmUAG4NdKmnr6bsevSIdPVZU7bs8voUTQ2ahxHNAAEtk60cG0HSkE1G3%2Bdz0yPk2Oh2n7ATY3DcqFPWz4sNeVbiAI2bDWixejCYxW1BH7t1Lx68dLVQcX3j5UJRQ%3D&sign_type=RSA","wxpay_string":{},"union_string":""}
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
         * pay_id : 4
         * alipay_string : _input_charset=utf-8&body=趣网商城APP商品&it_b_pay=30m&notify_url=http://api.m.qu.cn/orders/alipaycallback&out_trade_no=4825081&partner=2088421731205933&payment_type=1&seller_id=quwang@hongju.cc &service=mobile.securitypay.pay&show_url=m.alipay.com&subject=趣网商城APP商品&total_fee=777.00&sign=UnzjgMzpz5iIgc6xcXj0x%2B1WJVT0OJYR3uys2FrKwiP%2BokAhmUAG4NdKmnr6bsevSIdPVZU7bs8voUTQ2ahxHNAAEtk60cG0HSkE1G3%2Bdz0yPk2Oh2n7ATY3DcqFPWz4sNeVbiAI2bDWixejCYxW1BH7t1Lx68dLVQcX3j5UJRQ%3D&sign_type=RSA
         * wxpay_string : {}
         * union_string :
         */

        private String pay_id;
        private String alipay_string;
        private WxpayStringBean wxpay_string;
        private String union_string;

        public String getPay_id() {
            return pay_id;
        }

        public void setPay_id(String pay_id) {
            this.pay_id = pay_id;
        }

        public String getAlipay_string() {
            return alipay_string;
        }

        public void setAlipay_string(String alipay_string) {
            this.alipay_string = alipay_string;
        }

        public WxpayStringBean getWxpay_string() {
            return wxpay_string;
        }

        public void setWxpay_string(WxpayStringBean wxpay_string) {
            this.wxpay_string = wxpay_string;
        }

        public String getUnion_string() {
            return union_string;
        }

        public void setUnion_string(String union_string) {
            this.union_string = union_string;
        }

        public static class WxpayStringBean {
        }
    }
}
