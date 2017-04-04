package com.example.admin.quwang.view.activity;

import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.ShangPinXiangQingAdapter;
import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.bean.GoodsInfo;
import com.example.admin.quwang.databinding.ActivityShangPinXiangQingBinding;
import com.example.admin.quwang.presenter.AddGouWuChePresenter;
import com.example.admin.quwang.presenter.GoodsAttrPresenter;
import com.example.admin.quwang.presenter.ShangPinXiangQingPresenter;
import com.example.admin.quwang.view.GoodsAttrView;
import com.example.admin.quwang.view.ShangPinXiangQingView;
import com.example.admin.quwang.view.dialog.ChooseGoodsAttrDialog;
import com.example.admin.quwang.view.dialog.LoadingDialog;
import com.example.admin.quwang.view.extend.DragToDetailsLayout;

import java.util.List;

public class ShangPinXiangQingActivity extends BaseActivity<ActivityShangPinXiangQingBinding> implements ShangPinXiangQingView, DragToDetailsLayout.OnToggleListener, ValueAnimator.AnimatorUpdateListener, GoodsAttrView, ChooseGoodsAttrDialog.OnChooseListener {

    private ShangPinXiangQingPresenter shangPinXiangQingPresenter;
    private ValueAnimator toggleAnimator;
    private int collectionId;
    private int goods_id;
    private GoodsInfo goodsInfo;
    private AddGouWuChePresenter addGouWuChePresenter;
    LoadingDialog loading;
    private GoodsAttrPresenter goodsAttrPresenter;
    private ChooseGoodsAttrDialog attrDialog;

    @Override
    protected void initImpl() {
        attrDialog = new ChooseGoodsAttrDialog(this);
        attrDialog.setOnChooseListener(this);
        loading = new LoadingDialog(this);
        goods_id = getIntent().getIntExtra("goods_id", 0);
        int special_id = getIntent().getIntExtra("special_id", 0);
        int special_type = getIntent().getIntExtra("special_type", 0);
        shangPinXiangQingPresenter = new ShangPinXiangQingPresenter();
        shangPinXiangQingPresenter.setShangPinXiangQingView(this);
        shangPinXiangQingPresenter.loadShangPinXiangQingFragments(goods_id, special_id, special_type);
        addGouWuChePresenter = new AddGouWuChePresenter();
        addGouWuChePresenter.setXiangQingView(this);
        goodsAttrPresenter = new GoodsAttrPresenter();
        goodsAttrPresenter.setGoodsAttrView(this);
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
    public void shoucangSuccess(String msg, String collectionId) {
        setChecked(true);
        Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
        this.collectionId = Integer.parseInt(collectionId);
    }

    @Override
    public void shoucangFailed(String msg) {
        Toast.makeText(this, "收藏失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void shouGouWuChe(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingDialog() {
        loading.show();
    }

    @Override
    public void dismissLoadingDialog() {
        loading.dismiss();
    }

    @Override
    public void showGoodsAttrError(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void relashGoodsAttr(GoodsAttrBean goodsAttrBean) {
        attrDialog.setListBeen(goodsAttrBean.getData().getStandard().getStandard_list());
        attrDialog.show();
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

    public void toogleStyle(View v) {

    }

    public void shoucang(View v) {
        Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        if (!bind.shoucangRB.isChecked()) {
            shangPinXiangQingPresenter.shouCang(goods_id);
        }
    }

    public void setChecked(boolean b) {
        bind.shoucangRB.setChecked(b);
    }

    public void setCollectionId(int collection_id) {
        this.collectionId = collection_id;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public void addGouWuChe(View v) {
        if (goodsInfo == null) return;
        if (goodsInfo.getIs_special() == 1) {
            // 特价
            addGouWuChePresenter.addGouWuche(goodsInfo.getGoods_id(), 0, 1, "special", goodsInfo.getSpecial_type(), goodsInfo.getSpecial_id(), goodsInfo.getZt_id(), goodsInfo.getReferer_type());
        } else {
            goodsAttrPresenter.loadGoodsAttr(goods_id);
        }
    }

    @Override
    public void onChoose(int specid, int goodsNum) {
        addGouWuChePresenter.addGouWuche(goodsInfo.getGoods_id(), specid, goodsNum, "add", goodsInfo.getSpecial_type(), goodsInfo.getSpecial_id(), goodsInfo.getZt_id(), goodsInfo.getReferer_type());

    }
}


