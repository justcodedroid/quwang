package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.XiangQingImageResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/29.
 */

public interface XiangQingImageBeanService {
    @GET("goods/{goods_id}/images")
    Call<XiangQingImageResultBean> loadXiangQingImageResultBeans(@Path("goods_id") int goods_id);
}
