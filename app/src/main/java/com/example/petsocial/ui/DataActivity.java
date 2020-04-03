package com.example.petsocial.ui;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petsocial.R;
import com.example.petsocial.adapter.DataAdapter;
import com.example.petsocial.common.MyApp;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.LoginEntity;
import com.example.petsocial.mvp.contract.DataContract;
import com.example.petsocial.mvp.presenter.DataPresenter;
import com.example.petsocial.util.base.BaseMvpActivity;
import com.example.petsocial.util.view.MyImageLoader;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;
import com.gyf.immersionbar.ImmersionBar;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class DataActivity extends BaseMvpActivity<DataPresenter> implements DataContract.View, View.OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DataAdapter adapter;
    private View headView;
    private List<DataEntity.DataBean.ItemsBean> data;

    private ImageView headIcon;
    private TextView headName,zhanghao, headPhone, headQian, headText1, headText2, headText3;
    private DataEntity myBody;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data;
    }

    @Override
    public void initView() {
        mPresenter = new DataPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 20);//底部间距
        recyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        adapter = new DataAdapter(data);
        headView = getLayoutInflater().inflate(R.layout.head_data, recyclerView, false);
        headIcon = headView.findViewById(R.id.activity_data_icon);
        headName = headView.findViewById(R.id.activity_data_name);
        zhanghao = headView.findViewById(R.id.activity_data_id);
        headPhone = headView.findViewById(R.id.activity_data_phone1);
        headQian = headView.findViewById(R.id.activity_data_qian1);
        headText1 = headView.findViewById(R.id.head_text1);
        headText2 = headView.findViewById(R.id.head_text2);
        headText3 = headView.findViewById(R.id.head_text3);
        headIcon.setOnClickListener(this);

        adapter.setHeaderView(headView);
        recyclerView.setAdapter(adapter);
        int id = getIntent().getIntExtra("id", 0);
        mPresenter.loadData(id);
        if (id == 0) {
            LoginEntity.DataBean data = MyApp.getApp().getBody().getData();
            headName.setText(data.getUsername());
            zhanghao.setText(data.getPhone());
            headPhone.setText(data.getPhone());
            headQian.setText(data.getPs_note());

        }


//        adapter.setOnItemChildClickListener((a, v, p) -> {
//            if (v.getId() == R.id.item_message_icon) {
//                new XPopup.Builder(this)
//                        .asImageViewer(((ImageView) v), adapter.getData().get(p).getCreator().getAvatar(), new MyImageLoader())
//                        .show();
//                return;
//            }
//            LogUtils.d("dxy positon = ", p, "dxy" + v.getTag(), "dxy = ");
//
//            List<Object> list = new ArrayList<>();
//            List<String> images = adapter.getData().get(p).getImages();
//            if (images == null || ((int) v.getTag()) >= images.size()) return;
//            list.addAll(images);
//            new XPopup.Builder(this).asImageViewer(((ImageView) v), ((int) v.getTag()), list, (p1, p2) -> {
//                //p1.updateSrcView(((ImageView) adapter.getViewByPosition(p, getId(p2))));
//                //adapter.getViewByPosition(p, getId(p2));
//            }, new MyImageLoader())
//                    .show();
//
//        });
    }

    public void btnBack(View view) {
        finish();
    }

    @Override
    public void onSuccess(DataEntity body) {
        adapter.addData(body.getData().getItems());
        adapter.notifyDataSetChanged();

        /*headText1.setText(body.getNews() == null ? "0" : body.getNews().size() + "");
        headText2.setText(body.getWatch() + "");
        headText3.setText(body.getFans() + "");
        Glide.with(this).load(body.getInfo().getAvatar()).placeholder(R.drawable.my_icon).error(R.drawable.my_icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(headIcon);
        headName.setText(body.getInfo().getName());
        headPhone.setText(body.getInfo().getMobile());
        myBody = body;*/
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_data_icon:
                /*new XPopup.Builder(this)
                        .asImageViewer(headIcon, myBody.getInfo().getAvatar(), new MyImageLoader())
                        .show();*/
                return;
        }
    }

    public void back(View view) {
        finish();
    }
}
