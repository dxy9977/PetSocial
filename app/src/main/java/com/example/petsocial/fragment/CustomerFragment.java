package com.example.petsocial.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.petsocial.R;
import com.example.petsocial.ui.DataActivity;
import com.example.petsocial.ui.SetPasswordActivity;
import com.example.petsocial.ui.WayActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends Fragment {

    ImageView imgHome,imgAccount,imgSet,imgPush;
    public CustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_customer, container, false);
        imgHome = inflate.findViewById(R.id.fragment_my_home);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), DataActivity.class);
                startActivity(intent);
            }
        });
        imgAccount = inflate.findViewById(R.id.fragment_my_account);
        imgAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), WayActivity.class);
                startActivity(intent);
            }
        });
        imgSet = inflate.findViewById(R.id.fragment_my_set);
        imgSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SetPasswordActivity.class);
                startActivity(intent);
            }
        });
        imgPush = inflate.findViewById(R.id.fragment_my_push);
        imgPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"该功能暂未开放",Toast.LENGTH_LONG);
            }
        });
        return inflate;
    }

}
