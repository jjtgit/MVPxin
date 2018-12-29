package com.example.lianmvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianmvp.MainActivity;
import com.example.lianmvp.R;
import com.example.lianmvp.bean.UserBean;
import com.example.lianmvp.contract.ILogincontract;
import com.example.lianmvp.presenter.LogPresenter;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements ILogincontract.ILoginView{

    private EditText mobile;
    private EditText password;
    private Button deng;
    private Button zc;
    private LogPresenter logPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }
    private void initData() {

    }

    private void initView() {
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        deng = (Button) findViewById(R.id.deng);
        zc = (Button) findViewById(R.id.zc);
        logPresenter = new LogPresenter(this);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map=new HashMap<>();
                map.put("mobile",mobile.getText().toString());
                map.put("password",password.getText().toString());
                logPresenter.login(map);
            }
        });
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void success(UserBean userBean) {
        Toast.makeText(LoginActivity.this,userBean.getMsg()+"",Toast.LENGTH_SHORT).show();
        if (userBean.getCode().equals("0")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void fail(String string) {
        Toast.makeText(LoginActivity.this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mobileerror(String error) {
        Toast.makeText(LoginActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
