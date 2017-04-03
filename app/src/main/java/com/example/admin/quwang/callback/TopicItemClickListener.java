package com.example.admin.quwang.callback;

import android.content.Context;

import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.utils.ActivityRouter;

/**
 * Created by admin on 2017/4/3.
 */

public class TopicItemClickListener {
    Context context;

    public TopicItemClickListener(Context context) {
        this.context = context;
    }
    public void to(FaXianBean.DataBean.HotTopicBean bean){
        ActivityRouter.router(context,bean.getType(),bean.getLink_url(),0,0);
    }
}
