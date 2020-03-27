package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.PhoneContract;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PhonePresenter extends BasePresenter<PhoneContract.View> implements PhoneContract.Presenter {

    public PhonePresenter() {

    }


    public void getCode() {
        LogUtils.d("dxy", "sendValidate2");
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getPhone());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().sendValidate2(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                            LogUtils.d("dxy", body.string());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }


    public void checkLogin() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getPhone());
        map.put("verifyCode", mView.getCode());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());


        NetWorkManager.getServerApi().login2(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                            LogUtils.d("dxy", body.string());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }
}
