package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.FaXianBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/4/3.
 */

public interface FaXianSerevice {
    @GET("category")
    Call<FaXianBean> getFaXianBean();
}
