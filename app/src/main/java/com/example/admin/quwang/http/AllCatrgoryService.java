package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.CategoryList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/4/2.
 */

public interface AllCatrgoryService {
    @GET("category/tradition")
    Call<BaseBean<CategoryList>> getAllCategortBeans();
}
