package com.example.petsocial.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.entity.FriendEntity;

public class FriendAdapter extends BaseQuickAdapter<FriendEntity.DataBean.ItemsBean, BaseViewHolder> {
    public FriendAdapter() {
        super(R.layout.item_friend_listview);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FriendEntity.DataBean.ItemsBean item) {
        helper.setText(R.id.item_first_name, item.getUsername());
        helper.setText(R.id.item_first_title, item.getPhone());
        helper.setText(R.id.item_first_ti, "");
        Glide.with(getContext())
                .load(NetWorkManager.BASE_URL + item.getHead_img_src())
                .placeholder(R.drawable.my_icon)
                .error(R.drawable.my_icon)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(((ImageView) helper.getView(R.id.item_first_img)));

    }
}
