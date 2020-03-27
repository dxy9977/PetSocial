package com.example.petsocial.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.petsocial.R;
import com.example.petsocial.adapter.FirstListAdapter;
import com.example.petsocial.entity.FirstEntity;
import com.example.petsocial.entity.MainEntity;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.mvp.contract.FirstContract;
import com.example.petsocial.mvp.presenter.FirstPresenter;
import com.example.petsocial.ui.ArticleActivity;
import com.example.petsocial.ui.ContextActivity;
import com.example.petsocial.ui.SimpleDetailActivity;
import com.example.petsocial.ui.VideoActivity;
import com.example.petsocial.util.base.BaseMvpFragment;
import com.example.petsocial.util.view.MediaFileUtil;
import com.example.petsocial.util.view.MyImageLoader;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseMvpFragment<FirstPresenter> implements FirstContract.View, View.OnClickListener {
    Banner banner;
    /*@BindView(R.id.text_show)
    TextView textShow;*/
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private View headView;
    private FirstListAdapter adapter;
    private List<NewsEntity> data;
    private TextView mNotice;
    private List<String> notice = new ArrayList<>();
    private int postion = 0;

    public FirstFragment() {
        // Required empty public constructor
    }


    Handler mHandler = new Handler() {

        //handleMessage为处理消息的方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mNotice.setText(notice.get(postion));
            mHandler.sendEmptyMessageDelayed(0, 3000);
            if (++postion == 3) {
                postion = 0;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        headView = inflater.inflate(R.layout.head_first, container, false);
        banner = headView.findViewById(R.id.banner);
        mNotice = headView.findViewById(R.id.text_show);
        headView.findViewById(R.id.liner1).setOnClickListener(this);
        headView.findViewById(R.id.liner2).setOnClickListener(this);
        headView.findViewById(R.id.liner3).setOnClickListener(this);
        headView.findViewById(R.id.liner4).setOnClickListener(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        mPresenter = new FirstPresenter();
        mPresenter.attachView(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 20);//底部间距
        recyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        adapter = new FirstListAdapter(data);
        adapter.setHeaderView(headView);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener((a, v, p) -> {

            /*if (v.getId() == R.id.item_first_icon) {
                new XPopup.Builder(getContext())
                        .asImageViewer(((ImageView) v), R.drawable.my_icon, new MyImageLoader())
                        .show();
                return;
            }*/
            //LogUtils.d("dxy positon = ", p, "dxy" + v.getTag(), "dxy = ");
            if (MediaFileUtil.isVideoFileType(adapter.getItem(p).getVideo())) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("data", adapter.getItem(p).getVideo());
                startActivity(intent);
                return;
            }


            List<Object> list = new ArrayList<>();
            List<String> images = adapter.getData().get(p).getImages();
            if (images == null || ((int) v.getTag()) >= images.size()) return;
            list.addAll(images);
            new XPopup.Builder(getContext()).asImageViewer(((ImageView) v), ((int) v.getTag()), list, (p1, p2) -> {
                //p1.updateSrcView(((ImageView) adapter.getViewByPosition(p, getId(p2))));
                //adapter.getViewByPosition(p, getId(p2));
            }, new MyImageLoader())
                    .show();

        });


        adapter.setOnItemClickListener((a, v, p) -> {
            Intent intent = new Intent(getContext(), ContextActivity.class);
            intent.putExtra("data", adapter.getData().get(p));
            startActivity(intent);
        });


        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("http://api.atatakai.cn/api/v1/public/file/1575943139609210399.jpg");
        images.add("http://api.atatakai.cn/api/v1/public/file/1575943525647548495.png");
        images.add("http://api.atatakai.cn/api/v1/public/file/1575943549093158118.png");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            banner.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20);
                }
            });
            banner.setClipToOutline(true);
        }

        mPresenter.loadData();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), ArticleActivity.class);
        switch (v.getId()) {
            case R.id.liner1:
                intent.putExtra("id", 0);
                startActivity(intent);
                break;
            case R.id.liner2:
                intent.putExtra("id", 1);
                startActivity(intent);
                break;
            case R.id.liner3:
                intent.putExtra("id", 2);
                startActivity(intent);
                break;
            case R.id.liner4:
                intent.putExtra("id", 3);
                startActivity(intent);
                break;
        }
    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
            //Glide 加载图片简单用法
            /*Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                    .into(imageView);*/


            Glide.with(context)
                    .load(path)
                    /*.apply(new RequestOptions()
                            .transforms(new CenterCrop(), new RoundedCorners(20)
                            ))*/
                    .into(imageView);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
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
    public void success(FirstEntity body) {
        adapter.addData(body.getData().getNews());
        adapter.notifyDataSetChanged();
        notice.addAll(body.getData().getHorns());
        banner.update(body.getData().getImages());
        mHandler.sendEmptyMessage(0);
    }

}
