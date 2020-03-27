package com.example.petsocial.fragment;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.adapter.FriendAdapter;
import com.example.petsocial.util.base.BaseFragment;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private FriendAdapter adapter;
    private List<String> list = new ArrayList<>();

    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 1);//底部间距
        recyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));

        adapter = new FriendAdapter();
        recyclerView.setAdapter(adapter);
        getData();

        //new IndexControl(recyclerView,)
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friend;
    }

    public void getData() {
        for (int i = 0; i <= 100; i++) {
            list.add("李" + i + "蛋");
        }
        ToastUtils.showShort(list.size());
        adapter.addData(list);
        adapter.notifyDataSetChanged();
    }

}
