package com.example.admin.quwang.view.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.bumptech.glide.Glide;
import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.BonusInfo;
import com.example.admin.quwang.bean.GoodsInfo;
import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.bean.RecommendGood;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.callback.AllPingJiaListener;
import com.example.admin.quwang.databinding.FragmentShangPinBinding;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.presenter.ShangPinPresenter;
import com.example.admin.quwang.utils.ActivityRouter;
import com.example.admin.quwang.utils.BannerUtils;
import com.example.admin.quwang.utils.HorizontalListViewUtils;
import com.example.admin.quwang.view.ShangPinView;
import com.example.admin.quwang.view.activity.TuPianYuLanActivity;
import com.example.admin.quwang.view.extend.Banner;
import com.example.admin.quwang.view.extend.BottomViewInter;
import com.example.admin.quwang.view.extend.DragToDetailsLayout;
import com.example.admin.quwang.view.extend.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */

public class ShangPinFragment extends BaseFragment<FragmentShangPinBinding> implements ShangPinView, Banner.OnItemClickListener, DragToDetailsLayout.OnFirstLoadListener, DragToDetailsLayout.OnToggleListener, HorizontalListView.OnItemClickListener {
    int goods_id;
    int special_type;
    int special_id;
    private ShangPinPresenter shangPinPresenter;
    private List<String> goodsGalleryList;
    private XiangQingFragment xiangQingFragment;
    DragToDetailsLayout.OnToggleListener onToggleListener;
    private List<RecommendGood> recommentGoodsList;

    public ShangPinFragment setGoods_id(int goods_id, int special_id, int special_type) {
        this.goods_id = goods_id;
        this.special_id = special_id;
        this.special_type = special_type;
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shang_pin;
    }

    @Override
    protected void initImpl() {
        bind.banner.setOnItemClickListener(this);
        bind.dragLayout.setOnFirstLoadListener(this);
        bind.dragLayout.setOnToggleListener(this);
        shangPinPresenter = new ShangPinPresenter();
        shangPinPresenter.setShangPinView(this);
        xiangQingFragment = new XiangQingFragment().setGoods_id(goods_id);
        shangPinPresenter.getShangPinXiangQingBean(goods_id, special_id, special_type);
        onToggleListener = (DragToDetailsLayout.OnToggleListener) a;
        bind.setPingjia(new AllPingJiaListener(a));

    }

    @Override
    public void relashGoodsGallery(List<String> goodsGalllery) {
        this.goodsGalleryList = goodsGalllery;
        final int indectorCount = goodsGalllery.size();
        BannerUtils.increateData(goodsGalllery);
        List<View> list = BannerUtils.convertGoodsGallery(goodsGalllery, a);
        bind.banner.setAdapter(new Banner.SimpleBannerAdapter(list) {
            @Override
            public int getIndectorCount() {
                return indectorCount;
            }
        });
    }

    @Override
    public void relashGoodsInfo(GoodsInfo goodsInfo) {
        bind.setGoodsinfo(goodsInfo);
        if (goodsInfo.getIs_special() == 0) return;
        if (goodsInfo.getRemaining_time() == 0) {
            bind.qiangou.setVisibility(View.GONE);
            return;
        }
        bind.timeView.setTime(goodsInfo.getRemaining_time());
        bind.timeView.startLoop();
    }

    @Override
    public void relashQuanBean(ShangPinXiangQingBean.BonusInfoGroup bonusInfoGroup) {
        if (bonusInfoGroup == null || (bonusInfoGroup.getAlready_receive() == null && bonusInfoGroup.getCan_receive() == null)) {
            bind.quan.setVisibility(View.GONE);
            return;
        }
        List<BonusInfo> temp = new ArrayList<>();
        temp.addAll(bonusInfoGroup.getAlready_receive());
        temp.addAll(bonusInfoGroup.getCan_receive());
        if (temp.size() == 0) {
            bind.quan.setVisibility(View.GONE);
        }
        bind.quan1.setText(temp.get(0).getType_name());
        if (temp.size() == 1) {
            bind.quan2.setVisibility(View.GONE);
            return;
        }
        bind.quan2.setText(temp.get(1).getType_name());
    }

    @Override
    public void relashPingJia(List<PingJiaBean> pingJiaBeanList, int commentCount) {
        if (pingJiaBeanList == null || pingJiaBeanList.size() == 0) return;
        bind.pingjia.setVisibility(View.VISIBLE);
        bind.pingjiashu.setText("商品评价(" + commentCount + ")");
        bind.onePingjia.setPingjia(pingJiaBeanList.get(0));

    }

    @Override
    public void relashTuiJian(List<RecommendGood> recommendGoodList) {
        if (recommendGoodList == null || recommendGoodList.size() == 0) return;
        this.recommentGoodsList = recommendGoodList;
        bind.tuijiangroup.setVisibility(View.VISIBLE);
        List<View> list = HorizontalListViewUtils.convertTuiJianViews(recommendGoodList, a);
        bind.tuijianLv.setAdapter(new HorizontalListView.SimpleHorizontalAdapter(list));
        bind.tuijianLv.setOnItemClickListener(this);
    }


    @Override
    public void onRetryClick() {
        super.onRetryClick();
        shangPinPresenter.getShangPinXiangQingBean(goods_id, special_id, special_type);
    }

    @Override
    public void onItemClick(Banner banner, View itemView, int position) {
        Intent intent = new Intent(a, TuPianYuLanActivity.class);
        String[] imgs = new String[goodsGalleryList.size()];
        goodsGalleryList.toArray(imgs);
        intent.putExtra("imgs", imgs);
        intent.putExtra("img", goodsGalleryList.get(position));
        startActivity(intent);
    }

    @Override
    public void onFirstLoad() {
        getFragmentManager().beginTransaction().replace(R.id.bottomFragmentGroup, xiangQingFragment).commit();
        bind.bottomFragmentGroup.post(new Runnable() {
            @Override
            public void run() {
                BottomViewInter bottomViewInter = (BottomViewInter) bind.bottomFragmentGroup.findViewById(R.id.imagesLv);
                bind.dragLayout.setBottomScroller(bottomViewInter);
            }
        });

    }

    @Override
    public void onUp() {
        bind.descTv.setText("继续拖动，返回商品详情");
        onToggleListener.onUp();
    }

    @Override
    public void onDown() {
        bind.descTv.setText("继续拖动，查看图文详情");
        onToggleListener.onDown();

    }

    @Override
    public void onItemClick(HorizontalScrollView horizontalScrollView, View itemView, int position) {
        RecommendGood recommendGood = recommentGoodsList.get(position);
        ActivityRouter.router(a, HttpModel.TYPESHANGPINGXIANGQING, recommendGood.getGoods_id() + "", 0, 0);
    }
}
