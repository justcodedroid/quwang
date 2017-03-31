package com.example.admin.quwang.view.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.XiangQingImageAdapter;
import com.example.admin.quwang.adapter.XiangQingZheDieAdapter;
import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;
import com.example.admin.quwang.databinding.FragmentXiangQingBinding;
import com.example.admin.quwang.presenter.XiangQingParameterPresenter;
import com.example.admin.quwang.view.XiangQingView;
import com.example.admin.quwang.view.extend.SuperListView;
import com.example.admin.quwang.view.extend.ZheDieListView;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class XiangQingFragment extends BaseFragment<FragmentXiangQingBinding> implements XiangQingView {
    int goods_id;
    private XiangQingParameterPresenter xiangQingParameterPresenter;
    private ZheDieListView zhedilv;

    public XiangQingFragment setGoods_id(int goods_id) {
        this.goods_id = goods_id;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiang_qing;
    }

    @Override
    protected void initImpl() {
        xiangQingParameterPresenter = new XiangQingParameterPresenter();
        xiangQingParameterPresenter.setXiangQingView(this);
        xiangQingParameterPresenter.getXiangQingParameterBeans(goods_id);
        Log.e("tag", "开是填充书了");
    }


    @Override
    public void relashParameterBeans(List<XiangQingResultBean.DataBean.ParameterBean> list) {
        if (list == null || list.size() == 0) return;
        XiangQingZheDieAdapter xiangQingZheDieAdapter = new XiangQingZheDieAdapter(a);
        xiangQingZheDieAdapter.relash(list);
        zhedilv = (ZheDieListView) LayoutInflater.from(a).inflate(R.layout.head_zhedi, null);
        zhedilv.setAdapter(xiangQingZheDieAdapter);
        bind.imagesLv.addHeaderView(zhedilv, "", true);
    }

    @Override
    public void relashImageBeans(XiangQingImageResultBean.DataBean dataBeen) {
        XiangQingImageAdapter adapter = new XiangQingImageAdapter(a);
        adapter.relash(dataBeen.getUrl_list());
        bind.imagesLv.setAdapter(adapter);

    }

    @Override
    public void onRetryClick() {
        super.onRetryClick();
        xiangQingParameterPresenter.getXiangQingParameterBeans(goods_id);
    }
}
