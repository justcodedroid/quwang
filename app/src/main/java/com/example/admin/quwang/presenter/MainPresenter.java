package com.example.admin.quwang.presenter;

import android.support.v4.app.Fragment;

import com.example.admin.quwang.callback.OnLoadFinishListenr;
import com.example.admin.quwang.model.MainModel;
import com.example.admin.quwang.model.MainModelImpl;
import com.example.admin.quwang.view.MainView;

import java.util.List;

/**
 * Created by admin on 2017/3/26.
 */

public class MainPresenter implements OnLoadFinishListenr<List<Fragment>> {
    MainModel mainModel=new MainModelImpl();
    private MainView mainView;

    public void setMainView(MainView mainView){
        this.mainView=mainView;
    }
    public void loadMainFragment(){
        mainModel.loadMainFragment(this);
    }

    @Override
    public void onSuccess(List<Fragment> bean, int type) {
        mainView.RelashData(bean);
    }

    @Override
    public void onError(String msg, int errorCode) {

    }
}
