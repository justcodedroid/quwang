package com.example.admin.quwang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/3/20.
 */

public class TuPianYuLanPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public TuPianYuLanPagerAdapter(List<Fragment> list, FragmentManager fm) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

