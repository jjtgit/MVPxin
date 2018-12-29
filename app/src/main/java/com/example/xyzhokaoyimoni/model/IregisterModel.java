package com.example.xyzhokaoyimoni.model;

import com.example.xyzhokaoyimoni.net.RequestCallback;

import java.util.HashMap;

public interface IregisterModel {
    void login(HashMap<String,String> params, RequestCallback requestCallback);
}
