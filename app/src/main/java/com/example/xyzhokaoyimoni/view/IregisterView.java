package com.example.xyzhokaoyimoni.view;

import com.example.xyzhokaoyimoni.entity.UserEntity;

public interface IregisterView {
    void mobileError(String msg);
    void pwdError(String msg);
    void failure(String msg);
    void successMsg(String msg);
    void success(UserEntity userEntity);
}
