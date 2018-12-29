package com.example.lianmvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianmvp.R;
import com.example.lianmvp.bean.UserBean;
import com.example.lianmvp.contract.ILogincontract;
import com.example.lianmvp.presenter.LogPresenter;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements ILogincontract.ILoginView {

    private EditText ed_phone;
    private EditText ed_pwd;
    private Button btn_zc;
    private LogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        ed_pwd = (EditText) findViewById(R.id.ed_pwd);
        btn_zc = (Button) findViewById(R.id.btn_zc);
        presenter = new LogPresenter(this);
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map=new HashMap<>();
                map.put("mobile",ed_phone.getText().toString());
                map.put("password",ed_pwd.getText().toString());
                presenter.reg(map);
            }
        });

    }

    @Override
    public void success(UserBean userBean) {
        Toast.makeText(RegActivity.this,userBean.getMsg()+"",Toast.LENGTH_SHORT).show();
        if (userBean.getMsg().equals("注册成功")){
            Intent intent=new Intent(RegActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void fail(String string) {
        Toast.makeText(RegActivity.this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mobileerror(String error) {
        Toast.makeText(RegActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
