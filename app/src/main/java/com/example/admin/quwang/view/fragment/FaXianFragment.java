package com.example.admin.quwang.view.fragment;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.FragmentFaxianBinding;
import com.example.admin.quwang.databinding.FragmentGouwucheBinding;

/**
 * Created by admin on 2017/3/26.
 */

public class FaXianFragment extends BaseFragment<FragmentFaxianBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_faxian;
    }

    @Override
    protected void initImpl() {
        bind.tv.setText(getClass().getSimpleName());
    }
}
