package com.example.admin.quwang.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quwang.bean.Categorybean;
import com.example.admin.quwang.callback.AllCategoryListener;
import com.example.admin.quwang.databinding.ItemParentAllCategoryBinding;
import com.example.admin.quwang.databinding.ItemSubAllCategoryBinding;

import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public class AllCategoryAdapter extends RecyclerView.Adapter<BaseHolder<Categorybean.SubCategoryBean, ViewDataBinding>> {
    private List<Categorybean.SubCategoryBean> list;
    Context context;
    LayoutInflater inflater;
    GridLayoutManager manager;

    public AllCategoryAdapter(List<Categorybean.SubCategoryBean> list, Context context, GridLayoutManager manager) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.manager = manager;
        init();
    }

    private void init() {
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemViewType = getItemViewType(position);
                if (itemViewType == 1)
                    return manager.getSpanCount();
                return 1;
            }
        });
    }

    @Override
    public BaseHolder<Categorybean.SubCategoryBean, ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            ItemParentAllCategoryBinding inflate = ItemParentAllCategoryBinding.inflate(inflater, parent, false);
            BaseHolder holder = new ParentHolder(inflate);
            return holder;
        } else {
            ItemSubAllCategoryBinding inflate = ItemSubAllCategoryBinding.inflate(inflater, parent, false);
            BaseHolder subHolder = new SubHolder(inflate);
            return subHolder;
        }

    }

    @Override
    public void onBindViewHolder(BaseHolder<Categorybean.SubCategoryBean, ViewDataBinding> holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    class ParentHolder extends BaseHolder<Categorybean.SubCategoryBean, ItemParentAllCategoryBinding> {

        public ParentHolder(ItemParentAllCategoryBinding bind) {
            super(bind);
        }

        public ParentHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bindData(ItemParentAllCategoryBinding bind, Categorybean.SubCategoryBean data) {
            bind.setSub(data);
        }
    }

    class SubHolder extends BaseHolder<Categorybean.SubCategoryBean, ItemSubAllCategoryBinding> {


        public SubHolder(ItemSubAllCategoryBinding bind) {
            super(bind);
        }

        @Override
        protected void bindData(ItemSubAllCategoryBinding bind, Categorybean.SubCategoryBean data) {
            bind.setListener(new AllCategoryListener(context));
            bind.setSub(data);
        }
    }
}
