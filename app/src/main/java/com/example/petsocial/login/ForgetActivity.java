package com.example.petsocial.login;


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

import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.mvp.contract.ForgetContract;
import com.example.petsocial.mvp.presenter.ForgetPresenter;
import com.example.petsocial.util.base.BaseMvpActivity;
import com.gyf.immersionbar.ImmersionBar;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class ForgetActivity extends BaseMvpActivity<ForgetPresenter> implements ForgetContract.View, TextWatcher {

    @BindView(R.id.forget_phone)
    EditText forgetPhone;
    @BindView(R.id.forget_code)
    EditText forgetCode;
    @BindView(R.id.forget_getcode)
    Button forgetGetcode;
    @BindView(R.id.forget_submit)
    Button forgetSubmit;
    @BindView(R.id.forget_newpsd)
    EditText forgetNewpsd;

    private Disposable disposable;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    public void initView() {
        mPresenter = new ForgetPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        forgetPhone.addTextChangedListener(this);
        forgetCode.addTextChangedListener(this);
        forgetNewpsd.addTextChangedListener(this);
    }

    public void btnBack(View view) {
        finish();
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

    @Override
    public void showMessage(String meg) {
        ToastUtils.showShort(meg);
    }

    @Override
    public String getPhone() {
        return forgetPhone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return forgetCode.getText().toString().trim();
    }

    @Override
    public String getNewPsd() {
        return forgetNewpsd.getText().toString().trim();
    }

    @OnClick({R.id.forget_getcode, R.id.forget_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_getcode:
                if (RegexUtils.isMobileExact(getPhone())) {
                    //cdTimer.start();
                    setCodeStatus();
                    forgetGetcode.setEnabled(false);
                    //mPresenter.getCode();
                } else {
                    ToastUtils.showShort("手机号输入有误");
                }


                break;
            case R.id.forget_submit:
                //mPresenter.checkCode();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(getPhone()) || TextUtils.isEmpty(getCode()) || TextUtils.isEmpty(getNewPsd())) {
            forgetSubmit.setBackground(getDrawable(R.drawable.login_btn_bg));
            forgetSubmit.setTextColor(Color.parseColor("#c3c3c3"));
            forgetSubmit.setEnabled(false);
        } else {
            forgetSubmit.setBackground(getDrawable(R.drawable.login_btn_bg1));
            forgetSubmit.setTextColor(Color.parseColor("#333333"));
            forgetSubmit.setEnabled(true);
        }
    }


    private void setCodeStatus() {
        disposable = Flowable.intervalRange(0, 60, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(l ->
                        forgetGetcode.setText((60 - l) + " s")
                )
                .doOnComplete(() -> {
                    forgetGetcode.setEnabled(true);
                    forgetGetcode.setText("获取验证码");
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
