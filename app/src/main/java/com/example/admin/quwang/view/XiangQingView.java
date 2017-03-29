package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.bean.XiangQingResultBean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public interface XiangQingView extends BaseView {
    void relashParameterBeans(List<XiangQingResultBean.DataBean.ParameterBean> list);

    void relashImageBeans(XiangQingImageResultBean.DataBean dataBeen);
}
