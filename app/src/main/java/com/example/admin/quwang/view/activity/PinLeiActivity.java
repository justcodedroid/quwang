package com.example.admin.quwang.view.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.SimpleFragmentPagerAdapter;
import com.example.admin.quwang.databinding.ActivityPinLeiBinding;
import com.example.admin.quwang.view.fragment.PinLeiFragment;

import java.util.ArrayList;
import java.util.List;

public class PinLeiActivity extends BaseActivity<ActivityPinLeiBinding> implements TabLayout.OnTabSelectedListener {


    private List<Fragment> list;
    private String pinleiid;
    private int ad;

    @Override
    protected void initImpl() {
        Intent intent = getIntent();
        pinleiid = intent.getStringExtra("pinleiid");
        ad = intent.getIntExtra("ad", 0);
        list = new ArrayList<>();
        initData();

    }

    private void initData() {
        list.add(new PinLeiFragment().newInstance(pinleiid, "default", ad));
        list.add(new PinLeiFragment().newInstance(pinleiid, "sale", ad));
        list.add(new PinLeiFragment().newInstance(pinleiid, "price_desc", ad));
        bind.pager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), list));
        bind.tabLayout.addTab(bind.tabLayout.newTab().setCustomView(getTextView("默认")));
        bind.tabLayout.addTab(bind.tabLayout.newTab().setCustomView(getTextView("销量")));
        bind.tabLayout.addTab(bind.tabLayout.newTab().setCustomView(getTextView("价格")));
        bind.tabLayout.addTab(bind.tabLayout.newTab().setCustomView(getTextView("删选")));
        bind.pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(bind.tabLayout));
        bind.tabLayout.addOnTabSelectedListener(this);
    }

    private TextView getTextView(String s) {
        TextView tv = new TextView(this);
        tv.setText(s);
        tv.setTextSize(20);
        tv.setGravity(Gravity.CENTER);
        ColorStateList colorStateList = new ColorStateList(new int[][]{{android.R.attr.state_selected}, {-android.R.attr.state_selected}}, new int[]{Color.parseColor("#666666"), Color.parseColor("#cccccc")});
        tv.setTextColor(colorStateList);
        return tv;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pin_lei;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getPosition() == 3) {
                return;
        }
        if (tab.getPosition() == 2) {
            PinLeiFragment fragment = (PinLeiFragment) list.get(2);
            TextView customView = (TextView) tab.getCustomView();
            if (fragment.getSort().equals("price_desc")) {
                customView.setText("价格(降序)");
            } else {
                customView.setText("价格(升序)");
            }
        }
        bind.pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        if (tab.getPosition() == 2) {
            PinLeiFragment fragment = (PinLeiFragment) list.get(2);
            TextView customView = (TextView) tab.getCustomView();
            customView.setText("价格");
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab.getPosition() == 2) {
            PinLeiFragment fragment = (PinLeiFragment) list.get(2);
            String sort = fragment.getSort();
            TextView customView = (TextView) tab.getCustomView();
            if (sort.equals("price_desc")) {
                customView.setText("价格(升序)");
                fragment.setSort("price_asc");
            } else {
                customView.setText("价格(降序)");
                fragment.setSort("price_desc");
            }
            fragment.reload();
        }
    }
    public void toogleStyle(View v){
        for (int i = 0; i < list.size(); i++) {
            PinLeiFragment fragment = (PinLeiFragment) list.get(i);
            fragment.toogle();
        }
    }
}
