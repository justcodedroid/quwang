package com.example.admin.quwang.utils;

import android.util.Log;

import com.example.admin.quwang.bean.BaseBean;
import com.example.admin.quwang.bean.DetailsBean;
import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.bean.PingJianResultBean;
import com.example.admin.quwang.bean.ShangPinXiangQingBean;
import com.example.admin.quwang.bean.ShouYeBean;
import com.example.admin.quwang.bean.WebResultBean;
import com.example.admin.quwang.bean.WelcomeBean;
import com.example.admin.quwang.bean.XiangQingImageResultBean;
import com.example.admin.quwang.bean.XiangQingResultBean;
import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.http.DetailsService;
import com.example.admin.quwang.http.HeadsInterceptor;
import com.example.admin.quwang.http.HttpModel;
import com.example.admin.quwang.http.PingJiaService;
import com.example.admin.quwang.http.ShangPinService;
import com.example.admin.quwang.http.ShouYeService;
import com.example.admin.quwang.http.WebService;
import com.example.admin.quwang.http.WelcomeService;
import com.example.admin.quwang.http.XiangQingImageBeanService;
import com.example.admin.quwang.http.XiangQingParameterService;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        retrofit.create(WelcomeService.class).getWelcome().enqueue(new Callback<WelcomeBean>() {
            @Override
            public void onResponse(Call<WelcomeBean> call, Response<WelcomeBean> response) {
                boolean successful = response.isSuccessful();
                if (successful) {
                    listenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        listenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WelcomeBean> call, Throwable t) {
                listenr.onError(t.getMessage(), HttpModel.APIERROR);
            }
        });
    }

    public static void LoadShouYeBean(final OnLoadFinishListenr<ShouYeBean> listenr) {
        retrofit.create(ShouYeService.class).getShouYe().enqueue(new Callback<ShouYeBean>() {
            @Override
            public void onResponse(Call<ShouYeBean> call, Response<ShouYeBean> response) {
                if (response.isSuccessful()) {
                    listenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        listenr.onError(response.errorBody().string(), response.code());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ShouYeBean> call, Throwable t) {
                listenr.onError(t.getMessage(), HttpModel.APIERROR);
                t.printStackTrace();
            }
        });
    }

    public static void loadDeatilsBean(int id, final OnLoadFinishListenr<DetailsBean> loadDataFinishListener) {
        retrofit.create(DetailsService.class).getDetails(id + "").enqueue(new Callback<DetailsBean>() {
            @Override
            public void onResponse(Call<DetailsBean> call, Response<DetailsBean> response) {
                if (response.isSuccessful()) {
                    loadDataFinishListener.onSuccess(response.body(), 0);
                } else {
                    try {
                        String string = response.errorBody().string();
                        loadDataFinishListener.onError(string, response.code());
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }

            @Override
            public void onFailure(Call<DetailsBean> call, Throwable t) {
                loadDataFinishListener.onError(t.getMessage(), HttpModel.APIERROR);

            }
        });
    }

    public static void loadWebResultBean(String topicId, final OnLoadFinishListenr<WebResultBean> onLoadFinishListenr) {
        retrofit.create(WebService.class).getWebResultBean(topicId).enqueue(new Callback<WebResultBean>() {
            @Override
            public void onResponse(Call<WebResultBean> call, Response<WebResultBean> response) {
                boolean successful = response.isSuccessful();
                if (successful) {
                    onLoadFinishListenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        onLoadFinishListenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WebResultBean> call, Throwable t) {
                onLoadFinishListenr.onError(t.getMessage(), HttpModel.APIERROR);
            }
        });
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

    private static int getNormalType(List list, int page) {
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

    public static void loadXiangQingParameterBeans(int goodsId, final OnLoadFinishListenr<XiangQingResultBean> onLoadFinishListenr) {
        retrofit.create(XiangQingParameterService.class).loadXiangQingParameterBeans(goodsId).enqueue(new Callback<XiangQingResultBean>() {
            @Override
            public void onResponse(Call<XiangQingResultBean> call, Response<XiangQingResultBean> response) {
                if (response.isSuccessful()) {
                    onLoadFinishListenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        onLoadFinishListenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<XiangQingResultBean> call, Throwable t) {
                onLoadFinishListenr.onError(t.getMessage(), HttpModel.APIERROR);
            }
        });
    }

    public static void loadXiangQingImageBeans(int goodsId, final OnLoadFinishListenr<XiangQingImageResultBean> onLoadFinishListenr) {
        retrofit.create(XiangQingImageBeanService.class).loadXiangQingImageResultBeans(goodsId).enqueue(new Callback<XiangQingImageResultBean>() {
            @Override
            public void onResponse(Call<XiangQingImageResultBean> call, Response<XiangQingImageResultBean> response) {
                if (response.isSuccessful()) {
                    onLoadFinishListenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        onLoadFinishListenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<XiangQingImageResultBean> call, Throwable t) {
                onLoadFinishListenr.onError(t.getMessage(), HttpModel.APIERROR);
            }
        });
    }

    public static void loadShangPinXiangQingBean(int goodsId, int special_id, int special_type, final OnLoadFinishListenr<BaseBean<ShangPinXiangQingBean>> onLoadFinishListenr) {
        retrofit.create(ShangPinService.class).loadShangPinXiangQingBean(goodsId,special_id,special_type).enqueue(new Callback<BaseBean<ShangPinXiangQingBean>>() {
            @Override
            public void onResponse(Call<BaseBean<ShangPinXiangQingBean>> call, Response<BaseBean<ShangPinXiangQingBean>> response) {
                if (response.isSuccessful()) {
                    onLoadFinishListenr.onSuccess(response.body(), HttpModel.NORMAL);
                } else {
                    try {
                        onLoadFinishListenr.onError(response.errorBody().string(), response.code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseBean<ShangPinXiangQingBean>> call, Throwable t) {
                onLoadFinishListenr.onError(t.getMessage(), HttpModel.APIERROR);
                t.printStackTrace();
            }
        });
    }
}