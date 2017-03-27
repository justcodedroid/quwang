package com.example.admin.quwang.http;

import android.util.Log;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/3/25.
 */

public class HeadsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder().addHeader("Authorization", " 8a817deda9d29b4cb23ab3a898f6e0ac")
                .addHeader("sign", " e36db3569ac77938ea700ed315817ec0").
                        addHeader("App-Agent"," version=3.2.0,platform=android,app_store_name=zapp-wandoujia,software_version=6.0,models=Custom Phone - 6.0.0 - API 23 - 768x1280,package_name=com.weishang.qwapp,time=1489484134207")
                .addHeader("User-Agent","okhttp/3.4.1").build();
        return chain.proceed(request);
    }
}
