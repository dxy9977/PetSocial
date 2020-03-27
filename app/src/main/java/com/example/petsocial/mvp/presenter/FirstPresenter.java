package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.FirstContract;
import com.example.petsocial.mvp.contract.TestContract;
import com.example.petsocial.util.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FirstPresenter extends BasePresenter<FirstContract.View> implements FirstContract.Presenter {

    public FirstPresenter() {

    }

    public void loadData() {
        NetWorkManager.getServerApi().getMain()
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
}
