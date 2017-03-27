package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.WebResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/27.
 */

public interface WebService {
    @GET(HttpModel.WEB+"{id}")
    Call<WebResultBean> getWebResultBean(@Path("id") String topicId);
}
