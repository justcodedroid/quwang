package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/4/4.
 */

public class GoodsAttrBean {

    /**
     * code : 200
     * message :
     * data : {"parameter":[{"attr_name":"控制方式","attr_value":"震动"},{"attr_name":"品牌","attr_value":"琦莎"},{"attr_name":"颜色","attr_value":"白色"},{"attr_name":"重量","attr_value":"500g"},{"attr_name":"适用人群","attr_value":"男性"},{"attr_name":"特色","attr_value":"防水免提、口阴互换舌震、180度多广角、吸附强、"},{"attr_name":"电池","attr_value":"跳蛋使用LR44纽扣电池"},{"attr_name":"包装清单","attr_value":"飞机杯*1说明书*1跳蛋*1润滑油*1"},{"attr_name":"产地","attr_value":"浙江"},{"attr_name":"尺寸","attr_value":"全长175mm，有效长度150mm，倒模直径6cm"},{"attr_name":"材质","attr_value":"虚拟肤质"},{"attr_name":"功能","attr_value":"带震动"},{"attr_name":"类型","attr_value":"===自慰杯飞机杯==="}],"standard":{"standard_name":"款型","standard_list":[{"attr_value":"飞机杯","goods_id":"5503","goods_attr_id":"93146","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112620_39781.jpg","attr_price":199},{"attr_value":"加10元送润滑液","goods_id":"5503","goods_attr_id":"93171","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112546_61755.jpg","attr_price":209},{"attr_value":"加30元送锁精环","goods_id":"5503","goods_attr_id":"100196","attr_pic":"http://s-api.dddua.com/images/attrpic/20160601/20160601135506_53220.jpg","attr_price":229},{"attr_value":"加40元送润滑液、锁精环","goods_id":"5503","goods_attr_id":"118291","attr_pic":"http://s-api.dddua.com/","attr_price":239}]}}
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
         * parameter : [{"attr_name":"控制方式","attr_value":"震动"},{"attr_name":"品牌","attr_value":"琦莎"},{"attr_name":"颜色","attr_value":"白色"},{"attr_name":"重量","attr_value":"500g"},{"attr_name":"适用人群","attr_value":"男性"},{"attr_name":"特色","attr_value":"防水免提、口阴互换舌震、180度多广角、吸附强、"},{"attr_name":"电池","attr_value":"跳蛋使用LR44纽扣电池"},{"attr_name":"包装清单","attr_value":"飞机杯*1说明书*1跳蛋*1润滑油*1"},{"attr_name":"产地","attr_value":"浙江"},{"attr_name":"尺寸","attr_value":"全长175mm，有效长度150mm，倒模直径6cm"},{"attr_name":"材质","attr_value":"虚拟肤质"},{"attr_name":"功能","attr_value":"带震动"},{"attr_name":"类型","attr_value":"===自慰杯飞机杯==="}]
         * standard : {"standard_name":"款型","standard_list":[{"attr_value":"飞机杯","goods_id":"5503","goods_attr_id":"93146","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112620_39781.jpg","attr_price":199},{"attr_value":"加10元送润滑液","goods_id":"5503","goods_attr_id":"93171","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112546_61755.jpg","attr_price":209},{"attr_value":"加30元送锁精环","goods_id":"5503","goods_attr_id":"100196","attr_pic":"http://s-api.dddua.com/images/attrpic/20160601/20160601135506_53220.jpg","attr_price":229},{"attr_value":"加40元送润滑液、锁精环","goods_id":"5503","goods_attr_id":"118291","attr_pic":"http://s-api.dddua.com/","attr_price":239}]}
         */

        private StandardBean standard;
        private List<ParameterBean> parameter;

        public StandardBean getStandard() {
            return standard;
        }

        public void setStandard(StandardBean standard) {
            this.standard = standard;
        }

        public List<ParameterBean> getParameter() {
            return parameter;
        }

        public void setParameter(List<ParameterBean> parameter) {
            this.parameter = parameter;
        }

        public static class StandardBean {
            /**
             * standard_name : 款型
             * standard_list : [{"attr_value":"飞机杯","goods_id":"5503","goods_attr_id":"93146","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112620_39781.jpg","attr_price":199},{"attr_value":"加10元送润滑液","goods_id":"5503","goods_attr_id":"93171","attr_pic":"http://s-api.dddua.com/images/attrpic/20160513/20160513112546_61755.jpg","attr_price":209},{"attr_value":"加30元送锁精环","goods_id":"5503","goods_attr_id":"100196","attr_pic":"http://s-api.dddua.com/images/attrpic/20160601/20160601135506_53220.jpg","attr_price":229},{"attr_value":"加40元送润滑液、锁精环","goods_id":"5503","goods_attr_id":"118291","attr_pic":"http://s-api.dddua.com/","attr_price":239}]
             */

            private String standard_name;
            private List<StandardListBean> standard_list;

            public String getStandard_name() {
                return standard_name;
            }

            public void setStandard_name(String standard_name) {
                this.standard_name = standard_name;
            }

            public List<StandardListBean> getStandard_list() {
                return standard_list;
            }

            public void setStandard_list(List<StandardListBean> standard_list) {
                this.standard_list = standard_list;
            }

            public static class StandardListBean {
                /**
                 * attr_value : 飞机杯
                 * goods_id : 5503
                 * goods_attr_id : 93146
                 * attr_pic : http://s-api.dddua.com/images/attrpic/20160513/20160513112620_39781.jpg
                 * attr_price : 199
                 */

                private String attr_value;
                private String goods_id;
                private String goods_attr_id;
                private String attr_pic;
                private int attr_price;

                public String getAttr_value() {
                    return attr_value;
                }

                @Override
                public String toString() {
                    return attr_value+"("+attr_price+")";
                }

                public void setAttr_value(String attr_value) {
                    this.attr_value = attr_value;
                }

                public String getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(String goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_attr_id() {
                    return goods_attr_id;
                }

                public void setGoods_attr_id(String goods_attr_id) {
                    this.goods_attr_id = goods_attr_id;
                }

                public String getAttr_pic() {
                    return attr_pic;
                }

                public void setAttr_pic(String attr_pic) {
                    this.attr_pic = attr_pic;
                }

                public int getAttr_price() {
                    return attr_price;
                }

                public void setAttr_price(int attr_price) {
                    this.attr_price = attr_price;
                }
            }
        }

        public static class ParameterBean {
            /**
             * attr_name : 控制方式
             * attr_value : 震动
             */

            private String attr_name;
            private String attr_value;

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }

            public String getAttr_value() {
                return attr_value;
            }

            public void setAttr_value(String attr_value) {
                this.attr_value = attr_value;
            }
        }
    }
}
