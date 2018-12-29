package com.example.xyzhokaoyimoni.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xyzhokaoyimoni.R;
import com.example.xyzhokaoyimoni.entity.UserEntity;
import com.example.xyzhokaoyimoni.presenter.RegisterPresenter;
import com.example.xyzhokaoyimoni.utils.ValidatorUtil;
import com.example.xyzhokaoyimoni.view.IregisterView;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements IregisterView {

    private EditText ed_phone;
    private EditText ed_pwd;
    private Button btn_zc;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();
    }
    private void initData() {
        presenter = new RegisterPresenter(this);
    }
    private void initView() {
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        ed_pwd = (EditText) findViewById(R.id.ed_pwd);
        btn_zc = (Button) findViewById(R.id.btn_zc);
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String moblie = ed_phone.getText().toString();
                String pwd = ed_pwd.getText().toString();
                HashMap<String,String> params=new HashMap<>();
                params.put("moblie",moblie);
                params.put("password",pwd);
                if (presenter!=null) {
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
    }
}
