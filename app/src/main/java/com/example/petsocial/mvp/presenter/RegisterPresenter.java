package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.RegisterContract;
import com.example.petsocial.util.base.BasePresenter;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    public RegisterPresenter() {

    }


    public void getCode() {
        NetWorkManager.getServerApi().sendValidate(mView.getPhone())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            LogUtils.d("dxy", body.string());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

    public void register() {
        if (mView.getNewPsd().length() < 6) {
            mView.showMessage("密码不能小于6位数");
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getPhone());
        map.put("password", mView.getNewPsd());
        map.put("verifyCode", mView.getCode());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().register(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            String string = body.string();
                            LogUtils.d("dxy", string);
                            JSONObject jb = new JSONObject(string);

                            LogUtils.d("dxy", 222);
                            if (jb.getBoolean("success")) {
                                login();
                            } else {
                                ToastUtils.showShort(jb.getString("message"));
                            }
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

    private void login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getPhone());
        map.put("password", mView.getNewPsd());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().login1(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                NetWorkManager.basic = body.getMessage();
                                LogUtils.d("dxy", NetWorkManager.basic);
                                NetWorkManager.getInstance().init();
                                SPUtils.getInstance("user").put("login", true);
                                CacheDiskUtils.getInstance().put("test", body);
                                MyApp.getApp().setBody(body);
                                mView.onSucess();
                            } else {
                                ToastUtils.showShort(body.getMessage());
                            }
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

}
