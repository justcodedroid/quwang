package com.example.admin.quwang.view.extend;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by admin on 2017/3/29.
 */

public class ZheDieListView extends SuperListView implements View.OnClickListener {

    private ZheDieAdapter adapter;
    private TextView footerView;

    public ZheDieListView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setFooterDividersEnabled(true);
        footerView = new TextView(getContext());
        footerView.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, dp2px(30)));
        footerView.setText("点击查看更多参数");
        footerView.setBackgroundColor(Color.WHITE);
        footerView.setTextColor(Color.parseColor("#aaaaaa"));
        footerView.setTextSize(18);
        footerView.setGravity(Gravity.CENTER);
        addFooterView(footerView, "", false);
        footerView.setOnClickListener(this);

    }

    private int dp2px(int i) {
        return (int) (getResources().getDisplayMetrics().density * i + 0.5f);
    }

    public ZheDieListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ZheDieListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        this.adapter = new ZheDieAdapter(adapter);
        super.setAdapter(this.adapter);

    }

    @Override
    public void onClick(View v) {
        removeFooterView(footerView);
        adapter.setZhiDie(false);
        adapter.notifyDataSetChanged();

    }

    class ZheDieAdapter extends BaseAdapter {
        ListAdapter rawAdapter;
        boolean isZhiDie = true;

        public ZheDieAdapter(ListAdapter rawAdapter) {
            this.rawAdapter = rawAdapter;
            if(rawAdapter.getCount()==0){
                removeFooterView(footerView);
            }
        }

        public void setZhiDie(boolean zhiDie) {
            isZhiDie = zhiDie;
        }

        @Override
        public int getCount() {
            if (isZhiDie && rawAdapter.getCount() > 4) {
                return 4;
            }

            return rawAdapter.getCount();
        }

        @Override
        public Object getItem(int position) {
            return rawAdapter.getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return rawAdapter.getView(position, convertView, parent);
        }
    }
}
