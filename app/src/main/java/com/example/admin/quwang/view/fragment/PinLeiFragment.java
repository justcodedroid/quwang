package com.example.admin.quwang.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.CatAdapter;
import com.example.admin.quwang.adapter.PinLeiAdapter;
import com.example.admin.quwang.bean.CatBean;
import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.databinding.FragmentPinleiBinding;
import com.example.admin.quwang.databinding.HeadCatBinding;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.presenter.PinLeiPresenter;
import com.example.admin.quwang.utils.HttpUtils;
import com.example.admin.quwang.utils.PeiLeiMapUtils;
import com.example.admin.quwang.view.PinLeiView;
import com.example.admin.quwang.view.extend.SuperRecyclerView;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/1.
 */

public class PinLeiFragment extends BaseFragment<FragmentPinleiBinding> implements SuperRecyclerView.OnLoadMoreListener, PinLeiView {
    private String type;
    private String sort = "";
    private int ad_id;
    private GridLayoutManager gridLayoutManager;
    private PinLeiAdapter pinLeiAdapter;
    private PinLeiPresenter pinLeiPresenter;
    private HeadCatBinding catBinding;

    public PinLeiFragment newInstance(String type, String sort, int ad_id) {
        this.type = type;
        this.sort = sort;
        this.ad_id = ad_id;
        return this;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pinlei;
    }

    public String getSort() {
        return sort;
    }

    @Override
    protected void initImpl() {
        pinLeiPresenter = new PinLeiPresenter();
        pinLeiPresenter.setPinLeiView(this);

        pinLeiPresenter.getPinLeiBean(type, sort, ad_id, PeiLeiMapUtils.map);
        gridLayoutManager = new GridLayoutManager(a, 2);
        bind.recycler.setLayoutManager(gridLayoutManager);
        bind.recycler.setOnLoadMoreListener(this);
        pinLeiAdapter = new PinLeiAdapter(a, gridLayoutManager);
        pinLeiAdapter.setSpanCount(spanCount);
        bind.recycler.setAdapter(pinLeiAdapter);
    }

    @Override
    public void loadMore() {
        pinLeiPresenter.getPinLeiBean(type, sort, ad_id,PeiLeiMapUtils.map);
    }

    @Override
    public void realshShangPinBeans(final List<PinLeiBean.SimpleShangPinBean> simpleShangPinBeens, int type) {
//  切花数据 分业及爱咋
        switch (type) {
            case HttpModel.NOLOADDATA:
                Toast.makeText(a, "到头了", Toast.LENGTH_SHORT).show();
                pinLeiAdapter.removeFooterView();
                bind.recycler.enableLoadMore(false);
                break;
            case HttpModel.NOINITDATA:
                // 空布局
                break;
            case HttpModel.RELASHSUCCESS:
                pinLeiAdapter.relashDataList(null);
                gridLayoutManager.scrollToPosition(0);
            case HttpModel.LOADDATASUCCESS:
                bind.recycler.loadMoreSuccess();
                pinLeiAdapter.relashDataList(simpleShangPinBeens);
                break;
        }


    }

    @Override
    public void relashCatBeans(List<CatBean> catBeanList) {
        catBinding = DataBindingUtil.inflate(LayoutInflater.from(a), R.layout.head_cat, null, false);
        catBinding.catRecycler.setLayoutManager(new GridLayoutManager(a, 4));
        CatAdapter catAdapter = new CatAdapter(a);
        catBinding.catRecycler.setAdapter(catAdapter);
        pinLeiAdapter.addHeadView(catBinding.getRoot());
        catAdapter.realsh(catBeanList);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(a, "" + msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRetryClick() {
        super.onRetryClick();
        pinLeiPresenter.getPinLeiBean(type, sort, ad_id,PeiLeiMapUtils.map);
    }

    public void reload() {
        bind.recycler.enableLoadMore(true);
        pinLeiAdapter.addFooterView();
        if (catBinding != null)
            pinLeiAdapter.removeHeadView(catBinding.getRoot());
        pinLeiPresenter.regetPinLeiBean(type, sort, ad_id,PeiLeiMapUtils.map);
    }

    int spanCount = 2;

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    public void toogle() {
        if (spanCount == 1) {
            spanCount = 2;
        } else {
            spanCount = 1;
        }
        if (gridLayoutManager == null) {
            return;
        }

        pinLeiAdapter.setSpanCount(spanCount);
        pinLeiAdapter.notifyDataSetChanged();
    }
}
