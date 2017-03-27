package com.example.admin.quwang.http;


import com.example.admin.quwang.bean.DetailsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/17.
 */

public interface DetailsService {
    @GET("community/daily/{id}")
    Call<DetailsBean> getDetails(@Path("id") String id);

}
