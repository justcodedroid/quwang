package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.Pay;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/4/5.
 */

public interface PayService {
    @GET("orders/{sign}/paystring?pay_id=4")
    Call<Pay> getPay(@Path("sign") long sign);
}
