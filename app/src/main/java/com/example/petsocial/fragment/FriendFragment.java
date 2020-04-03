package com.example.petsocial.fragment;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.petsocial.R;
import com.example.petsocial.adapter.FriendAdapter;
import com.example.petsocial.common.NetWorkManager;
import com.example.petsocial.util.base.BaseFragment;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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

        loadFriend();
        //new IndexControl(recyclerView,)
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friend;
    }


    private void loadFriend() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("currentPage", 1);
        map.put("pageSize", 10);
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"), new JSONObject(map).toString());

        NetWorkManager.getServerApi().getFriendList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                            LogUtils.d("dxy");
                            if (body.isSuccess()) {
                                adapter.addData(body.getData().getItems());
                                adapter.notifyDataSetChanged();
                            } else {
                                //ToastUtils.showShort(jb.getString("message"));
                            }
                        }, throwable ->
                        {
                            LogUtils.d("dxy", throwable.getMessage());
                            ToastUtils.showShort(throwable.getMessage());
                        }
                );
    }

    @OnClick({R.id.fragment_firend_add, R.id.fragment_firend_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_firend_add:
                break;
            case R.id.fragment_firend_new:
                break;
        }
    }
}
