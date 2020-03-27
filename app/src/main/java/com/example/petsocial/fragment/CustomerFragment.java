package com.example.petsocial.fragment;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.petsocial.R;
import com.example.petsocial.entity.DataEntity;
import com.example.petsocial.entity.UserInfoEntity;
import com.example.petsocial.login.MainActivity;
import com.example.petsocial.mvp.contract.CustomContract;
import com.example.petsocial.mvp.presenter.CustomPresenter;
import com.example.petsocial.ui.DataActivity;
import com.example.petsocial.ui.SetPasswordActivity;
import com.example.petsocial.ui.WayActivity;
import com.example.petsocial.util.base.BaseMvpFragment;
import com.example.petsocial.util.view.GlideEngine;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.wanglu.photoviewerlibrary.PhotoViewer;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.time.temporal.ValueRange;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends BaseMvpFragment<CustomPresenter> implements CustomContract.View {


    @BindView(R.id.custom_icon)
    ImageView customIcon;
    @BindView(R.id.text_guangzhu)
    TextView textGuangzhu;
    @BindView(R.id.text_beiguangzhu)
    TextView textBeiguangzhu;
    @BindView(R.id.text_dongtai)
    TextView textDongtai;

    @BindView(R.id.custom_name)
    TextView customName;
    @BindView(R.id.custom_myaccount)
    TextView customMyaccount;


    private UserInfoEntity bb;

    public CustomerFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(View view) {
        mPresenter = new CustomPresenter();
        mPresenter.attachView(this);
        mPresenter.loadInfo();
        mPresenter.loadData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_customer;
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
    public void success(UserInfoEntity body) {
        customName.setText(body.getData().getName());
        customMyaccount.setText(body.getData().getMobile());
        Glide.with(this)
                .load(body.getData().getAvatar())
                .placeholder(R.drawable.my_icon)
                .error(R.drawable.my_icon)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(customIcon);
        bb = body;
    }

    @Override
    public void success(String s, String url) {
        //mPresenter.setInfo("s", url);
    }

    @Override
    public void onData(DataEntity body) {
        textGuangzhu.setText(body.getWatch() + "");
        textBeiguangzhu.setText(body.getFans() + "");
        textDongtai.setText(body.getNews() == null ? "0" : body.getNews().size() + "");
    }

    @OnClick({R.id.custom_name, R.id.custom_icon, R.id.custom_guangzhu, R.id.custom_beiguangzhu, R.id.custom_dongtai, R.id.custom_home, R.id.custom_account, R.id.custom_set, R.id.custom_push, R.id.custom_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.custom_icon:
                new XPopup.Builder(getContext())
                        .asBottomList("请选择一项", new String[]{"查看头像", "拍照", "从手机相册中选择"},
                                (p, t) -> {
                                    imgSetting(p);
                                })
                        .show();
                break;

            case R.id.custom_name:
                new XPopup.Builder(getContext()).asInputConfirm("修改名称", "请输入内容",
                        (t) -> {
                            mPresenter.setInfo("name", t);
                            customName.setText(t);
                            bb.getData().setName(t);
                        })
                        .show();
                break;
            case R.id.custom_guangzhu:

                break;
            case R.id.custom_beiguangzhu:

                break;
            case R.id.custom_dongtai:

                break;
            case R.id.custom_home:
                startActivity(new Intent(getContext(), DataActivity.class));
                break;
            case R.id.custom_account:
                startActivity(new Intent(getContext(), WayActivity.class));
                break;
            case R.id.custom_set:
                startActivity(new Intent(getContext(), SetPasswordActivity.class));
                break;
            case R.id.custom_push:
                ToastUtils.showShort("功能暂未开放");
                break;
            case R.id.custom_exit:


                break;
        }
    }

    private void imgSetting(int p) {
        switch (p) {
            case 0:
                new XPopup.Builder(getContext())
                        .asImageViewer(customIcon, bb == null ? "" : bb.getData().getAvatar(), new ImageLoader())
                        .show();
                break;
            case 1:
                PictureSelector.create(this)
                        .openCamera(PictureMimeType.ofImage())
                        .loadImageEngine(GlideEngine.createGlideEngine())
                        .maxSelectNum(1)
                        .isSingleDirectReturn(true)
                        .enableCrop(true)// 是否裁剪
                        .compress(true)// 是否压缩
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .circleDimmedLayer(true)// 是否圆形裁剪
                        .forResult(1);
                break;
            case 2:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .loadImageEngine(GlideEngine.createGlideEngine())
                        .maxSelectNum(1)
                        .enableCrop(true)// 是否裁剪
                        .compress(true)// 是否压缩
                        .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1
                        .showCropFrame(false)
                        .showCropGrid(false)
                        .circleDimmedLayer(true)// 是否圆形裁剪
                        .forResult(1);
                break;
        }
    }

    class ImageLoader implements XPopupImageLoader {

        @Override
        public void loadImage(int position, @NonNull Object uri, @NonNull ImageView imageView) {
            Glide.with(imageView).load(uri).into(imageView);
        }

        //必须实现这个方法，返回uri对应的缓存文件，可参照下面的实现，内部保存图片会用到。如果你不需要保存图片这个功能，可以返回null。
        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            LogUtils.d("dxy", "haha");
            List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
            String compressPath = localMedia.get(0).getCompressPath();
            mPresenter.setImg(compressPath);
            Glide.with(this).load(compressPath).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(customIcon);
            bb.getData().setAvatar(compressPath);
        }

    }


}
