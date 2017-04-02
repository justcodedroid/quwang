package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.PinLeiBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by admin on 2017/4/1.
 */

public interface PeiLeiService {
    @GET("/category/{type}")
    Call<BaseBean<PinLeiBean>> getPinLeiBea(@Path("type") String type, @Query("sort") String sort, @Query("ad_id") int ad_id, @Query("page") int page, @QueryMap Map<String,String> map);
}
