package com.example.admin.quwang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/1.
 */

public abstract class BaseHeadAndFooterAdapter<B, T extends BaseHolder> extends RecyclerView.Adapter {
    private Context ctx;
    protected List<View> heads = new ArrayList<>();
    protected List<View> footers = new ArrayList<>();
    protected List<B> list = new ArrayList<>();
    protected LayoutInflater inflater;
    private int HEADTYPE = -1000;
    private int FOOTERTYPE = 1000;
    private GridLayoutManager manager;
    GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            int itemViewType = getItemViewType(position);
            if (itemViewType >= FOOTERTYPE) {
                return manager.getSpanCount();
            }
            if (itemViewType <= HEADTYPE) {
                return manager.getSpanCount();
            }
            return getCurrentSpanCount(position - heads.size());
        }
    };


    protected BaseHeadAndFooterAdapter(Context context, GridLayoutManager gm) {
        this.ctx = context;
        inflater = LayoutInflater.from(context);
        manager = gm;
        init();
    }

    private void init() {
        manager.setSpanSizeLookup(spanSizeLookup);
    }

    ;

    public void relashDataList(List<B> datas) {
        if (datas == null) {
            list.clear();
            notifyDataSetChanged();
            return;
        }
        list.addAll(datas);
        notifyDataSetChanged();
    }

    public void addHeadView(View headView) {
        headView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        heads.add(headView);
    }

    public void addFooterView(View footerView) {
        footerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        footers.add(footerView);
    }

    public void removeFooterView(View footerView) {
        footers.remove(footerView);
        notifyDataSetChanged();
    }


    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int itemViewType) {

        if (itemViewType <= HEADTYPE) {
            int position = HEADTYPE - itemViewType;
            return onCreateHeadViewHolderImpl(parent, heads.get(position));
        }
        if (itemViewType >= FOOTERTYPE) {
            int position = itemViewType - FOOTERTYPE;
            Log.e("position",position+"--->"+itemViewType);
            return onCreateFooterViewHolderImpl(parent, footers.get(position));
        }

        return onCreateViewHolderImpl(parent, itemViewType);
    }

    protected final RecyclerView.ViewHolder onCreateFooterViewHolderImpl(ViewGroup parent, View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }

    protected final RecyclerView.ViewHolder onCreateHeadViewHolderImpl(ViewGroup parent, View view) {
        return new RecyclerView.ViewHolder(view) {
        };
    }

    ;

    protected abstract T onCreateViewHolderImpl(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >= heads.size() && position < list.size()) {
            T h = (T) holder;
            h.bind(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (list.size() == 0) return 0;
        return list.size() + heads.size() + footers.size();
    }

    @Override
    public final int getItemViewType(int position) {
        if (position < heads.size()) {
            return HEADTYPE - position;
        }
        if (position >= heads.size() && position < list.size()+heads.size()) {
            return getItemViewTypeImpl(position - heads.size());
        }
        return FOOTERTYPE + (position - heads.size() - list.size());
    }

    protected abstract int getItemViewTypeImpl(int position);

    protected abstract int getCurrentSpanCount(int position);

    public void removeHeadView(View view) {
        heads.remove(view);
        notifyDataSetChanged();
    }
}
