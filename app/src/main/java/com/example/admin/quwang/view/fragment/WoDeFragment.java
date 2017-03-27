package com.example.admin.quwang.view.fragment;

import android.util.Log;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentShouyeBinding;
import com.example.admin.quwang.databinding.FragmentWodeBinding;

/**
 * Created by admin on 2017/3/26.
 */

public class WoDeFragment extends BaseFragment<FragmentWodeBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wode;
    }

    @Override
    protected void initImpl() {
        bind.tv.setText(getClass().getSimpleName());
    }
}
