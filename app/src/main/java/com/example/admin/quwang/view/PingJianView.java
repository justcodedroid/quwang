package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.PingJiaBean;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public interface PingJianView  extends BaseView{
    void relashPingJiaList(List<PingJiaBean> pingJiaBeanList,int type);
}
