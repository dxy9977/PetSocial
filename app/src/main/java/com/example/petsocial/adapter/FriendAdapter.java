package com.example.petsocial.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.petsocial.R;

public class FriendAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public FriendAdapter() {
        super(R.layout.item_friend_listview);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.item_first_name, item);
        helper.setText(R.id.item_first_title, "11");
        helper.setText(R.id.item_first_ti, "2020.2.2");

    }
}
