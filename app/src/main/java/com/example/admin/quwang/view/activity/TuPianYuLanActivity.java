package com.example.admin.quwang.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.TuPianYuLanPagerAdapter;
import com.example.admin.quwang.databinding.ActivityTuPianYuLanBinding;
import com.example.admin.quwang.view.fragment.TuPianYuLanFragment;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


public class TuPianYuLanActivity extends BaseActivity<ActivityTuPianYuLanBinding> {


    private String[] imgses;
    private String img;
    private List<Fragment> list;

    @Override
    protected void initImpl() {
        bind.setAdapter(initAdapter());
        bind.setPosition(getCurrentPosition());
    }

    private PagerAdapter initAdapter() {
        Intent intent = getIntent();
        imgses = intent.getStringArrayExtra("imgs");
        img = intent.getStringExtra("img");
        list = new ArrayList<>();
        PagerAdapter adapter = null;
        for (int i = 0; i < imgses.length; i++) {
            list.add(new TuPianYuLanFragment().newInstance(imgses[i]));
        }
        adapter = new TuPianYuLanPagerAdapter(list, getSupportFragmentManager());
        return adapter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_tu_pian_yu_lan;
    }
    public Integer getCurrentPosition() {
        int position=0;
        for (int i = 0; i < imgses.length; i++) {
            if(img.equals(imgses[i])){
                position=i;
                break;
            }
        }
        return position;
    }
}
