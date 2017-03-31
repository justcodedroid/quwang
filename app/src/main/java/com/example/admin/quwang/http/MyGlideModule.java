package com.example.admin.quwang.http;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by admin on 2017/3/29.
 */

public class MyGlideModule implements GlideModule {
    @Override
    public void registerComponents(Context context, Glide glide) {

//         super.registerComponents(context, glide);

        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES).retryOnConnectionFailure(true).build();
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(client));
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        builder.setMemoryCache(new LruResourceCache((int) (Runtime.getRuntime().freeMemory() / 10)));


    }

}
