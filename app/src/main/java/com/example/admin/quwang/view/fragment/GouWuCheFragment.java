package com.example.admin.quwang.view.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.admin.quwang.R;
import com.example.admin.quwang.adapter.GouWuCheAdapter;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.bean.Pay;
import com.example.admin.quwang.bean.PayBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.databinding.FragmentGouwucheBinding;
import com.example.admin.quwang.presenter.GouWuChePresenter;
import com.example.admin.quwang.utils.HttpUtils;
import com.example.admin.quwang.view.GouWuCheView;
import com.example.admin.quwang.view.dialog.LoadingDialog;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by admin on 2017/3/26.
 */

public class GouWuCheFragment extends BaseFragment<FragmentGouwucheBinding> implements GouWuCheView, View.OnClickListener, GouWuCheAdapter.OnCheckedListner {

    private GouWuChePresenter gouWuChePresenter;
    private LoadingDialog dialog;
    private GouWuCheAdapter gouWuCheAdapter;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            Map<String,String> map = (Map<String, String>) msg.obj;
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> v:entries
            ){
                Toast.makeText(a, ""+v.getKey()+"-->"+v.getValue(), Toast.LENGTH_LONG).show();
            }
        }
        ;
    };
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gouwuche;
    }

    @Override
    protected void initImpl() {
        gouWuChePresenter = new GouWuChePresenter();
        gouWuChePresenter.setGouWuCheView(this);
        gouWuChePresenter.getGouWuChe();
        bind.quanuan.setOnClickListener(this);
        dialog = new LoadingDialog(a);
        bind.jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.createOrder(gouWuCheAdapter.getIds(), new OnLoadFinishListenr<PayBean>() {
                    @Override
                    public void onSuccess(PayBean bean, int type) {

                        HttpUtils.pay(bean.getData().getOrder_sn(), new OnLoadFinishListenr<Pay>() {
                            @Override
                            public void onSuccess(final Pay bean, int type) {
                                Log.e("asda",URLDecoder.decode(bean.getData().getAlipay_string()));
                                Runnable payRunnable = new Runnable() {

                                    @Override
                                    public void run() {
                                        PayTask alipay = new PayTask(a);
                                        Map<String, String> result = alipay.payV2(bean.getData().getAlipay_string(),true);
//
                                        Message msg = new Message();
                                        msg.what = 10;
                                        msg.obj = result;
                                        mHandler.sendMessage(msg);
                                    }
                                };
                                Thread payThread = new Thread(payRunnable);
                                payThread.start();
                            }

                            @Override
                            public void onError(String msg, int errorCode) {
                                Toast.makeText(a, "" + msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(String msg, int errorCode) {
                        Log.e("trag", msg);
                        Toast.makeText(a, "失败" + msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onRetryClick() {
        gouWuChePresenter.getGouWuChe();
    }

    @Override
    public void showNoData() {
        bind.nodatTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void relashGouWuChe(GouWuCheBean gouWuCheBean) {
        bind.nodatTv.setVisibility(View.GONE);
        List<GouWuCheBean.DataBean.CartsListBean> carts_list = gouWuCheBean.getData().getCarts_list();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(a, 1);
        bind.recycler.setLayoutManager(gridLayoutManager);
        gouWuCheAdapter = new GouWuCheAdapter(a, gridLayoutManager, gouWuChePresenter);
        gouWuCheAdapter.setOnCkeckedListener(this);
        gouWuCheAdapter.relashDataList(carts_list);
        bind.recycler.setAdapter(gouWuCheAdapter);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(a, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingDialog() {
        dialog.show();
    }

    @Override
    public void dissmissLoadingDialog() {
        dialog.dismiss();
    }

    @Override
    public void deleteSuccess(int recid) {
        gouWuCheAdapter.delete(recid);
    }

    @Override
    public void add(int recid) {
        gouWuCheAdapter.update(recid, "add");
    }

    @Override
    public void min(int recid) {
        gouWuCheAdapter.update(recid, "min");
    }


    @Override
    public void onClick(View v) {
        gouWuCheAdapter.quanxuan(bind.quanuan.isChecked());
    }

    @Override
    public void relashNumber(boolean isall, float price) {
        bind.quanuan.setChecked(isall);
        bind.jiesuan.setEnabled(price > 0);
        bind.priceTv.setText("总金额:" + price);
    }
}
