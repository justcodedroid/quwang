package com.example.admin.quwang.view.activity;

import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;
import com.example.admin.quwang.databinding.ActivityShangPinXiangQingBinding;
import com.example.admin.quwang.presenter.ShangPinXiangQingPresenter;
import com.example.admin.quwang.view.ShangPinXiangQingView;
import com.example.admin.quwang.view.extend.DragToDetailsLayout;

import java.util.List;

public class ShangPinXiangQingActivity extends BaseActivity<ActivityShangPinXiangQingBinding> implements ShangPinXiangQingView, DragToDetailsLayout.OnToggleListener, ValueAnimator.AnimatorUpdateListener {

    private ShangPinXiangQingPresenter shangPinXiangQingPresenter;
    private ValueAnimator toggleAnimator;

    @Override
    protected void initImpl() {
        int goods_id = getIntent().getIntExtra("goods_id", 0);
        int special_id = getIntent().getIntExtra("special_id", 0);
        int special_type = getIntent().getIntExtra("special_type", 0);
        shangPinXiangQingPresenter = new ShangPinXiangQingPresenter();
        shangPinXiangQingPresenter.setShangPinXiangQingView(this);
        shangPinXiangQingPresenter.loadShangPinXiangQingFragments(goods_id, special_id, special_type);

        toggleAnimator = ValueAnimator.ofFloat();
        toggleAnimator.setDuration(200);
        toggleAnimator.setEvaluator(new FloatEvaluator());
        toggleAnimator.setInterpolator(new AccelerateInterpolator());
        toggleAnimator.addUpdateListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shang_pin_xiang_qing;
    }

    @Override
    public void relashShangPinXiangQingFragments(List<Fragment> list) {
        bind.pager.setAdapter(new ShangPinXiangQingAdapter(getSupportFragmentManager(), list));
        bind.tab.setupWithViewPager(bind.pager);
    }

    @Override
    public void onUp() {
        toggleAnimator.setFloatValues(bind.navigation.getScrollY(), bind.navigation.getHeight());
        toggleAnimator.start();
    }

    @Override
    public void onDown() {
        toggleAnimator.setFloatValues(bind.navigation.getScrollY(), 0);
        toggleAnimator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        bind.navigation.scrollTo(0, (int) value);
    }
}
