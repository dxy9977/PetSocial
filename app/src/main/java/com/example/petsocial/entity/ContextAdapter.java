package com.example.petsocial.entity;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;

import java.util.List;

public class ContextAdapter extends BaseQuickAdapter<CommentEntity.DataBean, BaseViewHolder> {
    public ContextAdapter(@Nullable List<CommentEntity.DataBean> data) {
        super(R.layout.item_comment, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CommentEntity.DataBean item) {
        helper.setText(R.id.item_name, item.getUser().getUsername());
        helper.setText(R.id.item_content, item.getNote());
        helper.setText(R.id.item_date, item.getComment_time());
        Glide.with(getContext())
                .load(NetWorkManager.BASE_URL + item.getUser().getHead_img_src())
                .placeholder(R.drawable.my_icon)
                .error(R.drawable.my_icon)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(((ImageView) helper.getView(R.id.item_img)));
    }
}
