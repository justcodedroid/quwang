package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by admin on 2017/3/26.
 */

public class SuperScrollerView extends ScrollView {
    private OnScrolleListener listener;

    public SuperScrollerView(Context context) {
        super(context);
        init();
    }

    public SuperScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SuperScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOverScrollMode(View.OVER_SCROLL_NEVER);
        setVerticalScrollBarEnabled(false);
    }

    public interface OnScrolleListener{
        void onScroll(int currentY);
    }
    public void setOnScrolleListener(OnScrolleListener listener){
        this.listener=listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(listener!=null){
            listener.onScroll(getScrollY());
        }
    }
}
