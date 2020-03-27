package com.example.petsocial.common;

import com.example.petsocial.greendao.DaoMaster;
import com.example.petsocial.greendao.DaoSession;

/**
 * 数据库管理类
 */
public class DBManager {
    final static String DB_NAME = "xxx_db";
    private static DBManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DBManager() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), DB_NAME, null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static DBManager getInstance() {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager();
                }
            }
        }
        return mInstance;
    }
}

