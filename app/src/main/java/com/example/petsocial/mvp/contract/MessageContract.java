package com.example.petsocial.mvp.contract;


import com.example.petsocial.entity.MyResponse;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.util.base.BaseView;

import java.util.List;

public interface MessageContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void success(List<NewsEntity> body);

    }

    interface Presenter {

    }
}
