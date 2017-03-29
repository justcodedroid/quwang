package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 2017/3/14.
 */

public class SuperRecyclerView extends RecyclerView {

    private GestureDetector gestureDetector;
    private OnItemClickListener listener;
    private GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (listener != null) {
                float x = e.getX();
                float y = e.getY();
                View childViewUnder = findChildViewUnder(x, y);
                int position = -1;
                if (childViewUnder != null) {
                    ViewHolder containingViewHolder = findContainingViewHolder(childViewUnder);
                    position = containingViewHolder.getAdapterPosition();
                }
                if (position != -1) {
                    listener.onItemClick(SuperRecyclerView.this, childViewUnder, position);
                }
            }

            return super.onSingleTapUp(e);
        }
    };
    private boolean isLoadingMore;
    private OnScrollListener onScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && (getLastFirstPosition() == getAdapter().getItemCount() - 1)) {
                if (enableLoadMore) {
                    if (loadMoreListener != null && !isLoadingMore) {
                        isLoadingMore = true;
                        loadMoreListener.loadMore();
                    }
                }
            }
        }
    };

    public void loadMoreSuccess() {
        isLoadingMore = false;
    }

    private boolean enableLoadMore = true;
    private OnLoadMoreListener loadMoreListener;

    public boolean isEnableLoadMore() {
        return enableLoadMore;
    }

    public interface OnLoadMoreListener {
        void loadMore();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public void enableLoadMore(boolean enable) {
        this.enableLoadMore = enable;
    }

    private int getLastFirstPosition() {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] poositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
            ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(poositions);
            return poositions[poositions.length - 1];
        }
        return 0;
    }


    public SuperRecyclerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        gestureDetector = new GestureDetector(simpleOnGestureListener);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        addOnScrollListener(onScrollListener);
    }


    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }
}
