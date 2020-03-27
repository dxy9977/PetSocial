package com.example.petsocial.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.mvp.contract.MainContract;
import com.example.petsocial.mvp.presenter.MainPresenter;
import com.example.petsocial.ui.MainShowActivity;
import com.example.petsocial.ui.SelectActivity;
import com.example.petsocial.util.base.BaseMvpActivity;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, TextWatcher {

    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btton)
    Button loginBtton;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        loginName.addTextChangedListener(this);
        loginPassword.addTextChangedListener(this);
    }


    public void btnLogin(View view) {
        mPresenter.checkLogin();
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


    @Override
    public String getName() {
        return loginName.getText().toString().trim();
    }

    @Override
    public String getPsd() {
        return loginPassword.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        showDialog();
    }

    @Override
    public void hideLoading() {
        closeDialog();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void showMessage(String meg) {
        ToastUtils.showShort(meg);
    }

    @Override
    public void success() {
        startActivity(new Intent(this, MainShowActivity.class));
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (TextUtils.isEmpty(getName()) || TextUtils.isEmpty(getPsd())) {
            loginBtton.setBackground(getDrawable(R.drawable.login_btn_bg));
            loginBtton.setTextColor(Color.parseColor("#c3c3c3"));
            loginBtton.setEnabled(false);
        } else {
            loginBtton.setBackground(getDrawable(R.drawable.login_btn_bg1));
            loginBtton.setTextColor(Color.parseColor("#333333"));
            loginBtton.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
