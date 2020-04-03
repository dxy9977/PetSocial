package com.example.petsocial.mvp.contract;


import com.example.petsocial.entity.DataEntity;
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

        void success(List<DataEntity.DataBean.ItemsBean> body);


    }

    interface Presenter {

    }
}
