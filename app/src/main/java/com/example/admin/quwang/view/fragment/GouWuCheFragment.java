package com.example.admin.quwang.view.fragment;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentGouwucheBinding;
import com.example.admin.quwang.databinding.FragmentShouyeBinding;

/**
 * Created by admin on 2017/3/26.
 */

public class GouWuCheFragment extends BaseFragment<FragmentGouwucheBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gouwuche;
    }

    @Override
    protected void initImpl() {
        bind.tv.setText(getClass().getSimpleName());
    }
}
