package com.example.lianmvp.model;

import android.os.Handler;

import com.example.lianmvp.bean.UserBean;
import com.example.lianmvp.contract.ILogincontract;
import com.example.lianmvp.net.ResponceCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements ILogincontract.ILoginModel {
    Handler handler=new Handler();
    @Override
    public void setokhttp(HashMap<String, String> map, String string, final ResponceCallBack callBack) {
        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
        FormBody.Builder builder=new FormBody.Builder();
        for (Map.Entry<String,String> p:map.entrySet()){
            builder.add(p.getKey(),p.getValue());
        }
        //请求
        final Request request = new Request.Builder().url(string).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.fail("网络连接超时");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (200==response.code()){
                    getjson(result,callBack);
                }
            }
        });
    }
    private void getjson(String strring,final ResponceCallBack callBack) {
       final UserBean userBean = new Gson().fromJson(strring, UserBean.class);
       if (userBean!=null){
           handler.post(new Runnable() {
               @Override
               public void run() {
                   callBack.success(userBean);
               }
           });
       }
    }
}
