package com.example.petsocial.ui;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.util.base.BaseActivity;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SelectActivity extends BaseActivity {

    @BindView(R.id.ck_1)
    CheckBox ck1;
    @BindView(R.id.ck_2)
    CheckBox ck2;
    @BindView(R.id.activity_select_but2)
    Button submit;

    private boolean choice1, choice2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select;
    }

    @Override
    public void initView() {
        ck1.setOnCheckedChangeListener((button, b) -> {
            choice1 = b;
            if (!choice1 && !choice2) {
                submit.setEnabled(false);
            } else {
                submit.setEnabled(true);
            }
        });
        ck2.setOnCheckedChangeListener((button, b) -> {
            choice2 = b;
            if (!choice1 && !choice2) {
                submit.setEnabled(false);
            } else {
                submit.setEnabled(true);
            }
        });
    }

    public void btnAll(View view) {
        ck1.setChecked(true);
        ck2.setChecked(true);
    }

    public void submit(View view) {
        loadData();

    }


    public void loadData() {
        showDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "fhj");
        map.put("interest", getType());
        map.put("Privacy_status", 1);

        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().updateUserFirst(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            LogUtils.d("dxy", body.string());
                            closeDialog();
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                            closeDialog();
                        }
                );
    }


    private int getType() {
        if (choice1) {
            return choice2 ? 3 : 2;
        }
        return 1;
    }
}
