package com.example.petsocial.util.view;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;

public class MyImageLoader implements XPopupImageLoader {
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
