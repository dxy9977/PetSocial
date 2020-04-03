package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.MainContract;
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
        LogUtils.d("dxy", "11222333");
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
                                mView.success();
                            }else {
                                ToastUtils.showShort(body.getMessage());
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
