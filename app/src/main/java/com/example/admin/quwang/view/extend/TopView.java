package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.example.admin.quwang.view.TopViewInter;

/**
 * Created by admin on 2017/3/31.
 */

public class TopView extends SuperScrollerView implements TopViewInter {
    public TopView(Context context) {
        super(context);
    }

    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isBottom() {
        if (getChildCount() > 0) {
            return getChildAt(0).getHeight() - getScrollY() == getHeight();
        }
        return false;
    }
}
