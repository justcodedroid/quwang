package com.example.admin.quwang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.databinding.ItemPingjiaBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class PingJiaAdapter extends RecyclerView.Adapter<PingJiaAdapter.PingJiaViewHolder> {

    private Context context;
    List<PingJiaBean> list = new ArrayList<>();
    LayoutInflater inflater;

    public PingJiaAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void relashData(List<PingJiaBean> pingJiaBeanList) {
        if (pingJiaBeanList == null) {
            list.clear();
        }
        this.list.addAll(pingJiaBeanList);
        notifyDataSetChanged();
    }

    @Override
    public PingJiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PingJiaViewHolder(ItemPingjiaBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(PingJiaViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PingJiaViewHolder extends RecyclerView.ViewHolder {
        private ItemPingjiaBinding binding;

        public PingJiaViewHolder(ItemPingjiaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PingJiaBean bean) {
            binding.setPingjia(bean);
            binding.executePendingBindings();
        }
    }
}
