package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.AddCaetBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/4/4.
 */

public interface AddGouWuCheService {

    @POST("carts")
    @FormUrlEncoded
    Call<AddCaetBean> add(@Field("goods_id") int goods_id,@Field("spec") int specid,@Field("goods_number") int goods_number,@Field("action") String action,@Field("special_type") int special_type,@Field("special_id") int special_id,@Field("zt_id") int zt_id,@Field("referer_type") int referer_type);
}
