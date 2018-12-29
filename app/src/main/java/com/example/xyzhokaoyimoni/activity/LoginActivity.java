package com.example.xyzhokaoyimoni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xyzhokaoyimoni.R;
import com.example.xyzhokaoyimoni.entity.UserEntity;
import com.example.xyzhokaoyimoni.presenter.LoginPresenter;
import com.example.xyzhokaoyimoni.view.IregisterView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IregisterView {

    private EditText mobile;
    private EditText password;
    private Button deng;
    private Button zc;
    private LoginPresenter presenter;

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
        presenter = new LoginPresenter(this);
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobiles = mobile.getText().toString();
                String passwords = password.getText().toString();
                HashMap<String,String> params=new HashMap<>();
                params.put("mobile",mobiles);
                params.put("password",passwords);
                if (presenter!=null){
                    presenter.login(params);
                }
            }
        });
    }

    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.getMsg()+"",Toast.LENGTH_SHORT).show();
        if (userEntity.getMsg().equals("登录成功")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
