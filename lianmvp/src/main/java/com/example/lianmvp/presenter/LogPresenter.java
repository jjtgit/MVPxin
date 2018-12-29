package com.example.lianmvp.presenter;

import com.example.lianmvp.api.UserApi;
import com.example.lianmvp.bean.UserBean;
import com.example.lianmvp.contract.ILogincontract;
import com.example.lianmvp.model.LoginModel;
import com.example.lianmvp.net.ResponceCallBack;
import com.example.lianmvp.utils.ValidatorUtile;

import java.util.HashMap;

public class LogPresenter extends ILogincontract.ILogpresenter {
    private LoginModel loginModel;
    private ILogincontract.ILoginView iLoginView;
    public LogPresenter(ILogincontract.ILoginView iLoginView){
        loginModel=new LoginModel();
        this.iLoginView=iLoginView;
    }
    @Override
    public void login(HashMap<String, String> map) {
        String mobile = map.get("mobile");
        if (!ValidatorUtile.isMobile(mobile)){
            iLoginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_LOGIN, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean!=null){
                    iLoginView.success(userBean);
                }
            }

            @Override
            public void fail(String string) {
                    iLoginView.fail(string);
            }
        });
    }

    @Override
    public void reg(HashMap<String, String> map) {
        String mobile = map.get("mobile");
        if (!ValidatorUtile.isMobile(mobile)){
            iLoginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_REG, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean!=null){
                    iLoginView.success(userBean);
                }
            }

            @Override
            public void fail(String string) {
                iLoginView.fail(string);
            }
        });
    }
}
