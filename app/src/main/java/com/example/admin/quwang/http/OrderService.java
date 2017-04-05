package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.PayBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/4/5.
 */

public interface OrderService {

    @POST("orders/create")
    @FormUrlEncoded
    Call<PayBean> get(@Field("rec_ids") String ids,@Field("address_id") int addid,@Field("pay_code") String paycode);
}
