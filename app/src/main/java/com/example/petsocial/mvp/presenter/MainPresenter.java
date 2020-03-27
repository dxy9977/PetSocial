package com.example.petsocial.mvp.presenter;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.MainContract;
import com.example.petsocial.ui.SelectActivity;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter() {

    }

    public void checkLogin() {
        mView.showLoading();
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getName());
        map.put("password", mView.getPsd());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().login1(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            /*if (body.isSuccess()) {
                                mView.success();
                                NetWorkManager.basic = body.getData().getToken();
                                LogUtils.d("dxy", NetWorkManager.basic);
                                NetWorkManager.getInstance().init();
                            } else {
                                mView.showMessage(body.getMessage());
                            }*/
                            JSONObject jb = new JSONObject(body.string());
                            boolean success = jb.getBoolean("success");
                            if (success){
                                mView.success();
                                NetWorkManager.basic = jb.getString("data");
                                LogUtils.d("dxy", NetWorkManager.basic);
                                NetWorkManager.getInstance().init();
                            }


                            mView.hideLoading();
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                            mView.hideLoading();
                        }
                );
    }
}
