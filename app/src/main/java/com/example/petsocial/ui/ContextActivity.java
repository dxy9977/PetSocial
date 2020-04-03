package com.example.petsocial.ui;


import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.entity.AccountEntity;
import com.example.petsocial.entity.CommentEntity;
import com.example.petsocial.entity.ContextAdapter;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.FirstEntity;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.util.base.BaseActivity;
import com.example.petsocial.util.view.EditCommentDialog;
import com.example.petsocial.util.view.MyImageLoader;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.gyf.immersionbar.ImmersionBar;
import com.lxj.xpopup.XPopup;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ContextActivity extends BaseActivity implements View.OnClickListener, PlaybackPreparer {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private View headView, footView;
    private ContextAdapter adapter;
    private List<CommentEntity.DataBean> data;
    private DataEntity.DataBean.ItemsBean body;

    private ImageView iconImg, img1, img2, img3, img4;
    private TextView type, time, name, addComment;
    private LinearLayout imgLiner;
    private PlayerView playerView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_context;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).init();
        //初始化适配器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 20);//底部间距
        recyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        adapter = new ContextAdapter(data);
        //设置头尾布局
        headView = getLayoutInflater().inflate(R.layout.head_context, recyclerView, false);
        footView = getLayoutInflater().inflate(R.layout.foot_context, recyclerView, false);
        adapter.setHeaderView(headView);
        adapter.setFooterView(footView);
        recyclerView.setAdapter(adapter);
        //初始控件
        body = (DataEntity.DataBean.ItemsBean) getIntent().getSerializableExtra("data");


        iconImg = headView.findViewById(R.id.activity_context_icon);
        playerView = headView.findViewById(R.id.video_view);
        img1 = headView.findViewById(R.id.item_img1);
        img2 = headView.findViewById(R.id.item_img2);
        img3 = headView.findViewById(R.id.item_img3);
        img4 = headView.findViewById(R.id.item_img4);
        type = headView.findViewById(R.id.activity_context_type);
        time = headView.findViewById(R.id.activity_context_time);
        name = headView.findViewById(R.id.activity_context_name);
        imgLiner = headView.findViewById(R.id.item_img_liner);
        addComment = footView.findViewById(R.id.head_comment);
        addComment.setOnClickListener(this);
        iconImg.setOnClickListener(this);
        //img0.setOnClickListener(this);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        //加载评论信息
        loadData();
        //显示用户动态基本信息
        loadInfo();
    }

    private ImageView getImg(int i) {
        switch (i) {
            case 0:
                return img1;
            case 1:
                return img2;
            case 2:
                return img3;
            case 3:
                return img4;
        }
        return img1;
    }


    public void loadData() {
        NetWorkManager.getServerApi().findByMid(body.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.getData() == null) return;
                            adapter.replaceData(body.getData());
                            adapter.notifyDataSetChanged();
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

    public void loadInfo() {
        ((TextView) headView.findViewById(R.id.activity_context_context)).setText(body.getNote());
        ((TextView) headView.findViewById(R.id.activity_context_name)).setText(body.getUser().getUsername());
        //((TextView) headView.findViewById(R.id.activity_context_time)).setText(body.getUser().getUsername());

/*      ((TextView) headView.findViewById(R.id.activity_context_tv_phone)).setText(body.getMobile());
        ((TextView) headView.findViewById(R.id.activity_context_tv_qq)).setText(body.getQq());
        ((TextView) headView.findViewById(R.id.activity_context_tv_wechat)).setText(body.getWechat());
        ((TextView) headView.findViewById(R.id.activity_context_tv_addr)).setText(body.getLocation());*/
        //头像
        Glide.with(this)
                .load(NetWorkManager.BASE_URL + body.getUser().getHead_img_src())
                .placeholder(R.drawable.my_icon)
                .error(R.drawable.my_icon)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iconImg);

        String img_src = body.getImg_src();
        //有图片资源
        if (!TextUtils.isEmpty(img_src)) {
            String[] split = img_src.split("\\|");
            for (int i = 0; i < split.length; i++) {
                Glide.with(this).load(NetWorkManager.BASE_URL + split[i]).into(getImg(i));

            }

        } else {//无图片资源
        }
    }


    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_comment:
                EditCommentDialog editCommentDialog = new EditCommentDialog(this, R.style.dialog_soft_input);
                editCommentDialog.show();
                editCommentDialog.setListener(t -> {
                    if (!TextUtils.isEmpty(t)) {
                        editCommentDialog.dismiss();
                        addComment(t);
                    }
                });
                break;
            case R.id.activity_context_icon:

                break;
            case R.id.item_img1:

                break;
            case R.id.item_img2:

                break;
            case R.id.item_img3:

                break;
            case R.id.item_img4:

                break;
            case R.id.item_img:

                break;
        }
    }


    /**
     * 添加评论
     *
     * @param ss
     */
    public void addComment(String ss) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("note", ss);
        map.put("moments_id", body.getId());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().addComment(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            loadData();
                            LogUtils.d("dxy", body.string());
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

    @Override
    public void preparePlayback() {

    }
}
