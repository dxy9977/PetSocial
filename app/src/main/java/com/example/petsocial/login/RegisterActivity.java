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
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.mvp.contract.RegisterContract;
import com.example.petsocial.mvp.presenter.RegisterPresenter;
import com.example.petsocial.ui.SelectActivity;
import com.example.petsocial.util.base.BaseMvpActivity;
import com.gyf.immersionbar.ImmersionBar;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterContract.View, TextWatcher {

    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.register_getcode)
    Button registerGetcode;
    @BindView(R.id.register_newpsd)
    EditText registerNewpsd;
    @BindView(R.id.register_cb)
    CheckBox registerCb;
    @BindView(R.id.register_submit)
    Button registerSubmit;

    private Disposable disposable;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        mPresenter = new RegisterPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        registerPhone.addTextChangedListener(this);
        registerNewpsd.addTextChangedListener(this);
        registerCode.addTextChangedListener(this);
    }


    public void btnBack(View view) {
        finish();
    }

    @Override
    public void showMessage(String meg) {

    }

    @Override
    public void onSucess() {
        startActivity(new Intent(this, SelectActivity.class));
        finish();
    }

    @Override
    public String getPhone() {
        return registerPhone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return registerCode.getText().toString().trim();
    }

    @Override
    public String getNewPsd() {
        return registerNewpsd.getText().toString().trim();
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


    @OnClick({R.id.register_getcode, R.id.register_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_getcode:
                if (RegexUtils.isMobileExact(getPhone())) {
                    registerGetcode.setEnabled(false);
                    mPresenter.getCode();
                    setCodeStatus();
                } else {
                    ToastUtils.showShort("手机号输入有误");
                }
                break;
            case R.id.register_submit:
                mPresenter.register();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getCode()) || TextUtils.isEmpty(getNewPsd())) {
            registerSubmit.setBackground(getDrawable(R.drawable.login_btn_bg));
            registerSubmit.setTextColor(Color.parseColor("#c3c3c3"));
            registerSubmit.setEnabled(false);
        } else {
            registerSubmit.setBackground(getDrawable(R.drawable.login_btn_bg1));
            registerSubmit.setTextColor(Color.parseColor("#333333"));
            registerSubmit.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void setCodeStatus() {
        disposable = Flowable.intervalRange(0, 60, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(l ->
                        registerGetcode.setText((60 - l) + " s")
                )
                .doOnComplete(() -> {
                    registerGetcode.setEnabled(true);
                    registerGetcode.setText("获取验证码");
                }).subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
