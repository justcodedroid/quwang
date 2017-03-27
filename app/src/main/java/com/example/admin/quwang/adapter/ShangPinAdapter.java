package com.example.admin.quwang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.admin.quwang.bean.PromotionListBean;
import com.example.admin.quwang.bean.ShangPinBean;
import com.example.admin.quwang.databinding.ItemShanpinBinding;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class ShangPinAdapter extends BaseAdapter {
    List<ShangPinBean> list;
    Context context;
    LayoutInflater inflater;

    public ShangPinAdapter(List<ShangPinBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
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
        Hodler hodler=null;
        if(convertView==null){
            ItemShanpinBinding inflate = ItemShanpinBinding.inflate(inflater, parent, false);
            hodler=new Hodler();
            hodler.binding=inflate;
            convertView=inflate.getRoot();
            convertView.setTag(inflate);
        }
        hodler= (Hodler) convertView.getTag();
        hodler.binding.setShangpin(list.get(position));
        hodler.binding.executePendingBindings();
        return convertView;
    }

    class Hodler{
        ItemShanpinBinding binding;

    }
}
