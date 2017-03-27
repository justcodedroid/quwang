package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.ShouYeBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/3/26.
 */

public interface ShouYeService {
    @GET(HttpModel.SHOUYE)
    Call<ShouYeBean> getShouYe();
}
