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
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.common.AccountDbUtil;
import com.example.petsocial.entity.AccountEntity;
import com.example.petsocial.entity.NewsEntity;

import java.util.List;

public class MessageAdapter extends BaseQuickAdapter<NewsEntity, BaseViewHolder> {

    public MessageAdapter(@Nullable List<NewsEntity> data) {
        super(data);
        mLayoutResId = R.layout.item_care;
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, NewsEntity item) {
        if (AccountDbUtil.getInstance().isUserInfo(item.getCreateId())) {
            AccountEntity userInfo = AccountDbUtil.getInstance().getUserInfo(item.getCreateId());
            //LogUtils.d("dxy:" + "getCreateId = " + item.getCreateId() + ",name = " + userInfo.getName());
            helper.setText(R.id.item_message_name, userInfo.getName());
            Glide.with(mContext)
                    .load(userInfo.getAvatar())
                    .placeholder(R.drawable.my_icon)
                    .error(R.drawable.my_icon)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(((ImageView) helper.getView(R.id.item_message_icon)));
        }


        helper.setText(R.id.item_message_tvContext, item.getContext());
        //helper.setText(R.id.item_message_name, item.getMobile());
        helper.setText(R.id.item_message_tvzan, "点赞数:" + item.getStar());
        helper.setText(R.id.message_type, item.getFlag() == 1 ? "狗狗" : "猫咪");
        helper.setText(R.id.item_message_zan, item.getStar() + "人赞");

        helper.addOnClickListener(R.id.item_message_icon);
        helper.addOnClickListener(R.id.message_img1);
        helper.addOnClickListener(R.id.message_img2);
        helper.addOnClickListener(R.id.message_img3);
        helper.addOnClickListener(R.id.message_img4);
        helper.setTag(R.id.message_img1, 0);
        helper.setTag(R.id.message_img2, 1);
        helper.setTag(R.id.message_img3, 2);
        helper.setTag(R.id.message_img4, 3);

        LinearLayout view1 = helper.getView(R.id.item_message_lin1);
        view1.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(item.getVideo())) {
            view1.setVisibility(View.VISIBLE);
            ImageView view = helper.getView(R.id.message_img1);
            Glide.with(mContext)
                    .load(item.getVideo())
                    .into(view);
        }

        List<String> images = item.getImages();
        if (images == null) return;
        view1.setVisibility(View.VISIBLE);
        for (int i = 0; i < images.size(); i++) {
            ImageView view = helper.getView(getId(i));
            Glide.with(mContext)
                    .load(images.get(i))
                    .into(view);
        }

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
