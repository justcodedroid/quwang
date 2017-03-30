package com.example.admin.quwang.view.extend;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;

/**
 * Created by admin on 2017/3/30.
 */

public class DragToDetailsLayout extends LinearLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Runnable {

    private ScrollView topScroller;
    private ScrollView bottomScroller;
    private int startX;
    private int startY;
    private int minX;
    private int minY;
    private int minScroll;
    private boolean isDRAG;
    private boolean isPull;
    private boolean firstLoad;
    private OnFirstLoadListener loadListener;
    private ValueAnimator valueAnimator;
    private OnToggleListener toggleListener;

    public DragToDetailsLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        minScroll = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        valueAnimator = ValueAnimator.ofFloat();
        valueAnimator.setDuration(200);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addListener(this);
        valueAnimator.setEvaluator(new FloatEvaluator());
        valueAnimator.addUpdateListener(this);
    }


    public DragToDetailsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragToDetailsLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalStateException("有且只有两个孩子");
        }
        wrap();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        isDRAG = false;
        isPull = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getRawX();
                startY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:

                minX = (int) (ev.getRawX() - startX);
                minY = (int) (ev.getRawY() - startY);
                if (Math.abs(minY) / 2 > Math.abs(minX) && Math.abs(minY) > minScroll) {
                    if (minY < 0 && getCurrentPosition() == 0) {
                        if (topScroller.getChildAt(0).getHeight() - topScroller.getScrollY() == topScroller.getHeight()) {
                            startX = (int) ev.getRawX();
                            startY = (int) ev.getRawY();
                            isDRAG = true;
                            return true;
                        }
                    }
                    if (minY > 0 && getCurrentPosition() == 1) {
                        if (bottomScroller.getScrollY() == 0) {
                            startX = (int) ev.getRawX();
                            startY = (int) ev.getRawY();
                            isPull = true;
                            return true;

                        }
                    }
                }
                break;
        }


        return super.onInterceptTouchEvent(ev);
    }

    private int getCurrentPosition() {
        return getScrollY() / getHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float minY = (event.getRawY() - startY) / 4;
                if (isDRAG) {
                    scrollTo(0, (int) (getScrollY() - minY));
                }
                if (isPull) {
                    scrollTo(0, (int) (getScrollY() - minY));
                    isPull = true;
                }
                startY = (int) event.getRawY();
                Log.e("tag", isDRAG + "----->" + isPull);


                break;
            case MotionEvent.ACTION_UP:
                if (isDRAG) {
                    if (getScrollY() > getHeight() / 10) {
                        toUp();
                    } else {
                        toDown();
                    }
                }
                if (isPull) {
                    if (getScrollY() > (getHeight() / 10) * 9) {
                        toUp();
                    } else {
                        toDown();
                    }
                }
                break;

        }
        return true;
    }

    private void toDown() {
        valueAnimator.setFloatValues(getScrollY(), 0);
        valueAnimator.start();
    }

    private void toUp() {
        valueAnimator.setFloatValues(getScrollY(), getHeight());
        valueAnimator.start();

    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if (loadListener != null) {
            if (!firstLoad) {
                firstLoad = true;
                post(this);
            }
        }
        if (toggleListener != null) {
            if (getScrollY() == 0) {
                toggleListener.onDown();
            } else {
                toggleListener.onUp();
            }

        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float animatedValue = (float) animation.getAnimatedValue();
        scrollTo(0, (int) animatedValue);
    }

    @Override
    public void run() {
        loadListener.onFirstLoad();
    }

    public interface OnFirstLoadListener {
        void onFirstLoad();
    }

    public void setOnFirstLoadListener(OnFirstLoadListener listener) {
        this.loadListener = listener;
    }

    private void wrap() {
        topScroller = getWarpView(0);
        bottomScroller = getWarpView(0);
        addView(topScroller);
        addView(bottomScroller);

    }

    private ScrollView getWarpView(int i) {
        View childAt = getChildAt(i);
        removeView(childAt);
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(childAt);
        return scrollView;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(0, i * getHeight(), getWidth(), getHeight() * (i + 1));
        }
    }

    public interface OnToggleListener {
        void onUp();

        void onDown();
    }

    public void setOnToggleListener(OnToggleListener listener) {
        this.toggleListener = listener;
    }
}
