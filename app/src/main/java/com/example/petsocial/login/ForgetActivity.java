package com.example.petsocial.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.petsocial.R;
import com.example.petsocial.ui.BaseActivity;

public class ForgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
    }

    public void btnBack(View view) {
    }

    public void getPhoneCode(View view) {
    }

    public void btnForget(View view) {
        Intent intent = new Intent();
        intent.setClass(this,ResetActivity.class);
        startActivity(intent);

    }
}
