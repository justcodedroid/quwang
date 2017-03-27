package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.admin.quwang.R;

/**
 * Created by admin on 2017/3/26.
 */

public class StateLayout extends FrameLayout implements View.OnClickListener {

    private ImageView loaddingView;
    private View errorView;
    private OnRetryClickListener retryListener;
    private AnimationDrawable loadingAnimation;
    private View normalView;

    public StateLayout(@NonNull Context context) {
        super(context);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        errorView.findViewById(R.id.retry_btn).setOnClickListener(this);
        loaddingView.setBackgroundResource(R.drawable.loading);
        loadingAnimation = (AnimationDrawable) loaddingView.getBackground();

    }
    @Override
    public void onClick(View v) {
        if(retryListener!=null){
            retryListener.onRetryClick();
        }
    }
    public interface OnRetryClickListener{
        void onRetryClick();
    }
    public void setOnRetryClickListener(OnRetryClickListener listener){
        this.retryListener=listener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if(childCount!=3){
            throw new IllegalStateException("StateLayout只能有一个孩子");
        }
        errorView=getChildAt(0);
        loaddingView= (ImageView) getChildAt(1);
        normalView = getChildAt(2);
        init();
        initDefaultState();
    }

    private void initDefaultState() {
        switchToNormal();
    }

    public void switchToNormal(){
        normalView.setVisibility(VISIBLE);
        loadingAnimation.stop();
        loaddingView.setVisibility(GONE);
        errorView.setVisibility(GONE);
    }
    public void switchToError(){
        errorView.setVisibility(VISIBLE);
        loadingAnimation.stop();
        loaddingView.setVisibility(GONE);
        normalView.setVisibility(GONE);
    }
    public void swicthToLoading(){
        loaddingView.setVisibility(VISIBLE);
        loadingAnimation.start();
        errorView.setVisibility(GONE);
        normalView.setVisibility(GONE);
    }

}
