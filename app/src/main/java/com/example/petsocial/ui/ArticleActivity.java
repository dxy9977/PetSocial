package com.example.petsocial.ui;

import android.view.View;


import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.util.base.BaseActivity;
import com.gyf.immersionbar.ImmersionBar;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import us.feras.mdv.MarkdownView;

public class ArticleActivity extends BaseActivity {

    @BindView(R.id.markdownView)
    MarkdownView markdownView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        getArticle();
        //markdownView.loadMarkdown("\n#  撒旦撒旦阿斯顿 \n-  111111111\n-  121132313\n-  412343423\n\n \n###    我很6\n\n----\n我是傅豪杰");
    }

    public void back(View view) {
        finish();
    }

    public void getArticle() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("video", 0);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());
        NetWorkManager.getServerApi().getArticle(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            markdownView.loadMarkdown(body.getData().get(getId()).getName());
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())
                );
    }

    private int getId() {
        return getIntent().getIntExtra("id", 0);
    }
}
