package com.example.xyzhokaoyimoni.presenter;

import com.example.xyzhokaoyimoni.entity.UserEntity;
import com.example.xyzhokaoyimoni.model.LoginModel;
import com.example.xyzhokaoyimoni.net.RequestCallback;
import com.example.xyzhokaoyimoni.view.IregisterView;

import java.util.HashMap;

public class LoginPresenter {
    private LoginModel loginModel;
    private IregisterView iregisterView;
    public LoginPresenter(IregisterView iregisterView){
        this.loginModel=new LoginModel();
        this.iregisterView=iregisterView;
    }
    public void login(HashMap<String,String>params){
        if (loginModel!=null){
            loginModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iregisterView!=null){
                        iregisterView.failure(msg);
                    }
                }

                @Override
                public void successMsg(String msg) {
                    if (iregisterView!=null){
                        iregisterView.successMsg(msg);
                    }
                }

                @Override
                public void success(UserEntity userEntity) {
                    if (iregisterView!=null){
                        iregisterView.success(userEntity);
                    }
                }
            });
        }
    }
}
