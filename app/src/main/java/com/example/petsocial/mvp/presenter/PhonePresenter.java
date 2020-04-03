package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.PhoneContract;
import com.example.petsocial.util.base.BasePresenter;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class PhonePresenter extends BasePresenter<PhoneContract.View> implements PhoneContract.Presenter {

    public PhonePresenter() {

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


    public void checkLogin() {
        NetWorkManager.getServerApi().login2(mView.getPhone(), mView.getCode())
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
                                mView.onSuceess(true);
                            } else {
                                ToastUtils.showShort(body.getMessage());
                            }
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }
}
