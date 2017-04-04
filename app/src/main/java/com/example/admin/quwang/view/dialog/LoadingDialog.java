package com.example.admin.quwang.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.admin.quwang.R;

/**
 * Created by admin on 2017/4/4.
 */

public class LoadingDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener {
    ImageView loadIv;
    private final AnimationDrawable background;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        loadIv = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_loading, (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT),true).findViewById(R.id.iv);
        loadIv.setBackgroundResource(R.drawable.loading);
        background = (AnimationDrawable) loadIv.getBackground();
//        setContentView(loadIv);
        window.setBackgroundDrawable(null);
        setOnShowListener(this);
        setOnDismissListener(this);
    }

    @Override
    public void onShow(DialogInterface dialog) {
        background.start();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        background.stop();
    }
}
