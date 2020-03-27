package com.example.petsocial.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.example.petsocial.R;
import com.example.petsocial.fragment.CustomerFragment;
import com.example.petsocial.fragment.FirstFragment;
import com.example.petsocial.fragment.FriendFragment;
import com.example.petsocial.fragment.MessageFragment;
import com.example.petsocial.util.base.BaseActivity;
import com.gyf.immersionbar.ImmersionBar;
import com.lzy.widget.AlphaIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainShowActivity extends BaseActivity {
    private List<Fragment> list = new ArrayList<>();
    private ViewPager viewPager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main_show;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        list.add(new FirstFragment());
        list.add(new FriendFragment());
        list.add(new MessageFragment());
        list.add(new CustomerFragment());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        AlphaIndicator alphaIndicator = findViewById(R.id.alphaIndicator);
        alphaIndicator.setViewPager(viewPager);
    }


    class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
