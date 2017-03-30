package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by admin on 2017/3/30.
 */

public interface ShangPinService {
    @GET("/goods/{goods_id}?zt_id=&referer_type=0&goods_attr=")
    Call<BaseBean<ShangPinXiangQingBean>> loadShangPinXiangQingBean(@Path("goods_id") int goods_id, @Query("special_id") int special_id, @Query("special_type") int special_type);
}
