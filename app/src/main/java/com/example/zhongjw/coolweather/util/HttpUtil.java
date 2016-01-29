package com.example.zhongjw.coolweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhongjw on 2016/1/29.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address,final HttpCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try{
                    URL url = new URL(address);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    InputStream in = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while((line=bufferedReader.readLine())!=null){
                        stringBuffer.append(line);
                    }
                    if(listener!=null){
                        listener.onFinish(stringBuffer.toString());
                    }
                }catch (Exception e){
                    if (listener!=null){
                        listener.onError(e);
                    }
                }finally {
                    if(httpURLConnection!=null){
                        httpURLConnection.disconnect();
                    }
                }
            }
        }).start();
    }
}