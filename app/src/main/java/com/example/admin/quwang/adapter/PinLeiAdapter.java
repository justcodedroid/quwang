package com.example.admin.quwang.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.ShangPinBean;
import com.example.admin.quwang.databinding.ItemGridStyleBinding;
import com.example.admin.quwang.databinding.ItemListPinleiBinding;
import com.example.admin.quwang.view.extend.Banner;

/**
 * Created by admin on 2017/4/1.
 */

public class PinLeiAdapter extends SimpleHeadAndFooterAdapter<ShangPinBean, BaseStyleHolder> {
    public PinLeiAdapter(Context context, GridLayoutManager gm) {
        super(context, gm);
    }

    @Override
    protected BaseStyleHolder onCreateViewHolderImpl(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            ItemListPinleiBinding inflate = DataBindingUtil.inflate(inflater, R.layout.item_list_pinlei, parent, false);
            return new PeiLeiListHolder(inflate);
        } else {
            ItemGridStyleBinding inflate = DataBindingUtil.inflate(inflater, R.layout.item_grid_style, parent, false);
            return new PinLeiGridHolder(inflate);
        }
    }

    @Override
    protected int getItemViewTypeImpl(int position) {
        return getSpanCount();
    }
}
