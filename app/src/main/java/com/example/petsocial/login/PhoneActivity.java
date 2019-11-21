package com.example.petsocial.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.petsocial.R;
import com.example.petsocial.ui.BaseActivity;
import com.example.petsocial.ui.SelectActivity;

public class PhoneActivity extends BaseActivity {
    private EditText name, code;
    private TextView codeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        name = findViewById(R.id.phone_name);
        code = findViewById(R.id.phone_code);
        codeBtn = findViewById(R.id.phone_code_btn);
    }

    public void btnLogin(View view) {
        startActivity(new Intent(this, SelectActivity.class));
        finish();
    }

    private CountDownTimer cdTimer = new CountDownTimer(60300, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            codeBtn.setText(millisUntilFinished / 1000 + " s");
            codeBtn.setClickable(false);
        }

        @Override
        public void onFinish() {
            codeBtn.setClickable(true);
            codeBtn.setText("重新获取");
        }
    };


    @Override
    protected void onDestroy() {
        cdTimer.onFinish();
        super.onDestroy();
    }

    public void getPhoneCode(View view) {
        cdTimer.start();
    }

    public void btnBack(View view) {
        finish();
    }
}
