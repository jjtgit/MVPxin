package com.example.lianmvp.contract;

import com.example.lianmvp.bean.UserBean;
import com.example.lianmvp.net.ResponceCallBack;

import java.util.HashMap;

public interface ILogincontract {
    public abstract class ILogpresenter{
        public abstract void login(HashMap<String,String> map);
        public abstract void reg(HashMap<String,String> map);
    }
    public interface ILoginModel{
        void setokhttp(HashMap<String,String> map, String string, ResponceCallBack callBack);
    }
    public interface ILoginView{
        public void success(UserBean userBean);
        public void fail(String string);
        public void mobileerror(String error);
    }
}
