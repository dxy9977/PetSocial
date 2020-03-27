package com.example.petsocial.util.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petsocial.R;
import com.lxj.xpopup.impl.PartShadowPopupView;

public class CustomPartShadowPopupView extends PartShadowPopupView implements View.OnClickListener {
    private OnClick onClick;
    private TextView text1, text2;

    public CustomPartShadowPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_part_shadow_popup; // 编写你自己的布局
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        // 实现一些UI的初始和逻辑处理
        text1 = findViewById(R.id.custom_text1);
        text2 = findViewById(R.id.custom_text2);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.custom_text1:
                if (onClick != null) onClick.click("狗狗");
                break;

            case R.id.custom_text2:
                if (onClick != null) onClick.click("喵咪");
                break;
        }
        dismiss();
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick {
        void click(String i);
    }
}
