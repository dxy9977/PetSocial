package com.example.petsocial.mvp.contract;


import com.example.petsocial.entity.FirstEntity;
import com.example.petsocial.util.base.BaseView;

import java.util.List;

public interface FirstContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void success(FirstEntity body);


    }

    interface Presenter {

    }
}
