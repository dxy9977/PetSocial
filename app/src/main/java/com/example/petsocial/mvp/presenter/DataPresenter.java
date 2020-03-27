package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.DataContract;
import com.example.petsocial.mvp.contract.TestContract;
import com.example.petsocial.util.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataPresenter extends BasePresenter<DataContract.View> implements DataContract.Presenter {

    public DataPresenter() {

    }

    public void loadData(int id) {
        NetWorkManager.getServerApi().getData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                mView.onSuccess(body.getData());
                            }
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }
}
