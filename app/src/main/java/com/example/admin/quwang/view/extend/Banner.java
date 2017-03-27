package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.admin.quwang.R;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class Banner extends RelativeLayout implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int currentItem = pager.getCurrentItem()+1;
            if(currentItem>=bannerAdapter.getCount()){
                currentItem=0;
            }
            pager.setCurrentItem(currentItem);
            handler.sendEmptyMessageDelayed(0,2500);
        }
    };
    private ViewPager pager;
    private LinearLayout indectorGroups;
    private BannerAdapter bannerAdapter;
    private OnItemClickListener itemClickListener;
    private boolean isLoop;
    private boolean isStop;

    public Banner(Context context) {
        super(context);
        init();
    }
    public void startLoop(){
        isLoop = true;
        handler.sendEmptyMessageDelayed(0,2500);
    }
    public void stopLoop(){
        isLoop=false;
        handler.removeCallbacksAndMessages(null);
    }
    public boolean isLoop(){
        return isLoop;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
       if(isLoop){
           handler.removeCallbacksAndMessages(null);
       }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(isLoop){
            handler.sendEmptyMessageDelayed(0,2500);
        }
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        pager = new ViewPager(getContext());
        addView(pager);

        indectorGroups = new LinearLayout(getContext());
        indectorGroups.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.addRule(CENTER_HORIZONTAL);
        params.bottomMargin = dp2px(10);
        indectorGroups.setLayoutParams(params);
        addView(indectorGroups);

        pager.addOnPageChangeListener(this);
    }

    private View getDot() {
        View view = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dp2px(10), dp2px(10));
        params.rightMargin = dp2px(10);
        view.setLayoutParams(params);
        view.setBackgroundDrawable(getSelectorDrawable());
        return view;
    }

    private Drawable getSelectorDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        // 不写的话  默认的状态是state_window_focus ，所有的时候都满足
        // 取反的话  就是明确的了
        stateListDrawable.addState(new int[]{-android.R.attr.state_selected}, getGradientDrawable(Color.BLACK));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, getGradientDrawable(Color.WHITE));
        return stateListDrawable;
    }

    @NonNull
    private GradientDrawable getGradientDrawable(int color) {
        GradientDrawable normalDrawable = new GradientDrawable();
        normalDrawable.setShape(GradientDrawable.OVAL);
        normalDrawable.setColor(color);
        return normalDrawable;
    }

    private int dp2px(int i) {
        return (int) (getResources().getDisplayMetrics().density * i + 0.5f);
    }

    public void setAdapter(BannerAdapter adapter) {
        this.bannerAdapter = adapter;
        pager.setAdapter(adapter);
        initIndectors();
        initOnItemClickListener();
    }

    private void initOnItemClickListener() {
        for (int i = 0; i < bannerAdapter.getData().size(); i++) {
            bannerAdapter.getData().get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int position = getItemPosition(v);
        if (position != -1 && itemClickListener != null) {
            itemClickListener.onItemClick(this, v, position);
        }
    }

    private int getItemPosition(View v) {
        int position = -1;
        for (int i = 0; i < bannerAdapter.getData().size(); i++) {
            boolean equals = bannerAdapter.getData().get(i) == v;
            if (equals) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentIndector(position);
    }

    private void setCurrentIndector(int position) {
        position%=bannerAdapter.getData().size();
        for (int i = 0; i < indectorGroups.getChildCount(); i++) {
            indectorGroups.getChildAt(i).setSelected(i==position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(isLoop()){
            if(state==ViewPager.SCROLL_STATE_DRAGGING){
                isStop = true;
                handler.removeCallbacksAndMessages(null);
            }
            if(state==ViewPager.SCROLL_STATE_IDLE&&isStop){
                isStop=false;
                handler.sendEmptyMessageDelayed(0,2500);
            }
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Banner banner, View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    private void initIndectors() {
        indectorGroups.removeAllViews();
        for (int i = 0; i < bannerAdapter.getData().size(); i++) {
            View dot = getDot();
            indectorGroups.addView(dot);
        }
        setCurrentIndector(0);
    }

    public abstract static class BannerAdapter extends PagerAdapter {
        @Override
        public abstract int getCount();

        public abstract List<View> getData();

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (getData().size() == 0) return null;
            View view = getData().get(position % getData().size());
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
    public static class SimpleBannerAdapter extends BannerAdapter{
        private final List<View> list;

        public SimpleBannerAdapter (List<View> list){
            // 暂时知识支持 3个轮播
            this.list=list;
        }
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public List<View> getData() {
            return list;
        }
    }

}
