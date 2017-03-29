package com.example.admin.quwang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.databinding.ItemXiangqingZhedieBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */

public class XiangQingZheDieAdapter extends BaseAdapter {
    Context ctx;
    List<XiangQingResultBean.DataBean.ParameterBean> list = new ArrayList<>();

    public XiangQingZheDieAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void relash(List<XiangQingResultBean.DataBean.ParameterBean> parameterBeen) {
        if (parameterBeen == null) {
            parameterBeen.clear();
            return;
        }
        list.addAll(parameterBeen);
        notifyDataSetChanged();

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
        ZhiDieHodler hodler=null;
        if(convertView==null){
            ItemXiangqingZhedieBinding inflate = ItemXiangqingZhedieBinding.inflate(LayoutInflater.from(ctx), parent, false);
            convertView=inflate.getRoot();
            hodler=new ZhiDieHodler(inflate);
            convertView.setTag(hodler);
        }else {
            hodler= (ZhiDieHodler) convertView.getTag();
        }
        hodler.bind(list.get(position));
        return convertView;
    }

    class ZhiDieHodler {
        ItemXiangqingZhedieBinding binding;

        public ZhiDieHodler(ItemXiangqingZhedieBinding binding) {
            this.binding = binding;
        }

        public void bind(XiangQingResultBean.DataBean.ParameterBean parameterBean) {
            binding.setBean(parameterBean);
            binding.executePendingBindings();
        }
    }
}
