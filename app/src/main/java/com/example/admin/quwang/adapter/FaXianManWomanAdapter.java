package com.example.admin.quwang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.callback.ManItemClickListener;
import com.example.admin.quwang.databinding.ItemFaxianLvBinding;
import com.example.admin.quwang.databinding.ItemFaxianManwomanBinding;
import com.example.admin.quwang.utils.DimenUtils;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */

public class FaXianManWomanAdapter extends RecyclerView.Adapter<BaseHolder<FaXianBean.DataBean.ManBean, ViewDataBinding>> {
    List<FaXianBean.DataBean.ManBean> list;
    Context context;

    public FaXianManWomanAdapter(List<FaXianBean.DataBean.ManBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BaseHolder<FaXianBean.DataBean.ManBean, ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFaxianManwomanBinding inflate = ItemFaxianManwomanBinding.inflate(LayoutInflater.from(context), parent, false);
        BaseHolder holder = new NormalHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseHolder<FaXianBean.DataBean.ManBean, ViewDataBinding> holder, int position) {
        if (position == 0) {
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, DimenUtils.dp2px(context, 150));
            holder.itemView.setLayoutParams(params);
        } else {
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, DimenUtils.dp2px(context, 75));
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(DimenUtils.dp2px(context, 75), DimenUtils.dp2px(context, 75));
            params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params1.addRule(RelativeLayout.CENTER_VERTICAL);
            holder.itemView.findViewById(R.id.iv).setLayoutParams(params1);
            holder.itemView.setLayoutParams(params);
        }
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NormalHolder extends BaseHolder<FaXianBean.DataBean.ManBean, ItemFaxianManwomanBinding> {

        public NormalHolder(ItemFaxianManwomanBinding bind) {
            super(bind);
        }

        @Override
        protected void bindData(ItemFaxianManwomanBinding bind, FaXianBean.DataBean.ManBean data) {
            bind.setListener(new ManItemClickListener(context));
            bind.setMan(data);
        }
    }
}
