package com.example.admin.quwang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quwang.bean.EveryOneBuyBean;
import com.example.admin.quwang.callback.EveryOneBuyClickListener;
import com.example.admin.quwang.databinding.ItemSpanOneBinding;
import com.example.admin.quwang.databinding.ItemSpanTwoBinding;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class EveryOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<EveryOneBuyBean> list;
    Context ctx;
    LayoutInflater inflater;
    GridLayoutManager manager;
    int spantwo = 2;
    int spanone = 1;

    public EveryOneAdapter(List<EveryOneBuyBean> list, Context ctx, GridLayoutManager manager) {
        this.list = list;
        this.ctx = ctx;
        this.manager = manager;
        inflater = LayoutInflater.from(ctx);
        init();
    }

    private void init() {
        manager.setSpanCount(4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (getItemViewType(position) == spantwo) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == spantwo) {
            return new TwoHodler(ItemSpanTwoBinding.inflate(inflater, parent, false));
        }
        return new OneHodler(ItemSpanOneBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == spantwo) {
            TwoHodler hodler = (TwoHodler) holder;
            hodler.binding.setClick(new EveryOneBuyClickListener(ctx));
            hodler.bind(list.get(position));

        } else {
            OneHodler hodler = (OneHodler) holder;
            hodler.binding.setClick(new EveryOneBuyClickListener(ctx));
            hodler.bind(list.get(position));
        }
    }

    static class TwoHodler extends RecyclerView.ViewHolder {
        ItemSpanTwoBinding binding;

        public TwoHodler(ItemSpanTwoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(EveryOneBuyBean buyBean) {
            binding.setEveryone(buyBean);
            binding.executePendingBindings();
        }
    }

    static class OneHodler extends RecyclerView.ViewHolder {
        ItemSpanOneBinding binding;

        public OneHodler(ItemSpanOneBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(EveryOneBuyBean buyBean) {
            binding.setEveryone(buyBean);
            binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position <= 1) {
            return spantwo;
        }
        return spanone;
    }
}
