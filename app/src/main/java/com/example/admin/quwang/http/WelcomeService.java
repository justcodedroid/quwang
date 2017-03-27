package com.example.admin.quwang.http;

import com.example.admin.quwang.bean.WelcomeBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/3/25.
 */

public interface WelcomeService {
@POST(HttpModel.WELCOMEPATH)
Call<WelcomeBean> getWelcome();
}
