package com.example.admin.quwang.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.ItemTuPianYuLanBinding;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by admin on 2017/3/20.
 */
public class TuPianYuLanFragment extends BaseFragment<ItemTuPianYuLanBinding> {

    private PhotoViewAttacher photoViewAttacher;
    private String src;

    @Override
    protected int getLayoutId() {
        return R.layout.item_tu_pian_yu_lan;
    }

    @Override
    protected void initImpl() {
        src = getArguments().getString("src");
        photoViewAttacher = new PhotoViewAttacher(bind.pv);
        photoViewAttacher.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        bind.pb.setVisibility(View.VISIBLE);
        Glide.with(this).load(src).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                bind.pv.setImageDrawable(resource);
                bind.pb.setVisibility(View.GONE);
                photoViewAttacher.update();
            }
        });
        boolean contains = src.contains("gif");
        if(contains){
            photoViewAttacher.setZoomable(false);
        }
    }

    public TuPianYuLanFragment newInstance(String src) {
        Bundle bundle = new Bundle();
        bundle.putString("src", src);
        setArguments(bundle);
        return this;
    }

}
