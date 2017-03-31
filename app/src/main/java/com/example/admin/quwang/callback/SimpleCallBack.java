package com.example.admin.quwang.callback;

import com.example.admin.quwang.http.HttpModel;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/3/30.
 */

public class SimpleCallBack<T> implements Callback<T> {
    OnLoadFinishListenr<T> listenr;

    public SimpleCallBack(OnLoadFinishListenr<T> listenr) {
        this.listenr = listenr;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        boolean successful = response.isSuccessful();
        if(successful){
            listenr.onSuccess(response.body(),HttpModel.NORMAL);
        }else {
            try {
                listenr.onError(response.errorBody().string(),response.code());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        listenr.onError(t.getMessage(), HttpModel.APIERROR);
    }
}
