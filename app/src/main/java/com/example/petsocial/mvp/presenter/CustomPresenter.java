package com.example.petsocial.mvp.presenter;


import android.text.TextUtils;
import android.util.ArrayMap;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.CustomContract;
import com.example.petsocial.util.base.BasePresenter;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        /*NetWorkManager.getServerApi().getData(0)
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
                );*/
    }

    public void setImg(String path) {
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), "head");
        NetWorkManager.getServerApi().upload(body, requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(b -> {
                            String str = b.string();
                            LogUtils.d("dxy" + str);

                            JSONObject jb = new JSONObject(str);

                            if (jb.getBoolean("success")) {
                                String data = jb.getString("data");
                                setInfo("head_img_src", data);
                                MyApp.getApp().getBody().getData().setHead_img_src(data);
                            } else {
                                ToastUtils.showShort(jb.getString("message"));
                            }
                        }, throwable ->
                        {
                            LogUtils.d("dxy =" + throwable.getMessage());
                        }
                );
    }


    public void setImgs(String path) {
        List<MultipartBody.Part> list = new ArrayList<>();
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("files", file.getName(), requestFile);
        list.add(body);
        list.add(body);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), "news");
        NetWorkManager.getServerApi().uploads(list, requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(b -> {
                            LogUtils.d("dxy =" + b.string());
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
        NetWorkManager.getServerApi().updateUser(requestBody)
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
