package com.example.petsocial.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.common.NetWorkManager;
import com.gyf.immersionbar.ImmersionBar;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.forget_psd)
    EditText forgetPsd;
    @BindView(R.id.forget_code)
    EditText forgetCode;
    @BindView(R.id.forget_getcode)
    Button forgetGetcode;
    @BindView(R.id.forget_submit)
    Button forgetSubmit;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();

    }

    public void btnBack(View view) {
        finish();
    }

    public void getCode() {
        NetWorkManager.getServerApi().sendValidate(MyApp.getApp().getBody().getData().getPhone())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            LogUtils.d("dxy", body.string());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }


    private void setCodeStatus() {
        forgetGetcode.setEnabled(false);
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

    @OnClick({R.id.forget_getcode, R.id.forget_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_getcode:
                setCodeStatus();
                getCode();
                break;
            case R.id.forget_submit:
                String psd = forgetPsd.getText().toString();
                String code = forgetCode.getText().toString();
                if (psd.length() < 7) {
                    ToastUtils.showShort("密码不能小于6位");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    ToastUtils.showShort("验证码不能为空");
                    return;
                }
                checkCode(code);
                break;
        }
    }

    public void checkCode(String code) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", MyApp.getApp().getBody().getData().getPhone());
        map.put("uid", MyApp.getApp().getBody().getData().getUid());
        map.put("password", code);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().updatePassword(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

}
