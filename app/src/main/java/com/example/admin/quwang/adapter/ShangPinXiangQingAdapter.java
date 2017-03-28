package com.example.admin.quwang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinXiangQingAdapter extends SimpleFragmentPagerAdapter {
    String[] titles = new String[]{"商品", "详情", "评价"};

    public ShangPinXiangQingAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm, list);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
