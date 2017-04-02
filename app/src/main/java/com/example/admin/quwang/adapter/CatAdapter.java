package com.example.admin.quwang.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.CatBean;
import com.example.admin.quwang.callback.CatItemClickListener;
import com.example.admin.quwang.databinding.ItemCatBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {
    List<CatBean> list = new ArrayList<>();

    public CatAdapter(Context context) {
        this.context = context;
    }

    public void realsh(List<CatBean> list) {
        if (list == null) {
            this.list.clear();
            notifyDataSetChanged();
            return;
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    Context context;


    @Override
    public CatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatHolder((ItemCatBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_cat, parent, false));
    }

    @Override
    public void onBindViewHolder(CatHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class CatHolder extends BaseHolder<CatBean, ItemCatBinding> {

        public CatHolder(ItemCatBinding bind) {
            super(bind);
        }

        public CatHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bindData(ItemCatBinding bind, CatBean data) {
            bind.setCatbean(data);
            bind.setItemclick(new CatItemClickListener(context));
        }
    }
}
