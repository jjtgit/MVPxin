package com.example.xyzhokaoyimoni.presenter;

import com.example.xyzhokaoyimoni.entity.UserEntity;
import com.example.xyzhokaoyimoni.model.RegisterModel;
import com.example.xyzhokaoyimoni.net.RequestCallback;
import com.example.xyzhokaoyimoni.utils.ValidatorUtil;
import com.example.xyzhokaoyimoni.view.IregisterView;

import java.util.HashMap;

public class RegisterPresenter {
    private RegisterModel registerModel;
    private IregisterView iregisterView;
    public RegisterPresenter(IregisterView iregisterView){
        this.registerModel=new RegisterModel();
        this.iregisterView=iregisterView;
    }
    public  void login(HashMap<String,String> params){
        String ed_phone = params.get("moblie");
        String ed_pwd = params.get("password");
        if (!ValidatorUtil.isMobile(ed_phone)){
            if (iregisterView!=null){
                iregisterView.mobileError("请输入合法的手机号");
            }
            return;
        }
        if (registerModel!=null){
            registerModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iregisterView!=null)
                        iregisterView.failure(msg);

                }

                @Override
                public void successMsg(String msg) {
                    if (iregisterView!=null)
                        iregisterView.successMsg(msg);
                }

                @Override
                public void success(UserEntity userEntity) {
                    if (iregisterView!=null)
                        iregisterView.success(userEntity);
                }
            });
        }
    }
}
