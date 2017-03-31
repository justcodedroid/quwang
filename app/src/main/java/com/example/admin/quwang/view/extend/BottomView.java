package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by admin on 2017/3/31.
 */

public class BottomView extends ListView implements BottomViewInter {
    public BottomView(Context context) {
        super(context);
    }

    public BottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isTop() {
        return getFirstVisiblePosition() == 0 && getChildAt(0).getTop() == 0;
    }
}
