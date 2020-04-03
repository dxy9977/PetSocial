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
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.entity.DataEntity;

import java.util.List;

public class FirstListAdapter extends BaseQuickAdapter<DataEntity.DataBean.ItemsBean, BaseViewHolder> {

    public FirstListAdapter(@Nullable List<DataEntity.DataBean.ItemsBean> data) {
        super(R.layout.item_first_listview, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DataEntity.DataBean.ItemsBean item) {
        helper.setText(R.id.item_content, item.getNote());
        helper.setText(R.id.item_first_tvzan, "点赞量:" + (item.getPraise_points() == null ? "0" : item.getPraise_points()));
        helper.setText(R.id.item_name, item.getUser().getUsername());
        //设置用户头像
        Glide.with(getContext())
                .load(NetWorkManager.BASE_URL + item.getUser().getHead_img_src())
                .placeholder(R.drawable.my_icon).error(R.drawable.my_icon)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(((ImageView) helper.getView(R.id.item_first_icon)));


        LinearLayout ll = helper.getView(R.id.liner);
        String img_src = item.getImg_src();
        //有图片资源
        if (!TextUtils.isEmpty(img_src)) {
            ll.setVisibility(View.VISIBLE);
            String[] split = img_src.split("\\|");
            for (int i = 0; i < split.length; i++) {
                Glide.with(getContext()).load(NetWorkManager.BASE_URL + split[i]).into(((ImageView) helper.getView(getId(i))));

            }

        } else {//无图片资源
            ll.setVisibility(View.GONE);
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
