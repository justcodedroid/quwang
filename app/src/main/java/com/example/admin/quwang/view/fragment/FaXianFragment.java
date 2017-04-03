package com.example.admin.quwang.view.fragment;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.FaXianManWomanAdapter;
import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.databinding.FragmentFaxianBinding;
import com.example.admin.quwang.databinding.FragmentGouwucheBinding;
import com.example.admin.quwang.presenter.FaXianPresenter;
import com.example.admin.quwang.utils.HorizontalListViewUtils;
import com.example.admin.quwang.view.FaXianView;
import com.example.admin.quwang.view.extend.HorizontalListView;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class FaXianFragment extends BaseFragment<FragmentFaxianBinding> implements FaXianView{

    private FaXianPresenter faXianPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_faxian;
    }

    @Override
    protected void initImpl() {
        bind.manRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        bind.womanRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        faXianPresenter = new FaXianPresenter();
        faXianPresenter.setFaXianView(this);
        faXianPresenter.getFaXianBean();
    }

    @Override
    public void relashHotRecommand(List<FaXianBean.DataBean.HotRecommendBean> hotRecommendBeanList) {
        List<View> list = HorizontalListViewUtils.convertRecommendViews(hotRecommendBeanList, a);
        Log.e("tag",list.size()+"----------->hot");
        bind.lv.setAdapter(new HorizontalListView.SimpleHorizontalAdapter(list));
    }

    @Override
    public void relashTopicBeans(List<FaXianBean.DataBean.HotTopicBean> topicBeanList) {
      List<View> list=  HorizontalListViewUtils.convertTopicViews(topicBeanList,a);
        bind.topicLv.setAdapter(new HorizontalListView.SimpleHorizontalAdapter(list));
    }

    @Override
    public void relashMan(List<FaXianBean.DataBean.ManBean> manBeanList) {
        Log.e("size---->",manBeanList.size()+"----->");
        bind.manRecycler.setAdapter(new FaXianManWomanAdapter(manBeanList,a));
    }

    @Override
    public void relashWoman(List<FaXianBean.DataBean.ManBean> womanList) {
        bind.womanRecycler.setAdapter(new FaXianManWomanAdapter(womanList,a));
    }

    @Override
    public void onRetryClick() {
        super.onRetryClick();
        faXianPresenter.getFaXianBean();
    }
}
