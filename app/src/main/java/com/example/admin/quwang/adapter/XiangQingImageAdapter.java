package com.example.admin.quwang.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.databinding.ItemXiangqingImageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingImageAdapter extends BaseAdapter {
    List<XiangQingImageResultBean.ImageBean> list = new ArrayList<>();
    Context ctx;

    public XiangQingImageAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void relash(List<XiangQingImageResultBean.ImageBean> imageBeanList) {
        if (imageBeanList == null) {
            list.clear();
            return;
        }
        list.addAll(imageBeanList);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageHodler hodler = null;
        if (convertView == null) {
            LayoutInflater from = LayoutInflater.from(ctx);
            ItemXiangqingImageBinding inflate = ItemXiangqingImageBinding.inflate(from);
            convertView = inflate.getRoot();
            hodler = new ImageHodler(inflate);
            convertView.setTag(hodler);
        } else {
            hodler = (ImageHodler) convertView.getTag();
        }

        hodler.bind(list.get(position));
        return convertView;
    }

    class ImageHodler {
        private ItemXiangqingImageBinding binding;

        public ImageHodler(ItemXiangqingImageBinding binding) {
            this.binding = binding;
        }

        public void bind(XiangQingImageResultBean.ImageBean imageBean) {
            binding.setImg(imageBean);
//            float height = (ctx.getResources().getDisplayMetrics().widthPixels / imageBean.getImg_width()) * imageBean.getImg_height();

            binding.getRoot().setLayoutParams(new AbsListView.LayoutParams(imageBean.getImg_width(), imageBean.getImg_height()));
            binding.executePendingBindings();
        }
    }
}
