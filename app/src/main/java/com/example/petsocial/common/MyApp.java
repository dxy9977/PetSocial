package com.example.petsocial.common;

import android.app.Application;

import com.blankj.utilcode.util.CacheDiskUtils;
import com.example.petsocial.entity.LoginEntity;
import com.tencent.bugly.crashreport.CrashReport;

public class MyApp extends Application {
    private static MyApp app;
    private LoginEntity body;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        NetWorkManager.getInstance().init();
        CrashReport.initCrashReport(getApplicationContext(), "18bcaa06a9", false);
        //AccountDbUtil.getInstance().queryList();
    }

    public static MyApp getApp() {
        return app;
    }

    public LoginEntity getBody() {
        return body == null ? ((LoginEntity) CacheDiskUtils.getInstance().getSerializable("test")) : body;
    }

    public void setBody(LoginEntity body) {
        this.body = body;
    }
}
