package com.example.petsocial.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.petsocial.login.MainActivity;
import com.example.petsocial.R;
import com.example.petsocial.ui.BaseActivity;

public class RegisterActivity extends BaseActivity {
    private EditText name, code, psd;
    private TextView codeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.register_name);
        code = findViewById(R.id.register_code);
        psd = findViewById(R.id.register_psd);
        codeBtn = findViewById(R.id.register_code_btn);
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

    public void btnRegister(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnBack(View view) {
        finish();
    }
}
