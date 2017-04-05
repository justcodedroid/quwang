package com.example.admin.quwang.utils;

import android.util.Log;

import com.example.admin.quwang.bean.AddCaetBean;
import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.CategoryList;
import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.bean.FaXianBean;
import com.example.admin.quwang.bean.GoodsAttrBean;
import com.example.admin.quwang.bean.GouWuCheBean;
import com.example.admin.quwang.bean.Pay;
import com.example.admin.quwang.bean.PayBean;
import com.example.admin.quwang.bean.PinLeiBean;
import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.bean.PingJianResultBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.bean.ShouCangBean;
import com.example.admin.quwang.bean.ShouYeBean;
import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.callback.SimpleCallBack;
import com.example.admin.quwang.http.AddGouWuCheService;
import com.example.admin.quwang.http.AllCatrgoryService;
import com.example.admin.quwang.http.DetailsService;
import com.example.admin.quwang.http.FaXianSerevice;
import com.example.admin.quwang.http.GoodsAttrService;
import com.example.admin.quwang.http.GouWuCheService;
import com.example.admin.quwang.http.HeadsInterceptor;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.http.OrderService;
import com.example.admin.quwang.http.PayService;
import com.example.admin.quwang.http.PeiLeiService;
import com.example.admin.quwang.http.PingJiaService;
import com.example.admin.quwang.http.ShangPinService;
import com.example.admin.quwang.http.ShouCangService;
import com.example.admin.quwang.http.ShouYeService;
import com.example.admin.quwang.http.UpdateGouWuCheService;
import com.example.admin.quwang.http.WebService;
import com.example.admin.quwang.http.WelcomeService;
import com.example.admin.quwang.http.XiangQingImageBeanService;
import com.example.admin.quwang.http.XiangQingParameterService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * Created by admin on 2017/3/25.
 */

public class HttpUtils {
    private static Retrofit retrofit;

    static {
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new HeadsInterceptor()).build();
        retrofit = new Retrofit.Builder().baseUrl(HttpModel.LOCAL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static void loadWelComdeBean(final OnLoadFinishListenr<WelcomeBean> listenr) {
        retrofit.create(WelcomeService.class).getWelcome().enqueue(new SimpleCallBack<WelcomeBean>(listenr));
    }

    public static void LoadShouYeBean(final OnLoadFinishListenr<ShouYeBean> listenr) {
        retrofit.create(ShouYeService.class).getShouYe().enqueue(new SimpleCallBack<ShouYeBean>(listenr));
    }

    public static void loadDeatilsBean(int id, final OnLoadFinishListenr<DetailsBean> loadDataFinishListener) {
        retrofit.create(DetailsService.class).getDetails(id + "").enqueue(new SimpleCallBack<DetailsBean>(loadDataFinishListener));
    }

    public static void loadWebResultBean(String topicId, final OnLoadFinishListenr<WebResultBean> onLoadFinishListenr) {
        retrofit.create(WebService.class).getWebResultBean(topicId).enqueue(new SimpleCallBack<WebResultBean>(onLoadFinishListenr));
    }

    public static void loadXiangQingParameterBeans(int goodsId, final OnLoadFinishListenr<XiangQingResultBean> onLoadFinishListenr) {
        retrofit.create(XiangQingParameterService.class).loadXiangQingParameterBeans(goodsId).enqueue(new SimpleCallBack<XiangQingResultBean>(onLoadFinishListenr));
    }

    public static void loadXiangQingImageBeans(int goodsId, final OnLoadFinishListenr<XiangQingImageResultBean> onLoadFinishListenr) {
        retrofit.create(XiangQingImageBeanService.class).loadXiangQingImageResultBeans(goodsId).enqueue(new SimpleCallBack<XiangQingImageResultBean>(onLoadFinishListenr));
    }

    public static void loadShangPinXiangQingBean(int goodsId, int special_id, int special_type, final OnLoadFinishListenr<BaseBean<ShangPinXiangQingBean>> onLoadFinishListenr) {
        retrofit.create(ShangPinService.class).loadShangPinXiangQingBean(goodsId, special_id, special_type).enqueue(new SimpleCallBack<BaseBean<ShangPinXiangQingBean>>(onLoadFinishListenr));
    }


    public static void loadPingJiaResultBean(int goods_id, final int page, final OnLoadFinishListenr<List<PingJiaBean>> loadFinishListenr) {
        retrofit.create(PingJiaService.class).getPingJiaResultBean(goods_id, page).enqueue(new Callback<PingJianResultBean>() {
            @Override
            public void onResponse(Call<PingJianResultBean> call, Response<PingJianResultBean> response) {

                if (response.isSuccessful()) {
                    List<PingJiaBean> comment_list = response.body().getData().getComment_list();
                    loadFinishListenr.onSuccess(comment_list, getNormalType(comment_list, page));
                } else {
                    try {
                        loadFinishListenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<PingJianResultBean> call, Throwable t) {

                loadFinishListenr.onError(t.getMessage(), getErrorType(page));
            }
        });
    }

    private static int getErrorType(int page) {
        if (page == 1) {
            return HttpModel.RELASHFAILED;
        }
        if (page > 1) {
            return HttpModel.LOADDATAFAILED;
        }
        return HttpModel.APIERROR;
    }

    public static int getNormalType(List list, int page) {
        boolean empry = isEmpry(list);

        if (empry && page == 1) {
            // 下来刷新就没有数据
            return HttpModel.NOINITDATA;
        }
        if (empry && page > 1) {
            // 没有更多数据
            return HttpModel.NOLOADDATA;
        }
        if (!empry && page == 1) {
            return HttpModel.RELASHSUCCESS;
        }
        if (!empry && page >= 1) {
            return HttpModel.LOADDATASUCCESS;
        }
        return HttpModel.APIERROR;
    }

    private static boolean isEmpry(List list) {
        return list == null || list.size() == 0;
    }

    public static void loadPinLeiBean(String type, String sort, int ad_id, int page, Map<String, String> map, OnLoadFinishListenr<BaseBean<PinLeiBean>> listenr) {
        retrofit.create(PeiLeiService.class).getPinLeiBea(type, sort, ad_id, page, map).enqueue(new SimpleCallBack<BaseBean<PinLeiBean>>(listenr));
    }

    public static void loadAllCategoryBeans(OnLoadFinishListenr<BaseBean<CategoryList>> onLoadFinishListenr) {
        retrofit.create(AllCatrgoryService.class).getAllCategortBeans().enqueue(new SimpleCallBack<BaseBean<CategoryList>>(onLoadFinishListenr));
    }

    public static void loadFaXianBean(OnLoadFinishListenr<FaXianBean> onLoadFinishListenr) {
        retrofit.create(FaXianSerevice.class).getFaXianBean().enqueue(new SimpleCallBack<FaXianBean>(onLoadFinishListenr));
    }

    public static void shouCang(int goodsId, OnLoadFinishListenr<ShouCangBean> onLoadFinishListenr) {
        retrofit.create(ShouCangService.class).shouCang(goodsId).enqueue(new SimpleCallBack<ShouCangBean>(onLoadFinishListenr));
    }

    public static void addGouWuChe(int goods_id, int specid, int goods_number, String action, int special_type, int special_id, int zt_id, int referer_type, OnLoadFinishListenr<AddCaetBean> onLoadFinishListenr) {
        retrofit.create(AddGouWuCheService.class).add(goods_id, specid, goods_number, action, special_type, special_id, zt_id, referer_type).enqueue(new SimpleCallBack<AddCaetBean>(onLoadFinishListenr));
    }

    public static void getGoodsAttr(int goods_id, OnLoadFinishListenr<GoodsAttrBean> onLoadFinishListenr) {
        retrofit.create(GoodsAttrService.class).getGoodsAttr(goods_id).enqueue(new SimpleCallBack<GoodsAttrBean>(onLoadFinishListenr));
    }

    public static void getGouWuChe(OnLoadFinishListenr<GouWuCheBean> onLoadFinishListenr) {
        retrofit.create(GouWuCheService.class).getGouWuChe().enqueue(new SimpleCallBack<GouWuCheBean>(onLoadFinishListenr));
    }

    public static void deleteWouWuChe(int recId, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        retrofit.create(GouWuCheService.class).delete(recId).enqueue(new SimpleCallBack<BaseBean<Object>>(listenr));
    }

    public static void increaseGouWuChe(int recId, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        retrofit.create(UpdateGouWuCheService.class).update(recId, "increase").enqueue(new SimpleCallBack<BaseBean<Object>>(listenr));
    }

    public static void decreaseGouWuChe(int recId, OnLoadFinishListenr<BaseBean<Object>> listenr) {
        retrofit.create(UpdateGouWuCheService.class).update(recId, "decrease").enqueue(new SimpleCallBack<BaseBean<Object>>(listenr));
    }

    public static void createOrder(String ids, OnLoadFinishListenr<PayBean> listenr) {
        retrofit.create(OrderService.class).get(ids, 9099686, "alipay").enqueue(new SimpleCallBack<PayBean>(listenr));
    }

    public static void pay(long sign, OnLoadFinishListenr<Pay> listenr) {
        retrofit.create(PayService.class).getPay(sign).enqueue(new SimpleCallBack<Pay>(listenr));
    }

}