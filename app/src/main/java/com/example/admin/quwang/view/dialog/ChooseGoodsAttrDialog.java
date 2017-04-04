package com.example.admin.quwang.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.databinding.LayoutChooseBinding;
import com.example.admin.quwang.utils.DimenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/4.
 */

public class ChooseGoodsAttrDialog extends Dialog implements AdapterView.OnItemClickListener, View.OnClickListener {

    LayoutChooseBinding layoutChooseBinding;
    List<GoodsAttrBean.DataBean.StandardBean.StandardListBean> listBeen = new ArrayList<>();
    private OnChooseListener listener;
int position=0;
    public void setListBeen(List<GoodsAttrBean.DataBean.StandardBean.StandardListBean> listBeen) {
        this.listBeen.clear();
        this.listBeen.addAll(listBeen);
        pop();
    }

    private void pop() {
        popTitle(listBeen.get(0));
        layoutChooseBinding.lv.setAdapter(new ArrayAdapter<GoodsAttrBean.DataBean.StandardBean.StandardListBean>(getContext(),android.R.layout.simple_list_item_1,listBeen));
    }

    private void popTitle(GoodsAttrBean.DataBean.StandardBean.StandardListBean standardListBean) {
        Glide.with(getContext()).load(standardListBean.getAttr_pic()+"").priority(Priority.IMMEDIATE).into(layoutChooseBinding.iv);
        layoutChooseBinding.priceTv.setText(standardListBean.getAttr_price()+"");
        layoutChooseBinding.descTv.setText(standardListBean.getAttr_value()+"");
    }

    public ChooseGoodsAttrDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        layoutChooseBinding = LayoutChooseBinding.inflate(LayoutInflater.from(context), (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT), true);
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(context.getResources().getDisplayMetrics().widthPixels, DimenUtils.dp2px(context, 350));
        window.setBackgroundDrawable(new BitmapDrawable());
        layoutChooseBinding.lv.setOnItemClickListener(this);
        layoutChooseBinding.btn.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GoodsAttrBean.DataBean.StandardBean.StandardListBean standardListBean = listBeen.get(position);
      this.position=position;
        popTitle(standardListBean);
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onChoose(Integer.parseInt(listBeen.get(position).getGoods_attr_id()),1);
        }
        dismiss();
    }

    public interface  OnChooseListener{
        void onChoose(int specid,int goodsNum);
    }
    public void setOnChooseListener(OnChooseListener listener){
        this.listener=listener;
    }
}
