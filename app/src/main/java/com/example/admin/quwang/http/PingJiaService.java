package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.PingJianResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by admin on 2017/3/29.
 */

public interface PingJiaService {
    @GET("goods/{goods_id}/comment")
    Call<PingJianResultBean> getPingJiaResultBean(@Path("goods_id") int goods_id, @Query("page") int page);
}
