package com.example.petsocial.mvp.contract;


import com.example.petsocial.util.base.BaseView;

public interface ForgetContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void showMessage(String meg);


        String getPhone();

        String getCode();

        String getNewPsd();
    }

    interface Presenter {

    }
}
