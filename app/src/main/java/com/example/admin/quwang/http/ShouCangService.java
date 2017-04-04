package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.ShouCangBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/4/3.
 */

public interface ShouCangService {
    @POST("users/collection")
    @FormUrlEncoded
    Call<ShouCangBean> shouCang(@Field("goods_id") int goods_id);
}
