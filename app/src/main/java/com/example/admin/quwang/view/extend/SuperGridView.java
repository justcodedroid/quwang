package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by admin on 2017/3/27.
 */

public class SuperGridView extends GridView {
    public SuperGridView(Context context) {
        super(context);
    }

    public SuperGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST));
    }
}
