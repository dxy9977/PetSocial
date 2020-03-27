package com.example.petsocial.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petsocial.R;
import com.gyf.immersionbar.ImmersionBar;

public class SetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }
}
