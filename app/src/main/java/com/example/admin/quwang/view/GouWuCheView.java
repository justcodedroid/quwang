package com.example.admin.quwang.view;

import com.example.admin.quwang.bean.GouWuCheBean;

/**
 * Created by admin on 2017/4/5.
 */

public interface GouWuCheView extends BaseView {
    void showNoData();
    void relashGouWuChe(GouWuCheBean gouWuCheBean);
    void showMessage(String msg);
    void showLoadingDialog();
    void dissmissLoadingDialog();

    void deleteSuccess(int recid);

    void add(int recid);

    void min(int recid);
}
