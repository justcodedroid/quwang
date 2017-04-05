package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.BaseBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/4/5.
 */

public interface UpdateGouWuCheService {
    @POST("carts/{recid}")
    @FormUrlEncoded
    Call<BaseBean<Object>> update(@Path("recid") int recid, @Field("action") String action);
}
