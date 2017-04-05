package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.GouWuCheBean;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/4/5.
 */

public interface GouWuCheService {
    @GET("carts")
    Call<GouWuCheBean> getGouWuChe();

    @DELETE("carts/{recid}")
    Call<BaseBean<Object>> delete(@Path("recid") int recid);

}
