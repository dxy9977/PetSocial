package com.example.petsocial.mvp.contract;


import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.UserInfoEntity;
import com.example.petsocial.util.base.BaseView;

public interface CustomContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void success(UserInfoEntity body);

        void success(String s,String url);

        void onData(DataEntity body);

    }

    interface Presenter {

    }
}
