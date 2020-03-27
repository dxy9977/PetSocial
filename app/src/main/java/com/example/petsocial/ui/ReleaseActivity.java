package com.example.petsocial.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.util.base.BaseActivity;
import com.example.petsocial.util.view.CustomPartShadowPopupView;
import com.example.petsocial.util.view.GlideEngine;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.XPopup;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ReleaseActivity extends BaseActivity {

    @BindView(R.id.choose_pic)
    ImageView choosePic;
    @BindView(R.id.choose_vedio)
    ImageView chooseVedio;
    @BindView(R.id.liner_img1)
    ImageView linerImg1;
    @BindView(R.id.liner_img2)
    ImageView linerImg2;
    @BindView(R.id.liner_img3)
    ImageView linerImg3;
    @BindView(R.id.liner_img4)
    ImageView linerImg4;
    @BindView(R.id.liner_img)
    LinearLayout linerImg;
    @BindView(R.id.edit1)
    EditText edit1;
    @BindView(R.id.edit2)
    EditText edit2;
    @BindView(R.id.edit3)
    EditText edit3;
    @BindView(R.id.edit4)
    EditText edit4;
    @BindView(R.id.choose_type)
    TextView chooseType;
    @BindView(R.id.activity_add_edit_context)
    EditText activityAddEditContext;


    private int chooseTypeText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_release;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onStart() {
        ImmersionBar.with(this).statusBarDarkFont(true).keyboardEnable(true).init();
        super.onStart();
    }

    public void addNews() {
        String editContext = activityAddEditContext.getText().toString();
        if (TextUtils.isEmpty(editContext)) {
            ToastUtils.showShort("发布信息不能为空");
            return;
        }
        if (chooseTypeText == 0) {
            ToastUtils.showShort("请选择狗狗或者猫咪");
            return;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("context", editContext);
        map.put("flag", chooseTypeText);
        map.put("location", edit1.getText().toString());
        map.put("mobile", edit2.getText().toString());
        map.put("qq", edit3.getText().toString());
        map.put("wechat", edit4.getText().toString());
        //String[] images = new String[3];
        //map.put("images", images);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().addNews(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            //mView.onSuccess(body.getData().getData());
                            finish();
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }


    @OnClick({R.id.choose_pic, R.id.choose_vedio, R.id.liner_img1, R.id.liner_img2, R.id.liner_img3, R.id.liner_img4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.choose_pic:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .loadImageEngine(GlideEngine.createGlideEngine())
                        .maxSelectNum(4)
                        .isSingleDirectReturn(true)
                        .compress(true)// 是否压缩
                        .forResult(PictureConfig.TYPE_IMAGE);
                break;
            case R.id.choose_vedio:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofVideo())
                        .loadImageEngine(GlideEngine.createGlideEngine())
                        .maxSelectNum(1)
                        .forResult(PictureConfig.TYPE_VIDEO);
                break;
            case R.id.liner_img1:
                //PictureSelector.create(this).externalPictureVideo("/storage/emulated/0/DCIM/Camera/VID_20191214_15291065.mp4");
                PictureSelector.create(this).externalPictureVideo("https://api.atatakai.cn/api/v1/public/file/1576417892905218594.mp4");
                break;
            case R.id.liner_img2:
                break;
            case R.id.liner_img3:
                break;
            case R.id.liner_img4:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.TYPE_IMAGE:
                    List<LocalMedia> selectList1 = PictureSelector.obtainMultipleResult(data);
                    linerImg.setVisibility(View.VISIBLE);
                    choosePic.setVisibility(View.INVISIBLE);
                    chooseVedio.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < selectList1.size(); i++) {
                        Glide.with(this).load(selectList1.get(i).getCompressPath()).into(getImge(i));
                    }
                    break;
                case PictureConfig.TYPE_VIDEO:
                    List<LocalMedia> selectList2 = PictureSelector.obtainMultipleResult(data);
                    linerImg.setVisibility(View.VISIBLE);
                    choosePic.setVisibility(View.INVISIBLE);
                    chooseVedio.setVisibility(View.INVISIBLE);

                    LogUtils.d("dxy", selectList2.get(0).getPath());
                    Glide.with(this)
                            .load(Uri.fromFile(new File(selectList2.get(0).getPath())))
                            .into(linerImg1);

                    break;
            }

        }

    }


    private ImageView getImge(int i) {
        switch (i) {
            case 0:
                return linerImg1;
            case 1:
                return linerImg2;
            case 2:
                return linerImg3;
            case 3:
                return linerImg4;
        }
        return linerImg1;
    }

    public void back(View view) {
        finish();
    }


    @OnClick(R.id.choose_type)
    public void onViewClicked() {
        CustomPartShadowPopupView popupView = new CustomPartShadowPopupView(this);
        popupView.setOnClick(i -> {
            chooseType.setText(i);
            if (i.equals("猫咪")){
                chooseTypeText= 2;
            }else {
                chooseTypeText= 1;
            }


        });
        new XPopup.Builder(this)
                .atView(chooseType)
                .asCustom(popupView)
                .show();
    }

    public void fabu(View view) {
        addNews();
    }
}
