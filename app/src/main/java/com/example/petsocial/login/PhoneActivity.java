package com.example.petsocial.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.mvp.contract.PhoneContract;
import com.example.petsocial.mvp.presenter.PhonePresenter;
import com.example.petsocial.ui.SelectActivity;
import com.example.petsocial.util.base.BaseMvpActivity;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneActivity extends BaseMvpActivity<PhonePresenter> implements PhoneContract.View, TextWatcher {

    @BindView(R.id.phone_phone)
    EditText phonePhone;
    @BindView(R.id.phone_code)
    EditText phoneCode;
    @BindView(R.id.phone_getcode)
    Button phoneGetcode;
    @BindView(R.id.phone_submit)
    Button phoneSubmit;


    public void btnLogin(View view) {
        startActivity(new Intent(this, SelectActivity.class));
        finish();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_phone;
    }

    @Override
    public void initView() {
        mPresenter = new PhonePresenter();
        mPresenter.attachView(this);

        ImmersionBar.with(this).statusBarDarkFont(true).init();
        phonePhone.addTextChangedListener(this);
        phoneCode.addTextChangedListener(this);
    }


    public void btnBack(View view) {
        finish();
    }

    @Override
    public void showMeg(String msg) {

    }

    @Override
    public String getPhone() {
        return phonePhone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return phoneCode.getText().toString().trim();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    public void btnRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }


    private CountDownTimer cdTimer = new CountDownTimer(60300, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            phoneGetcode.setText(millisUntilFinished / 1000 + " s");
            phoneGetcode.setClickable(false);
        }

        @Override
        public void onFinish() {
            phoneGetcode.setClickable(true);
            phoneGetcode.setText("重新获取");
        }
    };


    @OnClick({R.id.phone_getcode, R.id.phone_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_getcode:
                if (RegexUtils.isMobileExact(getPhone())) {
                    cdTimer.start();
                    //mPresenter.getCode();
                } else {
                    ToastUtils.showShort("手机号输入有误");
                }
                break;
            case R.id.phone_submit:
                //mPresenter.checkLogin();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cdTimer != null) {
            cdTimer.cancel();
            cdTimer = null;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getCode())) {
            phoneSubmit.setBackground(getDrawable(R.drawable.login_btn_bg));
            phoneSubmit.setTextColor(Color.parseColor("#c3c3c3"));
            phoneSubmit.setEnabled(false);
        } else {
            phoneSubmit.setBackground(getDrawable(R.drawable.login_btn_bg1));
            phoneSubmit.setTextColor(Color.parseColor("#333333"));
            phoneSubmit.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
