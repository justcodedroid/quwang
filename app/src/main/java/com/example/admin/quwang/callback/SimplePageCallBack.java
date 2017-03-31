package com.example.admin.quwang.callback;

import com.example.admin.quwang.bean.PingJiaBean;
import com.example.admin.quwang.http.HttpModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/3/30.
 */

public class  SimplePageCallBack <T> implements Callback<List<T>> {
    private  int page;
    OnLoadFinishListenr<List<T>> listenr;

    public SimplePageCallBack(OnLoadFinishListenr<List<T>> listenr,int page) {
        this.listenr = listenr;
        this.page=page;
    }

    @Override
    public void onResponse(Call<List<T>> call, Response<List<T>> response) {

        if (response.isSuccessful()) {
            List<T> body = response.body();
            listenr.onSuccess(body,getNormalType(body,page));
        } else {
            try {
                listenr.onError(response.errorBody().string(), response.code());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<List<T>> call, Throwable t) {
        listenr.onError(t.getMessage(),getErrorType(page));
    }

    private  int getErrorType(int page)
    {
        if (page == 1) {
            return HttpModel.RELASHFAILED;
        }
        if (page > 1) {
            return HttpModel.LOADDATAFAILED;
        }
        return HttpModel.APIERROR;
    }
    private  int getNormalType(List list, int page) {
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

    private  boolean isEmpry(List list) {
        return list == null || list.size() == 0;
    }
}
