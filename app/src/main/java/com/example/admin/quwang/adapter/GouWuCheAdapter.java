package com.example.admin.quwang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.admin.quwang.R;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.databinding.ItemGouwuchBinding;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.presenter.GouWuChePresenter;
import com.example.admin.quwang.utils.ActivityRouter;

import java.net.URLEncoder;

/**
 * Created by admin on 2017/4/5.
 */

public class GouWuCheAdapter extends BaseHeadAndFooterAdapter<GouWuCheBean.DataBean.CartsListBean, GouWuCheHolder> implements View.OnClickListener {
    private GouWuChePresenter presenter;
    private OnCheckedListner lietner;

    public GouWuCheAdapter(Context context, GridLayoutManager gm, GouWuChePresenter gouWuChePresenter) {
        super(context, gm);
        this.presenter = gouWuChePresenter;
    }


    @Override
    protected GouWuCheHolder onCreateViewHolderImpl(ViewGroup parent, int viewType) {
        GouWuCheHolder gouWuCheHolder = new GouWuCheHolder(ItemGouwuchBinding.inflate(inflater, parent, false));
        return gouWuCheHolder;
    }

    @Override
    protected void initListener(final GouWuCheHolder h, int position) {
        super.initListener(h, position);
        h.bind.delete.setTag(position);
        h.bind.delete.setOnClickListener(this);
        h.bind.addBTN.setTag(position);
        h.bind.addBTN.setOnClickListener(this);
        h.bind.minBTN.setTag(position);
        h.bind.minBTN.setOnClickListener(this);
        h.bind.cb.setTag(position);
        h.bind.cb.setOnClickListener(this);
        h.itemView.setTag(position);
        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = (int) h.itemView.getTag();
                GouWuCheBean.DataBean.CartsListBean cartsListBean = list.get(p);
                ActivityRouter.router(ctx, HttpModel.TYPESHANGPINGXIANGQING, cartsListBean.getGoods_id() + "", cartsListBean.getSpecial_type(), cartsListBean.getSpecial_id());
            }
        });
    }

    @Override
    protected int getItemViewTypeImpl(int position) {
        return 0;
    }

    @Override
    protected int getCurrentSpanCount(int position) {
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete:
                presenter.delete(list.get((Integer) v.getTag()).getRec_id());
                break;
            case R.id.addBTN:
                GouWuCheBean.DataBean.CartsListBean cartsListBean = list.get((Integer) v.getTag());
                presenter.add(cartsListBean.getRec_id());
                break;
            case R.id.minBTN:
                GouWuCheBean.DataBean.CartsListBean bean = list.get((Integer) v.getTag());
                int goods_number = bean.getGoods_number();
                if (goods_number <= 1) return;
                presenter.min(bean.getRec_id());
                break;
            case R.id.cb:
                int posiyion = (int) v.getTag();
                CheckBox cn = (CheckBox) v;
                list.get(posiyion).setChecked(cn.isChecked());
                if (lietner != null) {
                    relash();
                }
                break;
        }


    }

    private void relash() {
        boolean all = true;
        float price = 0;
        for (int i = 0; i < list.size(); i++) {
            GouWuCheBean.DataBean.CartsListBean cartsListBean = list.get(i);
            if (cartsListBean.isChecked()) {
                price += cartsListBean.getGoods_number() * cartsListBean.getApp_price();
            }
            if (!cartsListBean.isChecked()) {
                all = false;
            }
        }
        lietner.relashNumber(all, price);
    }

    public void delete(int recid) {
        for (int i = 0; i < list.size(); i++) {
            boolean b = list.get(i).getRec_id() == recid;
            if (b) {
                list.remove(i);
                notifyDataSetChanged();
                break;
            }
        }
        if (lietner != null) {
            relash();
        }

    }

    public void update(int rec_id, String action) {
        for (int i = 0; i < list.size(); i++) {
            boolean b = list.get(i).getRec_id() == rec_id;
            if (b) {
                if (action.equals("add")) {
                    list.get(i).setGoods_number(list.get(i).getGoods_number() + 1);
                } else {
                    list.get(i).setGoods_number(list.get(i).getGoods_number() - 1);
                }
                notifyDataSetChanged();
                break;
            }
        }
        if (lietner != null) {
            relash();
        }
    }

    public void quanxuan(boolean checked) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChecked(checked);
        }
        notifyDataSetChanged();
        if (lietner != null) {
            relash();
        }
    }

    public String getIds() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            GouWuCheBean.DataBean.CartsListBean cartsListBean = list.get(i);
            if (cartsListBean.isChecked()) {
                sb.append(cartsListBean.getRec_id() + ",");
            }
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring;
    }

    public interface OnCheckedListner {
        void relashNumber(boolean isall, float price);
    }

    public void setOnCkeckedListener(OnCheckedListner listener) {
        this.lietner = listener;
    }
}
