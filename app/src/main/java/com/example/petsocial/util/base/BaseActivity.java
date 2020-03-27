package com.example.petsocial.util.base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


public abstract class BaseActivity extends AppCompatActivity {

    private LoadingDialog dialog;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    public void showDialog() {
        if (dialog != null) {
            dialog.close();
            dialog = null;
        }
        dialog = new LoadingDialog(this);
        dialog.setLoadingText("正在加载中...")
                .setInterceptBack(false)
                .show();

    }

    public void closeDialog() {
        if (dialog != null) {
            dialog.close();
            dialog = null;
        }

    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        closeDialog();
        super.onDestroy();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();


}
