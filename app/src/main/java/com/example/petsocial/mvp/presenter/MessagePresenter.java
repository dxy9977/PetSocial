package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.MessageContract;
import com.example.petsocial.mvp.contract.TestContract;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {

    public MessagePresenter() {

    }

    public void loadData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("flag", 0);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().getNews(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                mView.success(body.getData());
                            }
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

}
