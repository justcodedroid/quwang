package com.example.admin.quwang.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.quwang.http.HttpModel;

/**
 * Created by admin on 2017/3/29.
 */

public class ActivityRouter {
    public static void router(Context ctx, int type, String idOrUrl, int special_type, int special_idOrGoodsId) {

        switch (type) {
            case HttpModel.TYPEWEB:
                WebUtils.startWebActivity(ctx, idOrUrl);
                break;
            case HttpModel.TYPEPINLEILIEBIAO:
                PinLeiUtils.startPinLeiActivity(ctx, idOrUrl, special_idOrGoodsId);
                break;
            case HttpModel.TYPEOTHERWEB:
                WebUtils.startOtherWebActivity(ctx, idOrUrl);
                break;
            case HttpModel.TYPESHANGPINGXIANGQING:
                int goods_id;
                try {
                    goods_id = Integer.parseInt(idOrUrl);
                    ShangPinXiangQingUtils.startShangPingXiangQingActivity(ctx, goods_id, special_type, special_idOrGoodsId);
                } catch (Exception e) {
                    Toast.makeText(ctx, "在解析linkUrl跳转到商品详情时候，不是int类型" + idOrUrl, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Log.e("tag", "在ActvityRouter的时候,不能识别type");
                break;
        }

    }
}
