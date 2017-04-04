package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.GoodsAttrBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/4/4.
 */

public interface GoodsAttrService {
    @GET("goods/{goods_id}/attr")
    Call<GoodsAttrBean> getGoodsAttr(@Path("goods_id") int goods_id);

}
