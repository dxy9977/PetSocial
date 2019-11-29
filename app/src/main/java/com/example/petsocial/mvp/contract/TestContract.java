package com.example.petsocial.mvp.contract;


import com.example.petsocial.util.base.BaseView;

public interface TestContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess();

    }

    interface Presenter {

    }
}
