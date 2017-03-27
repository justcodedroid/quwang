package com.example.admin.quwang.callback;

/**
 * Created by admin on 2017/3/25.
 */

public interface OnLoadFinishListenr<T> {
    void onSuccess(T bean,int type);
    void onError(String msg,int errorCode);
}
