package com.example.petsocial.mvp.presenter;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.mvp.contract.DataContract;
import com.example.petsocial.mvp.contract.TestContract;
import com.example.petsocial.util.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DataPresenter extends BasePresenter<DataContract.View> implements DataContract.Presenter {

    public DataPresenter() {

    }

    public void loadData(int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("currentPage", 1);
        map.put("pageSize", 10);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().pullMomentSelf(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                mView.onSuccess(body);
                            }
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }
}
