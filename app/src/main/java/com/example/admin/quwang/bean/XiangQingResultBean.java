package com.example.admin.quwang.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingResultBean {

    /**
     * code : 200
     * message :
     * data : {"parameter":[{"attr_name":"品牌","attr_value":"取悦"},{"attr_name":"产地","attr_value":"东莞"},{"attr_name":"尺寸","attr_value":"全长：140mm(不含底盘)，有效长度115mm，直径35mm"},{"attr_name":"材料","attr_value":"TPR"},{"attr_name":"功能","attr_value":"不带震动"},{"attr_name":"控制方式","attr_value":"非遥控"},{"attr_name":"适用人群","attr_value":"成年女性"},{"attr_name":"特色","attr_value":"1:1尺寸"},{"attr_name":"包装清单","attr_value":"阳具*1，润滑液*1袋"}],"standard":{"standard_name":"款型","standard_list":[{"attr_value":"欲火神炮","goods_id":"10081","goods_attr_id":"111546","attr_pic":"http://s-api.dddua.com/","attr_price":58},{"attr_value":"精悍干探","goods_id":"10081","goods_attr_id":"111536","attr_pic":"http://s-api.dddua.com/","attr_price":78},{"attr_value":"欲望神枪","goods_id":"10081","goods_attr_id":"111541","attr_pic":"http://s-api.dddua.com/","attr_price":98}]}}
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
         * parameter : [{"attr_name":"品牌","attr_value":"取悦"},{"attr_name":"产地","attr_value":"东莞"},{"attr_name":"尺寸","attr_value":"全长：140mm(不含底盘)，有效长度115mm，直径35mm"},{"attr_name":"材料","attr_value":"TPR"},{"attr_name":"功能","attr_value":"不带震动"},{"attr_name":"控制方式","attr_value":"非遥控"},{"attr_name":"适用人群","attr_value":"成年女性"},{"attr_name":"特色","attr_value":"1:1尺寸"},{"attr_name":"包装清单","attr_value":"阳具*1，润滑液*1袋"}]
         * standard : {"standard_name":"款型","standard_list":[{"attr_value":"欲火神炮","goods_id":"10081","goods_attr_id":"111546","attr_pic":"http://s-api.dddua.com/","attr_price":58},{"attr_value":"精悍干探","goods_id":"10081","goods_attr_id":"111536","attr_pic":"http://s-api.dddua.com/","attr_price":78},{"attr_value":"欲望神枪","goods_id":"10081","goods_attr_id":"111541","attr_pic":"http://s-api.dddua.com/","attr_price":98}]}
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
             * standard_list : [{"attr_value":"欲火神炮","goods_id":"10081","goods_attr_id":"111546","attr_pic":"http://s-api.dddua.com/","attr_price":58},{"attr_value":"精悍干探","goods_id":"10081","goods_attr_id":"111536","attr_pic":"http://s-api.dddua.com/","attr_price":78},{"attr_value":"欲望神枪","goods_id":"10081","goods_attr_id":"111541","attr_pic":"http://s-api.dddua.com/","attr_price":98}]
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
                 * attr_value : 欲火神炮
                 * goods_id : 10081
                 * goods_attr_id : 111546
                 * attr_pic : http://s-api.dddua.com/
                 * attr_price : 58
                 */

                private String attr_value;
                private String goods_id;
                private String goods_attr_id;
                private String attr_pic;
                private int attr_price;

                public String getAttr_value() {
                    return attr_value;
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
             * attr_name : 品牌
             * attr_value : 取悦
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
