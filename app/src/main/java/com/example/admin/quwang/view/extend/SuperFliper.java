package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class SuperFliper extends ViewFlipper implements View.OnClickListener {
    private FliperAdapter adapter;
    private OnItemClickListener listener;

    public SuperFliper(Context context) {
        super(context);

    }

    public SuperFliper(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void onClick(View v) {
        int positionForView = getPositionForView(v);
        if (listener != null && positionForView != -1) {
            listener.onItemClick(this, v, positionForView);
        }
    }

    private int getPositionForView(View view) {
        int position = -1;
        for (int i = 0; i < adapter.getCount(); i++) {
            boolean equals = adapter.getView(i) == view;
            if (equals) {
                position = i;
                break;
            }
        }
        return position;
    }


    public abstract static class FliperAdapter {
        public abstract int getCount();


        public abstract View getView(int position);
    }

    public void setAdapter(FliperAdapter adapter) {
        stopLoop();
        this.adapter = adapter;
        removeAllViews();
        initViews();
        initListener();
    }

    private void initListener() {
        for (int i = 0; i < adapter.getCount(); i++) {
            adapter.getView(i).setOnClickListener(this);
        }
    }

    private void initViews() {
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(i);
            addView(view);
        }

    }

    public void startLoop() {
        startFlipping();
    }

    public void stopLoop() {
        stopFlipping();
    }

    public interface OnItemClickListener {
        void onItemClick(SuperFliper fliper, View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class SimpleFlipeAdapter extends FliperAdapter {
        List<View> list;
        public SimpleFlipeAdapter(List<View> list) {
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
