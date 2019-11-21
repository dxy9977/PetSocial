package com.example.petsocial.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.petsocial.R;
import com.example.petsocial.ui.BaseActivity;
import com.example.petsocial.ui.SelectActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLogin(View view) {
        startActivity(new Intent(this, SelectActivity.class));
    }

    public void btnRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void btnPhoneLogin(View view) {
        startActivity(new Intent(this, PhoneActivity.class));
    }

    public void forgetPsd(View view) {
        startActivity(new Intent(this, ForgetActivity.class));
    }
}
