package com.example.petsocial.mvp.contract;


import com.example.petsocial.util.base.BaseView;

public interface PhoneContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void showMeg(String msg);

        String getPhone();

        String getCode();

        void onSuceess(boolean a);

    }

    interface Presenter {

    }
}
