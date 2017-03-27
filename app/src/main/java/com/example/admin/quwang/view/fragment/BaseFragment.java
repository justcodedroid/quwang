package com.example.admin.quwang.view.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.quwang.databinding.FragmentBaseBinding;
import com.example.admin.quwang.utils.DimenUtils;
import com.example.admin.quwang.view.BaseView;
import com.example.admin.quwang.view.extend.StateLayout;

/**
 * Created by admin on 2017/3/26.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment implements BaseView, StateLayout.OnRetryClickListener {
    protected T bind;
    private StateLayout root;
    boolean isFirst = true;
    private FragmentBaseBinding baseBinding;
    protected Activity a;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        a=activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (root == null) {
            baseBinding = FragmentBaseBinding.inflate(inflater, container, false);
            root = (StateLayout) baseBinding.getRoot();
            root.setOnRetryClickListener(this);
            bind = DataBindingUtil.inflate(inflater, getLayoutId(), baseBinding.containerParent, true);

        }
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        performLozyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (root != null) {
            performLozyLoad();
        }
    }

    private void performLozyLoad() {
        if (getUserVisibleHint() && isFirst) {
            isFirst = false;
            lozyLoad();
        }
    }

    private void lozyLoad() {
        initImpl();
    }

    protected abstract int getLayoutId();

    protected abstract void initImpl();

    @Override
    public void showLoading() {
        root.swicthToLoading();
    }

    @Override
    public void showNormal() {
        root.switchToNormal();
    }

    @Override
    public void showError() {
        root.switchToError();
    }

    @Override
    public void onRetryClick() {

    }
    public void toast(String msg){
        Toast.makeText(a, ""+msg, Toast.LENGTH_SHORT).show();
    }
    public int dp2px(int dp){
        return DimenUtils.dp2px(a,dp);
    }
}
