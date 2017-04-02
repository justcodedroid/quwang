package com.example.admin.quwang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quwang.R;

/**
 * Created by admin on 2017/4/1.
 */

public abstract class SimpleHeadAndFooterAdapter<B, T extends BaseHolder> extends BaseHeadAndFooterAdapter {

    private View footerView;
    private int spanCount;

    protected SimpleHeadAndFooterAdapter(Context context, GridLayoutManager gm) {
        super(context, gm);
        initImpl();

    }

    private void initImpl() {
        footerView = inflater.inflate(R.layout.item_footer, null);
        addFooterView(footerView);
    }

    public void removeFooterView() {
        removeFooterView(footerView);
    }

    @Override
    protected abstract T onCreateViewHolderImpl(ViewGroup parent, int viewType);

    @Override
    protected int getItemViewTypeImpl(int position) {
        return 0;
    }

    @Override
    protected int getCurrentSpanCount(int position) {
        return spanCount;
    }


    public void addFooterView() {
        if (footers.size() == 0) {
            Log.e("tagfooter","添加尾巴");
            addFooterView(footerView);
        }
    }

    public void setSpanCount(int spanCount) {
        this.spanCount=spanCount;
    }

    public int getSpanCount() {
        return spanCount;
    }

    ;

}
