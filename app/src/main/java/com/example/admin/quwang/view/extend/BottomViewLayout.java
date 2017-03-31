package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by admin on 2017/3/31.
 */

public class BottomViewLayout extends FrameLayout implements BottomViewInter {
    public BottomViewLayout(@NonNull Context context) {
        super(context);
    }

    public BottomViewLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomViewLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isTop() {
        BottomViewInter childAt = (BottomViewInter) getChildAt(0);
        return childAt.isTop();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
}
