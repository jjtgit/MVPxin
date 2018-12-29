package com.example.lianmvp.net;

import com.example.lianmvp.bean.UserBean;

public interface ResponceCallBack {
    void success(UserBean userBean);
    void fail(String string);
}
