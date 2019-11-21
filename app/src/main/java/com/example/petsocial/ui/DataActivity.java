package com.example.petsocial.ui;


import android.os.Bundle;
import android.view.View;

import com.example.petsocial.R;

public class DataActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    public void btnBack(View view) {
        finish();
    }
}
