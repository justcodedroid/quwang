package com.example.admin.quwang.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.quwang.R;
import com.example.admin.quwang.databinding.ActivityPingJiaBinding;
import com.example.admin.quwang.view.fragment.PingJiaFragment;

public class PingJiaActivity extends BaseActivity<ActivityPingJiaBinding> {

    @Override
    protected void initImpl() {
        int goods_id = getIntent().getIntExtra("goods_id", 0);
        PingJiaFragment pingJiaFragment = new PingJiaFragment().setGoods_id(goods_id);
        replaceFragment(R.id.group, pingJiaFragment);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ping_jia;
    }
}
