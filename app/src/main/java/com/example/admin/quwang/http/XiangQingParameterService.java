package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.XiangQingResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/29.
 */

public interface XiangQingParameterService {
@GET("goods/{goods_id}/attr")
    Call<XiangQingResultBean> loadXiangQingParameterBeans(@Path("goods_id") int goods_id);
}
