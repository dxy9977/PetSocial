package com.example.petsocial.adapter;


import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.common.AccountDbUtil;
import com.example.petsocial.entity.AccountEntity;
import com.example.petsocial.entity.NewsEntity;

import java.util.List;

public class FirstListAdapter extends BaseQuickAdapter<NewsEntity, BaseViewHolder> {

    public FirstListAdapter(@Nullable List<NewsEntity> data) {
        super(data);
        mLayoutResId = R.layout.item_first_listview;
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, NewsEntity item) {
        if (AccountDbUtil.getInstance().isUserInfo(item.getCreateId())) {
            AccountEntity userInfo = AccountDbUtil.getInstance().getUserInfo(item.getCreateId());
            LogUtils.d("dxy:" + "getCreateId = " + item.getCreateId() + ",name = " + userInfo.getName());
            helper.setText(R.id.item_name, userInfo.getName());
            Glide.with(mContext)
                    .load(userInfo.getAvatar())
                    .placeholder(R.drawable.my_icon)
                    .error(R.drawable.my_icon)
                    //.apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .apply(new RequestOptions()
                            .transforms(new CenterCrop(), new RoundedCorners(15)
                            ))
                    .into(((ImageView) helper.getView(R.id.item_first_icon)));
        }

        helper.setText(R.id.item_content, item.getContext());
        helper.setText(R.id.item_type, item.getFlag() == 1 ? "狗狗" : "猫咪");
        helper.setText(R.id.item_first_tvzan, "点赞数:" + item.getStar());
        helper.addOnClickListener(R.id.item_img1);
        helper.addOnClickListener(R.id.item_img2);
        helper.addOnClickListener(R.id.item_img3);
        helper.addOnClickListener(R.id.item_img4);
        //helper.addOnClickListener(R.id.item_first_icon);
        helper.setTag(R.id.item_img1, 0);
        helper.setTag(R.id.item_img2, 1);
        helper.setTag(R.id.item_img3, 2);
        helper.setTag(R.id.item_img4, 3);
        LinearLayout view1 = helper.getView(R.id.liner);
        view1.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(item.getVideo())) {
            view1.setVisibility(View.VISIBLE);
            ImageView view = helper.getView(R.id.item_img1);
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
                return R.id.item_img1;
            case 1:
                return R.id.item_img2;
            case 2:
                return R.id.item_img3;
            case 3:
                return R.id.item_img4;
        }
        return R.id.item_img4;
    }
}
