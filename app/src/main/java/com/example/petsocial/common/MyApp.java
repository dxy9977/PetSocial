package com.example.petsocial.common;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

public class MyApp extends Application {
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        NetWorkManager.getInstance().init();
        CrashReport.initCrashReport(getApplicationContext(), "18bcaa06a9", false);
    }

    public static MyApp getApp() {
        return app;
    }
}
