package com.example.admin.quwang.view.fragment;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ViewFlipper;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.EveryOneAdapter;
import com.example.admin.quwang.adapter.ShangPinAdapter;
import com.example.admin.quwang.bean.EveryOneBuyBean;
import com.example.admin.quwang.bean.HotDailyBean;
import com.example.admin.quwang.bean.HotListBean;
import com.example.admin.quwang.bean.OtherRecommendListBean;
import com.example.admin.quwang.bean.PromotionListBean;
import com.example.admin.quwang.bean.ShangPinBean;
import com.example.admin.quwang.bean.TopAdsBean;
import com.example.admin.quwang.bean.WebBean;
import com.example.admin.quwang.databinding.FragmentShouyeBinding;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.presenter.ShouYePresenter;
import com.example.admin.quwang.utils.ActivityRouter;
import com.example.admin.quwang.utils.BannerUtils;
import com.example.admin.quwang.utils.FliperUtils;
import com.example.admin.quwang.utils.HorizontalListViewUtils;
import com.example.admin.quwang.utils.ShangPinXiangQingUtils;
import com.example.admin.quwang.utils.SuperListViewUtils;
import com.example.admin.quwang.utils.WebUtils;
import com.example.admin.quwang.view.ShouYeView;
import com.example.admin.quwang.view.activity.DetatilsActivity;
import com.example.admin.quwang.view.activity.ShangPinXiangQingActivity;
import com.example.admin.quwang.view.activity.WebActivity;
import com.example.admin.quwang.view.extend.Banner;
import com.example.admin.quwang.view.extend.HorizontalListView;
import com.example.admin.quwang.view.extend.SuperFliper;
import com.example.admin.quwang.view.extend.SuperListView;
import com.example.admin.quwang.view.extend.SuperScrollerView;
import com.example.admin.quwang.view.extend.TimeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class ShouYeFragment extends BaseFragment<FragmentShouyeBinding> implements ShouYeView, Banner.OnItemClickListener, HorizontalListView.OnItemClickListener, SuperFliper.OnItemClickListener, TimeView.OnCompleteListener, SuperScrollerView.OnScrolleListener {
    private List<TopAdsBean> bannersList = new ArrayList<>();
    private ShouYePresenter shouYePresenter;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<HotDailyBean> hotDailyList;
    private List<HotListBean> hotListBeanList;
    private List<PromotionListBean> promotionListBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initImpl() {
        bind.banner.setOnItemClickListener(this);
        bind.hotListView.setOnItemClickListener(this);
        bind.fliper.setOnItemClickListener(this);
        bind.timeView.setOnCompleteListener(this);
        bind.promotionListView.setOnItemClickListener(this);
        bind.sv.setOnScrolleListener(this);
        shouYePresenter = new ShouYePresenter();
        shouYePresenter.setShouYeView(this);
        shouYePresenter.loadShouYe();
    }

    public void setAdapter(Banner.BannerAdapter bannerAdapter) {
        bind.banner.setAdapter(bannerAdapter);
        bind.banner.startLoop();
    }

    @Override
    public void relashBannersData(List<TopAdsBean> top_ads) {
        bannersList.clear();
        bannersList.addAll(top_ads);
        convertTopAdsToViews(top_ads);
    }

    @Override
    public void relashHotListData(List<HotListBean> hotListBeanList) {
        this.hotListBeanList = hotListBeanList;
        List<View> hotListViews = HorizontalListViewUtils.convertHotListViews(hotListBeanList, a);
        bind.hotListView.setAdapter(new HorizontalListView.SimpleHorizontalAdapter(hotListViews));
    }

    @Override
    public void relashHotDaily(List<HotDailyBean> hotDailyBeanList) {
        this.hotDailyList = hotDailyBeanList;
        List<View> views = FliperUtils.convertToHotDailyView(hotDailyBeanList, a);
        bind.fliper.setAdapter(new SuperFliper.SimpleFlipeAdapter(views));
        bind.fliper.setInAnimation(a, R.anim.slide_from_bottom);
        bind.fliper.setOutAnimation(a, R.anim.slide_to_top);
        bind.fliper.setFlipInterval(3500);
        bind.fliper.startLoop();

    }

    @Override
    public void relashRetaimeTime(long time) {
        bind.timeView.setTime(time);
        bind.timeView.startLoop();
    }

    @Override
    public void relashPromotionList(List<PromotionListBean> promotionListBeanList) {
        this.promotionListBeanList = promotionListBeanList;
        List<View> list = HorizontalListViewUtils.convertPromotionList(promotionListBeanList, a);
        bind.promotionListView.setAdapter(new HorizontalListView.SimpleHorizontalAdapter(list));
    }

    @Override
    public void relashOthRecommendList(List<OtherRecommendListBean> otherRecommendListBeanList) {
        // other
        List<View> list = SuperListViewUtils.convertOtherRecommandViews(otherRecommendListBeanList, a);
        bind.otherRecommendListView.setAdapter(new SuperListView.SimpleSuperListViewAdapter(list));
    }

    @Override
    public void relashEveryOneButList(List<EveryOneBuyBean> everyOneBuyBeanList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(a, 4);
        bind.everyOneRecycler.setLayoutManager(gridLayoutManager);
        bind.everyOneRecycler.setAdapter(new EveryOneAdapter(everyOneBuyBeanList, a, gridLayoutManager));
    }

    @Override
    public void relashRecommendList(List<ShangPinBean> shangPinBeanList) {
        Log.e("tag", shangPinBeanList.size() + "");
        bind.recommandGv.setAdapter(new ShangPinAdapter(shangPinBeanList, a));
    }

    private void convertTopAdsToViews(List<TopAdsBean> top_ads) {
        final int indectorCounts = top_ads.size();
        BannerUtils.increateData(top_ads);
        List<View> views = BannerUtils.convert(top_ads, a);
        setAdapter(new Banner.SimpleBannerAdapter(views) {
            @Override
            public int getIndectorCount() {
                return indectorCounts;
            }
        });
    }

    @Override
    public void onRetryClick() {
        super.onRetryClick();
        shouYePresenter.loadShouYe();
    }

    @Override
    public void onItemClick(Banner banner, View itemView, int position) {
        TopAdsBean topAdsBean = bannersList.get(position);
        ActivityRouter.router(a, topAdsBean.getType(), topAdsBean.getLink_url());
    }


    @Override
    public void onItemClick(HorizontalScrollView horizontalScrollView, View itemView, int position) {
        if (horizontalScrollView == bind.hotListView) {
            handleHotListItemClick(position);
        }
        if (horizontalScrollView == bind.promotionListView) {
            handlePromotionItemClick(position);
        }
    }

    private void handlePromotionItemClick(int position) {
        int goods_id = promotionListBeanList.get(position).getGoods_id();
        ShangPinXiangQingUtils.startShangPingXiangQingActivity(a, goods_id);
    }

    private void handleHotListItemClick(int position) {
        HotListBean hotListBean = hotListBeanList.get(position);
        if (hotListBean.getLink_url().equals("qdyl")) {
            toast("个人中心fragnnt 签到");
        } else {
            ActivityRouter.router(a, hotListBean.getType(), hotListBean.getLink_url());
        }


    }

    @Override
    public void onItemClick(SuperFliper fliper, View itemView, int position) {
        HotDailyBean hotDailyBean = hotDailyList.get(position);
        Intent intent = new Intent(a, DetatilsActivity.class);
        intent.putExtra("id", hotDailyBean.getId());
        startActivity(intent);
    }

    @Override
    public void onComplete() {
        shouYePresenter.loadShouYe();
    }

    @Override
    public void onScroll(int currentY) {
        float v = currentY * 1.0f / dp2px(150);
        v = Math.min(1.0f, Math.max(0, v));
        int color = (int) argbEvaluator.evaluate(v, Color.TRANSPARENT, Color.parseColor("#dd2929"));
        bind.markView.setBackgroundColor(color);
    }
}
