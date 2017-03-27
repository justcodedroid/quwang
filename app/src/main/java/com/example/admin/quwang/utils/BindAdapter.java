package com.example.admin.quwang.utils;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ImageVideoWrapper;

import java.io.OutputStream;

import it.xabaras.android.logger.Logger;

/**
 * Created by admin on 2017/3/25.
 */

public class BindAdapter {
    @BindingAdapter("android:src")
    public static void loadImage(ImageView imageView,String url){
        // 过度压缩导致图片变绿 ，需要配合设置ARGB+缓存source
  Glide .with(imageView.getContext()).load(url).centerCrop().crossFade().into(imageView);

    }
}
