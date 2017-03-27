package com.example.admin.quwang.utils;

import android.util.Log;

import com.example.admin.quwang.bean.ShouYeBean;
import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.http.HeadsInterceptor;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.http.ShouYeService;
import com.example.admin.quwang.http.WelcomeService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/3/25.
 */

public class HttpUtils {
    private static Retrofit retrofit;

    static {
        OkHttpClient client=new OkHttpClient.Builder().addNetworkInterceptor(new HeadsInterceptor()).build();
        retrofit = new Retrofit.Builder().baseUrl(HttpModel.LOCAL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static void loadWelComdeBean(final OnLoadFinishListenr<WelcomeBean> listenr) {
        retrofit.create(WelcomeService.class).getWelcome().enqueue(new Callback<WelcomeBean>() {
            @Override
            public void onResponse(Call<WelcomeBean> call, Response<WelcomeBean> response) {
                boolean successful = response.isSuccessful();
                if (successful) {
                    listenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        listenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WelcomeBean> call, Throwable t) {
                listenr.onError(t.getMessage(), HttpModel.APIERROR);
            }
        });
    }

    public static void LoadShouYeBean(final OnLoadFinishListenr<ShouYeBean> listenr){
        retrofit.create(ShouYeService.class).getShouYe().enqueue(new Callback<ShouYeBean>() {
            @Override
            public void onResponse(Call<ShouYeBean> call, Response<ShouYeBean> response) {
                if(response.isSuccessful()){
                    listenr.onSuccess(response.body(),HttpModel.NORMAL);
                }else {
                    try {
                        listenr.onError(response.errorBody().string(),response.code());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ShouYeBean> call, Throwable t) {
            listenr.onError(t.getMessage(),HttpModel.APIERROR);
            Log.e("sdas",t.getMessage());
            }
        });
    }
}