package com.example.admin.quwang.view.extend;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.example.admin.quwang.view.TopViewInter;

/**
 * Created by admin on 2017/3/30.
 */

public class DragToDetailsLayout extends LinearLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Runnable {

    private TopViewInter topScroller;
    private BottomViewInter bottomScroller;
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
    private boolean isFirstUp;

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
                Log.e("tag11", "Action_DOWN");
                startX = (int) ev.getRawX();
                startY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                minX = (int) (ev.getRawX() - startX);
                minY = (int) (ev.getRawY() - startY);
                Log.e("tag11", minY + "------------>" + getCurrentPosition());
                if (Math.abs(minY) / 2 > Math.abs(minX) && Math.abs(minY) > minScroll) {
                    if (minY < 0 && getCurrentPosition() == 0) {
                        if (topScroller.isBottom()) {
                            startX = (int) ev.getRawX();
                            startY = (int) ev.getRawY();
                            isDRAG = true;
                            return true;
                        }
                    }

                    if (minY > 0 && getCurrentPosition() == 1) {
                        if(bottomScroller==null)break;
                        if (bottomScroller.isTop()) {
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
                }
                startY = (int) event.getRawY();


                break;
            case MotionEvent.ACTION_UP:
                if (isDRAG) {
                    if (getScrollY() > getHeight() / 10) {
                        isFirstUp = true;
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
            if (!firstLoad && isFirstUp) {

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
        topScroller = (TopViewInter) getChildAt(0);
    }

    public void setBottomScroller(BottomViewInter bottomScroller) {
        this.bottomScroller = bottomScroller;
    }

    private BottomViewInter getBottomView(int i) {
        View child = getChildAt(i);
        if (child instanceof BottomViewInter) {

        }
        return null;
    }

    boolean isFirst;


    public interface OnToggleListener {
        void onUp();

        void onDown();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        View childAt = getChildAt(1);
        childAt.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, getHeight()));
    }

    public void setOnToggleListener(OnToggleListener listener) {
        this.toggleListener = listener;
    }
}
