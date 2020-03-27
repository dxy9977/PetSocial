package com.example.petsocial.common;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.entity.AccountEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountDbUtil {
    private Map<Integer, AccountEntity> map = new HashMap<>();
    private static AccountDbUtil mInstance;

    public static AccountDbUtil getInstance() {
        if (mInstance == null) {
            synchronized (AccountDbUtil.class) {
                if (mInstance == null) {
                    mInstance = new AccountDbUtil();
                }
            }
        }
        return mInstance;
    }


    public void loadInfo(int i) {
        NetWorkManager.getServerApi().getInfo(i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                AccountEntity ae = new AccountEntity();
                                ae.setId(body.getData().getId());
                                ae.setAdd(body.getData().getAdd());
                                ae.setAvatar(body.getData().getAvatar());
                                ae.setCreateAt(body.getData().getCreateAt());
                                ae.setFlag(body.getData().getFlag());
                                ae.setGender(body.getData().getGender());
                                ae.setName(body.getData().getName());
                                ae.setMobile(body.getData().getMobile());
                                ae.setWechat(body.getData().getWechat());
                                ae.setUpdateAt(body.getData().getUpdateAt());
                                insertOrReplace(ae);
                                map.put(i, ae);
                            }
                        }, throwable ->
                                ToastUtils.showShort(throwable.getMessage())

                );
    }


    public boolean isUserInfo(int i) {
        loadInfo(i);
        return map.containsKey(i);
    }

    public AccountEntity getUserInfo(int i) {
        return map.get(i);
    }


    public boolean insertOrReplace(AccountEntity entity) {
        try {
            DBManager.getInstance().getDaoSession().getAccountEntityDao().insertOrReplace(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void queryList() {
        List<AccountEntity> list = null;
        list = DBManager.getInstance().getDaoSession().getAccountEntityDao()
                .queryBuilder()
                .build().list();
        LogUtils.d("dxy", list.size());
        for (int i = 0; i < list.size(); i++) {
            AccountEntity accountEntity = list.get(i);
            map.put((int) accountEntity.getId(), accountEntity);
        }
    }
}
