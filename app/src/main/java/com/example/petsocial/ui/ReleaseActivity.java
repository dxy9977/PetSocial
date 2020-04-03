package com.example.petsocial.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
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
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ReleaseActivity extends BaseActivity implements OnResultCallbackListener<LocalMedia> {


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


    private List<String> picList = new ArrayList<>();
    private String videoAddress;


    private int chooseTypeText;
    private int imageLocation = 0;


    private void updatePic() {
        linerImg1.setImageResource(0);
        linerImg2.setImageResource(0);
        linerImg3.setImageResource(0);
        linerImg4.setImageResource(0);
        imageLocation = picList.size();
        //没有数据
        if (TextUtils.isEmpty(videoAddress) && picList.size() == 0) {
            linerImg1.setImageResource(R.drawable.pic_add);
            return;
        }
        //至少有一张图片
        if (TextUtils.isEmpty(videoAddress)) {
            for (int i = 0; i < picList.size(); i++) {
                Glide.with(this)
                        .load(picList.get(i))
                        .placeholder(R.drawable.my_icon)
                        .error(R.drawable.my_icon)
                        .into(getPicture(i));
            }
            if (picList.size() < 4) {
                getPicture(picList.size()).setImageResource(R.drawable.pic_add);
            }
            return;
        }
        //有一条视频
        if (picList.size() == 0) {

        }

    }

    private ImageView getPicture(int i) {
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

        setImgs();
    }


    private void addNewss(String imgs) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("note", activityAddEditContext.getText().toString());
        map.put("img_src", imgs);

        //map.put("flag", chooseTypeText);
        //map.put("location", edit1.getText().toString());
        //map.put("mobile", edit2.getText().toString());
        //map.put("qq", edit3.getText().toString());
        //map.put("wechat", edit4.getText().toString());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().pushMoments(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            String str = body.string();
                            JSONObject jb = new JSONObject(str);
                            if (jb.getBoolean("success")) {
                                finish();
                            } else {
                                ToastUtils.showShort(jb.getString("message"));
                            }

                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }


    @OnClick({R.id.liner_img1, R.id.liner_img2, R.id.liner_img3, R.id.liner_img4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.liner_img1:
                btnImg(0);
                break;
            case R.id.liner_img2:
                btnImg(1);
                break;
            case R.id.liner_img3:
                btnImg(2);
                break;
            case R.id.liner_img4:
                btnImg(3);
                break;
        }
    }


    private void btnImg(int i) {
        if (imageLocation == i) {
            openGallery();
        } else {
            if (picList.size() > i) {
                new XPopup.Builder(this)
                        .asImageViewer(getPicture(i), picList.get(i), new ImageLoader())
                        .show();
            }
        }
    }


    private void openGallery() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofAll())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .maxSelectNum(4)
                .maxVideoSelectNum(1)
                .queryMaxFileSize(10)// 只查多少10m以内的图片、视频、音频  单位M
                .isSingleDirectReturn(true)
                .compress(true)// 是否压缩
                .forResult(this);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.TYPE_IMAGE:
                    //选择图片
                    List<LocalMedia> selectList1 = PictureSelector.obtainMultipleResult(data);
                    linerImg.setVisibility(View.VISIBLE);
                    for (int i = 0; i < selectList1.size(); i++) {
                        picList.add(selectList1.get(i).getCompressPath());
                    }
                    updatePic();
                    break;
                case PictureConfig.TYPE_VIDEO:
                    //选择视频
                    List<LocalMedia> selectList2 = PictureSelector.obtainMultipleResult(data);
                    linerImg.setVisibility(View.VISIBLE);
                    LogUtils.d("dxy", selectList2.get(0).getPath());
                    Glide.with(this)
                            .load(Uri.fromFile(new File(selectList2.get(0).getPath())))
                            .into(linerImg1);
                    break;
            }

        }

    }


    public void back(View view) {
        finish();
    }


    @OnClick(R.id.choose_type)
    public void onViewClicked() {
        CustomPartShadowPopupView popupView = new CustomPartShadowPopupView(this);
        popupView.setOnClick(i -> {
            chooseType.setText(i);
            if (i.equals("猫咪")) {
                chooseTypeText = 2;
            } else {
                chooseTypeText = 1;
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


    /**
     * 图库返回
     *
     * @param result
     */
    @Override
    public void onResult(List<LocalMedia> result) {
        for (LocalMedia localMedia : result) {
            if (localMedia.isCompressed()) {
                picList.add(localMedia.getCompressPath());
            } else {
                LogUtils.d("dxy", "1121212121212");
                videoAddress = localMedia.getPath();

                Glide.with(this)
                        .load(Uri.fromFile(new File(videoAddress)))
                        .into(linerImg1);
            }
            updatePic();

        }
    }

    /**
     * 上传图片信息
     */
    public void setImgs() {
        if (picList.size() == 0) return;

        List<MultipartBody.Part> list = new ArrayList<>();
        for (String path : picList) {
            File file = new File(path);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), new File(path));
            MultipartBody.Part body = MultipartBody.Part.createFormData("files", file.getName(), requestFile);
            list.add(body);
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), "news");
        NetWorkManager.getServerApi().uploads(list, requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(b -> {
                            String str = b.string();
                            JSONObject jb = new JSONObject(str);
                            if (jb.getBoolean("success")) {
                                addNewss(jb.getString("data"));
                            } else {
                                ToastUtils.showShort(jb.getString("message"));
                            }

                        }, throwable ->
                        {
                            LogUtils.d("dxy =" + throwable.getMessage());
                        }
                );
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
    public void onCancel() {

    }
}
