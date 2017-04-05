package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/4/5.
 */

public class PayBean {

    /**
     * code : 200
     * message : 订单提交成功
     * data : {"order_id":4824931,"order_sn":2017040514033099126,"order_amount":2711.6,"default_order_payment":[{"pay_code":"alipay","pay_name":"支付宝","pay_id":4}],"other_order_payment":[{"pay_code":"wxpay","pay_name":"微信","pay_id":12},{"pay_code":"gateway","pay_name":"银行卡/信用卡","pay_id":11}]}
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
         * order_id : 4824931
         * order_sn : 2017040514033099126
         * order_amount : 2711.6
         * default_order_payment : [{"pay_code":"alipay","pay_name":"支付宝","pay_id":4}]
         * other_order_payment : [{"pay_code":"wxpay","pay_name":"微信","pay_id":12},{"pay_code":"gateway","pay_name":"银行卡/信用卡","pay_id":11}]
         */

        private int order_id;
        private long order_sn;
        private double order_amount;
        private List<DefaultOrderPaymentBean> default_order_payment;
        private List<OtherOrderPaymentBean> other_order_payment;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public long getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(long order_sn) {
            this.order_sn = order_sn;
        }

        public double getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(double order_amount) {
            this.order_amount = order_amount;
        }

        public List<DefaultOrderPaymentBean> getDefault_order_payment() {
            return default_order_payment;
        }

        public void setDefault_order_payment(List<DefaultOrderPaymentBean> default_order_payment) {
            this.default_order_payment = default_order_payment;
        }

        public List<OtherOrderPaymentBean> getOther_order_payment() {
            return other_order_payment;
        }

        public void setOther_order_payment(List<OtherOrderPaymentBean> other_order_payment) {
            this.other_order_payment = other_order_payment;
        }

        public static class DefaultOrderPaymentBean {
            /**
             * pay_code : alipay
             * pay_name : 支付宝
             * pay_id : 4
             */

            private String pay_code;
            private String pay_name;
            private int pay_id;

            public String getPay_code() {
                return pay_code;
            }

            public void setPay_code(String pay_code) {
                this.pay_code = pay_code;
            }

            public String getPay_name() {
                return pay_name;
            }

            public void setPay_name(String pay_name) {
                this.pay_name = pay_name;
            }

            public int getPay_id() {
                return pay_id;
            }

            public void setPay_id(int pay_id) {
                this.pay_id = pay_id;
            }
        }

        public static class OtherOrderPaymentBean {
            /**
             * pay_code : wxpay
             * pay_name : 微信
             * pay_id : 12
             */

            private String pay_code;
            private String pay_name;
            private int pay_id;

            public String getPay_code() {
                return pay_code;
            }

            public void setPay_code(String pay_code) {
                this.pay_code = pay_code;
            }

            public String getPay_name() {
                return pay_name;
            }

            public void setPay_name(String pay_name) {
                this.pay_name = pay_name;
            }

            public int getPay_id() {
                return pay_id;
            }

            public void setPay_id(int pay_id) {
                this.pay_id = pay_id;
            }
        }
    }
}
