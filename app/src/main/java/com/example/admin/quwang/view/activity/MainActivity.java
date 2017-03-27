package com.example.admin.quwang.view.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.ActivityMain2Binding;
import com.example.admin.quwang.presenter.MainPresenter;
import com.example.admin.quwang.view.MainView;
import com.example.admin.quwang.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMain2Binding> implements MainView, View.OnClickListener {


    private MainPresenter presenter;
    private List<View> menulist;
    private List<Fragment> fragmentList;

    @Override
    protected void initImpl() {
        presenter = new MainPresenter();
        presenter.setMainView(this);
        presenter.loadMainFragment();
        initListener();
        bind.shouye.performClick();
    }

    private void initListener() {
        menulist = new ArrayList<>();
        menulist.add(bind.shouye);
        menulist.add(bind.faxian);
        menulist.add(bind.gouwuche);
        menulist.add(bind.wode);
        for (int i = 0; i < menulist.size(); i++) {
            menulist.get(i).setOnClickListener(this);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void RelashData(List<Fragment> list) {
        this.fragmentList = list;
    }

    @Override
    public void onClick(View v) {
        int viewPosition = findViewPosition(v);
        if (viewPosition != -1) {
            replaceFragment(R.id.fragment_group, fragmentList.get(viewPosition));
        }
    }

    private int findViewPosition(View v) {
        int position = -1;
        for (int i = 0; i < menulist.size(); i++) {
            if (menulist.get(i) == v) {
                position = i;
                break;
            }
        }
        return position;
    }
}
