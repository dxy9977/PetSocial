package com.example.petsocial.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.petsocial.R;
import com.example.petsocial.adapter.FirstListAdapter;
import com.example.petsocial.ui.DataActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private ListView listView;
    FirstListAdapter adapter ;
    private List<String> list = new ArrayList<>();
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        getData();
        listView = view.findViewById(R.id.fragment_first_listview);
        adapter = new FirstListAdapter(list,getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), DataActivity.class));
            }
        });
        return view;
    }

    public  void  getData(){
        for(int i = 0;i<=100;i++){
            list.add("李"+i+"蛋");
        }
    }

}
