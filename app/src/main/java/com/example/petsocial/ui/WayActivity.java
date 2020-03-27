package com.example.petsocial.ui;


import android.content.Intent;
import android.view.View;
import android.widget.Switch;

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

public class WayActivity extends BaseActivity {

    @BindView(R.id.activity_way_switch1)
    Switch activityWaySwitch1;
    @BindView(R.id.activity_way_switch2)
    Switch activityWaySwitch2;
    @BindView(R.id.activity_way_switch3)
    Switch activityWaySwitch3;


    private int add = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_way;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        add = getIntent().getIntExtra("add", 1);
        switch (add) {
            case 1:
                activityWaySwitch1.setEnabled(false);
                activityWaySwitch2.setEnabled(false);
                activityWaySwitch3.setChecked(true);
                break;
            case 2:
                activityWaySwitch1.setChecked(true);
                break;
            case 3:
                activityWaySwitch2.setChecked(true);
                break;
            case 4:
                activityWaySwitch1.setChecked(true);
                activityWaySwitch2.setChecked(true);
                break;
        }


        activityWaySwitch3.setOnCheckedChangeListener((b, is) -> {
            if (is) {
                activityWaySwitch1.setChecked(false);
                activityWaySwitch2.setChecked(false);
                activityWaySwitch1.setEnabled(false);
                activityWaySwitch2.setEnabled(false);
            } else {
                activityWaySwitch1.setEnabled(true);
                activityWaySwitch2.setEnabled(true);
            }
        });
    }

    public void loadData() {

        showDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("add", getAdd());
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().modifyAccount(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            if (body.isSuccess()) {
                                startActivity(new Intent(this, MainShowActivity.class));
                                finish();
                            } else {
                                ToastUtils.showShort(body.getMessage());
                            }
                            closeDialog();
                        }, throwable ->
                        {
                            ToastUtils.showShort(throwable.getMessage());
                            closeDialog();
                        }
                );
    }

    private int getAdd() {
        boolean checked1 = activityWaySwitch1.isChecked();
        boolean checked2 = activityWaySwitch2.isChecked();
        boolean checked3 = activityWaySwitch3.isChecked();


        if (checked1 && checked2) return 4;
        if (checked1) return 2;
        if (checked2) return 3;


        return 1;
    }


    public void back(View view) {
        finish();
    }
}
