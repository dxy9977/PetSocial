package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.ForgetContract;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ForgetPresenter extends BasePresenter<ForgetContract.View> implements ForgetContract.Presenter {

    public ForgetPresenter() {

    }


    public void getCode() {
        NetWorkManager.getServerApi().sendValidate(mView.getCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

    public void checkCode() {
        String newPsd = mView.getNewPsd();
        if (newPsd.length() < 6) {
            mView.showMessage("密码不能小于6位数");
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", mView.getCode());
        map.put("uid", "");
        map.put("password", mView.getCode());
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
