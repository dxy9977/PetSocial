package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.ForgetContract;
import com.example.petsocial.mvp.contract.RegisterContract;
import com.example.petsocial.util.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    public RegisterPresenter() {

    }


    public void getCode() {
        NetWorkManager.getServerApi().getCode(mView.getPhone())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

    public void register() {
        String phone = mView.getPhone();
        String code = mView.getCode();
        String newPsd = mView.getNewPsd();
        if (newPsd.length() < 6) {
            mView.showMessage("密码不能小于6位数");
            return;
        }

        NetWorkManager.getServerApi().register(phone, code, newPsd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

}
