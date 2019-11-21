package com.example.petsocial.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.petsocial.R;

public class SelectActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void btnEnter(View view){
        Intent intent = new Intent();
        intent.setClass(this,MainShowActivity.class);
        this.startActivity(intent);
    }
}
