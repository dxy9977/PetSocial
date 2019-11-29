package com.example.petsocial.mvp.presenter;


import android.text.TextUtils;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.MainContract;
import com.example.petsocial.util.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter() {

    }

    public void checkLogin() {
        String name = mView.getName();
        String psd = mView.getPsd();
        NetWorkManager.getServerApi().checkLogin(name, psd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }
}
