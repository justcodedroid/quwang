package com.example.admin.quwang.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.PingJiaAdapter;
import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.databinding.FragmentPingJiaBinding;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.presenter.PingJiaPresenter;
import com.example.admin.quwang.view.PingJianView;
import com.example.admin.quwang.view.extend.SuperRecyclerView;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class PingJiaFragment extends BaseFragment<FragmentPingJiaBinding> implements SuperRecyclerView.OnLoadMoreListener, PingJianView {

    int goods_id;
    private PingJiaAdapter adapter;
    int page = 1;
    private PingJiaPresenter pingJiaPresenter;

    public PingJiaFragment setGoods_id(int goods_id) {
        this.goods_id = goods_id;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ping_jia;
    }

    @Override
    protected void initImpl() {
        initView();
        pingJiaPresenter = new PingJiaPresenter();
        pingJiaPresenter.setPingJianView(this);
        pingJiaPresenter.getPingJiaList(goods_id, page);

    }

    private void initView() {
        bind.pingjiaRecycler.setLayoutManager(new LinearLayoutManager(a));
        bind.pingjiaRecycler.setOnLoadMoreListener(this);
        adapter = new PingJiaAdapter(a);
        bind.pingjiaRecycler.setAdapter(adapter);
    }

    @Override
    public void loadMore() {
        pingJiaPresenter.getPingJiaList(goods_id, page);
        if (bind.pingjiaRecycler.isEnableLoadMore()) {
            bind.pb.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError() {
        bind.pb.setVisibility(View.GONE);
        super.showError();
    }

    @Override
    public void showNormal() {
        bind.pb.setVisibility(View.GONE);
        super.showNormal();

    }

    @Override
    public void relashPingJiaList(List<PingJiaBean> pingJiaBeanList, int type) {
        switch (type) {
            case HttpModel.LOADDATASUCCESS:
            case HttpModel.RELASHSUCCESS:
                adapter.relashData(pingJiaBeanList);
                bind.pingjiaRecycler.loadMoreSuccess();
                page++;
                break;
            case HttpModel.NOINITDATA:
            case HttpModel.NOLOADDATA:
                Toast.makeText(a, "没有新数据了", Toast.LENGTH_SHORT).show();
                bind.pingjiaRecycler.enableLoadMore(false);
                break;
        }
    }
}
