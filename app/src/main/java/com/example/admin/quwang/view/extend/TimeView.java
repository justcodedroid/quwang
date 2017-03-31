package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2017/3/27.
 */

public class TimeView extends LinearLayout {

    private TextView hTv;
    private TextView mTv;
    private TextView sTv;
    private long retaimeTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (retaimeTime <= 0) {
                if (listener != null) {
                    listener.onComplete();
                }
            } else {
                handleTime();
                retaimeTime -= 1;
                if (retaimeTime < 0) retaimeTime = 0;
                sendEmptyMessageDelayed(0, 1000);
            }
        }
    };
    private SimpleDateFormat format;

    @Override
    protected void onDetachedFromWindow() {
        handler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isLoop) {
            handler.sendEmptyMessageDelayed(0, 0);
        }
    }

    private void handleTime() {
        hTv.setText(" " +getHour(retaimeTime) + " ");
        mTv.setText(" " + getMin(retaimeTime)+ " ");
        sTv.setText(" " + getSecond(retaimeTime)+ " ");


    }

    private String getHour(long retaimeTime) {
        int HOUR=60*60;
        int h= (int) (retaimeTime/HOUR);
        if(h<10){
            return "0"+h;
        }
        return h+"";
    }

    private String getMin(long retaimeTime) {
        int HOUR=60*60;
        int h= (int) (retaimeTime/HOUR);
        long min = (retaimeTime - h * 60 * 60)/60;
        if(min<10){
            return "0"+min;
        }
        return ""+min;
    }

    private String getSecond(long retaimeTime) {
        long l = retaimeTime % 60;
        if(l<10){
            return "0"+l;
        }
        return l+"";
    }

    private boolean isLoop;
    private OnCompleteListener listener;

    public TimeView(Context context) {
        super(context);
        init();
    }


    private void init() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        hTv = new TextView(getContext());
        hTv.setTextSize(16);
        TextView maoTv1 = new TextView(getContext());
        mTv = new TextView(getContext());
        mTv.setTextSize(16);
        TextView maoTv2 = new TextView(getContext());
        sTv = new TextView(getContext());
        sTv.setTextSize(16);
        maoTv1.setText(" : ");
        maoTv2.setText(" : ");
        addView(hTv);
        addView(maoTv1);
        addView(mTv);
        addView(maoTv2);
        addView(sTv);
        hTv.setTextColor(Color.parseColor("#FF966A"));
        mTv.setTextColor(Color.parseColor("#FF966A"));
        sTv.setTextColor(Color.parseColor("#FF966A"));
        hTv.setBackgroundDrawable(getShape());
        mTv.setBackgroundDrawable(getShape());
        sTv.setBackgroundDrawable(getShape());
        hTv.setPadding(dp2px(2), dp2px(2), dp2px(2), dp2px(2));
        mTv.setPadding(dp2px(2), dp2px(2), dp2px(2), dp2px(2));
        sTv.setPadding(dp2px(2), dp2px(2), dp2px(2), dp2px(2));

        hTv.setText("    ");
        mTv.setText("    ");
        sTv.setText("    ");

        format = new SimpleDateFormat("HH-mm-SS");
    }

    private Drawable getShape() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setStroke(dp2px(2), Color.parseColor("#FF966A"));
        drawable.setCornerRadius(dp2px(5));
        return drawable;
    }

    private int dp2px(int i) {
        return (int) (getResources().getDisplayMetrics().density * i + 0.5f);
    }


    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setTime(long time) {
        retaimeTime = time;
    }

    public void startLoop() {
        isLoop = true;
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(0, 0);
    }

    public void stopLoop() {
        isLoop = false;
        handler.removeCallbacksAndMessages(null);
    }


    public interface OnCompleteListener {
        void onComplete();
    }


    public void setOnCompleteListener(OnCompleteListener listener) {
        this.listener = listener;
    }
}
