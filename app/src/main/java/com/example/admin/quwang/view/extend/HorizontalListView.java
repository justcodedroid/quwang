package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class HorizontalListView extends HorizontalScrollView implements View.OnClickListener {

    private LinearLayout contentParent;
    private HorizontalAdapter adapter;
    private OnItemClickListener listener;

    public HorizontalListView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setHorizontalScrollBarEnabled(false);
        contentParent = new LinearLayout(getContext());
        contentParent.setOrientation(LinearLayout.HORIZONTAL);
        addView(contentParent);
    }


    public HorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void onClick(View v) {
       int position= getPositionForView(v);
        if(position!=-1&&listener!=null){
            listener.onItemClick(this,v,position);
        }
    }

    private int getPositionForView(View v) {
        int position=-1;
        for (int i = 0; i < adapter.getCount(); i++) {
            boolean equals = adapter.getView(i) == v;
            if(equals){
                position=i;
                break;
            }
        }
        return position;
    }

    public abstract static  class HorizontalAdapter{
        public abstract int getCount();
        public abstract View getView(int position);
    }
    public void setAdapter(HorizontalAdapter adapter){
        contentParent.removeAllViews();
        this.adapter=adapter;
        notfifyDatasetChanged();
        initListener();
    }

    private void initListener() {
        for (int i = 0; i < adapter.getCount(); i++) {
            adapter.getView(i).setOnClickListener(this);
        }
    }

    private void notfifyDatasetChanged() {
        for (int i = 0; i < adapter.getCount(); i++) {
            contentParent.addView(adapter.getView(i));
        }
    }
    public interface OnItemClickListener{
        void onItemClick(HorizontalScrollView horizontalScrollView,View itemView,int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
    public static class SimpleHorizontalAdapter extends HorizontalAdapter{
        List<View> list;

        public SimpleHorizontalAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View getView(int position) {
            return list.get(position);
        }
    }
}
