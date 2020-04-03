package com.example.petsocial.adapter;


import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.common.AccountDbUtil;
import com.example.petsocial.entity.AccountEntity;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.NewsEntity;

import java.util.List;

public class MessageAdapter extends BaseQuickAdapter<DataEntity.DataBean.ItemsBean, BaseViewHolder> {

    public MessageAdapter(@Nullable List<DataEntity.DataBean.ItemsBean> data) {
        super(R.layout.item_care,data);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DataEntity.DataBean.ItemsBean item) {
        helper.setText(R.id.item_message_tvContext, item.getNote());

    }

    private int getId(int i) {
        switch (i) {
            case 0:
                return R.id.message_img1;
            case 1:
                return R.id.message_img2;
            case 2:
                return R.id.message_img3;
            case 3:
                return R.id.message_img4;
        }
        return R.id.message_img4;
    }
}
