package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.CustomContract;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CustomPresenter extends BasePresenter<CustomContract.View> implements CustomContract.Presenter {

    public CustomPresenter() {

    }


    public void loadInfo() {
        NetWorkManager.getServerApi().getInfo(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            mView.success(body);
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

    public void loadData() {
        NetWorkManager.getServerApi().getData(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                mView.onData(body.getData());
                            }
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

    public void setImg(String path) {
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("upload", file.getName(), requestFile);
        NetWorkManager.getServerApi().upload(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(b -> {
                            if (b.isSuccess()) {
                                LogUtils.d("dxy: = " + b.getData());
                                setInfo("avatar", b.getData());
                            }
                        }, throwable ->
                        {
                            LogUtils.d("dxy =" + throwable.getMessage());
                        }
                );
    }


    public void setInfo(String name, String s) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(name, s);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().modifyAccount(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

}
