package com.example.zhongjw.coolweather.util;

/**
 * Created by zhongjw on 2016/1/29.
 */
public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
