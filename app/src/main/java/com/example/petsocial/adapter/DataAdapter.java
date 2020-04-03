package com.example.petsocial.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.petsocial.R;
import com.example.petsocial.entity.DataEntity;

import java.util.List;

public class DataAdapter extends BaseQuickAdapter<DataEntity.DataBean.ItemsBean, BaseViewHolder> {
    public DataAdapter(@Nullable List<DataEntity.DataBean.ItemsBean> data) {
        super(R.layout.item_care,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DataEntity.DataBean.ItemsBean item) {
        helper.setText(R.id.item_message_tvContext, item.getNote());
        //helper.setText(R.id.item_message_name, item.getMobile());
       // helper.setText(R.id.item_message_tvzan, "点赞数:" + item.getStar());
        //helper.setText(R.id.message_type, item.getFlag() == 1 ? "狗狗" : "猫咪");
        //helper.setText(R.id.item_message_zan, item.getStar() + "人赞");
        //helper.setText(R.id.item_message_name, item.getCreator().getName());
        //ImageView icon = helper.getView(R.id.item_message_icon);
        //Glide.with(mContext).load("").placeholder(R.drawable.my_icon).error(R.drawable.my_icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(icon);

/*        helper.addOnClickListener(R.id.item_message_icon);
        helper.addOnClickListener(R.id.message_img1);
        helper.addOnClickListener(R.id.message_img2);
        helper.addOnClickListener(R.id.message_img3);
        helper.addOnClickListener(R.id.message_img4);
        helper.setTag(R.id.message_img1, 0);
        helper.setTag(R.id.message_img2, 1);
        helper.setTag(R.id.message_img3, 2);
        helper.setTag(R.id.message_img4, 3);*/

        LinearLayout view1 = helper.getView(R.id.item_message_lin1);
        view1.setVisibility(View.GONE);

        /*List<String> images = item.getImages();
        if (images == null) return;
        view1.setVisibility(View.VISIBLE);
        for (int i = 0; i < images.size(); i++) {
            ImageView view = helper.getView(getId(i));
            Glide.with(mContext)
                    .load(images.get(i))
                    .into(view);
        }*/
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
