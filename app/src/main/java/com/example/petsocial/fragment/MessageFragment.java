package com.example.petsocial.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.example.petsocial.R;
import com.example.petsocial.adapter.MessageAdapter;
import com.example.petsocial.entity.NewsEntity;
import com.example.petsocial.mvp.contract.MessageContract;
import com.example.petsocial.mvp.presenter.MessagePresenter;
import com.example.petsocial.ui.ContextActivity;
import com.example.petsocial.ui.ReleaseActivity;
import com.example.petsocial.ui.VideoActivity;
import com.example.petsocial.util.base.BaseMvpFragment;
import com.example.petsocial.util.view.CustomPartShadowPopupView;
import com.example.petsocial.util.view.MediaFileUtil;
import com.example.petsocial.util.view.MyImageLoader;
import com.example.petsocial.util.view.RecyclerViewSpacesItemDecoration;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseMvpFragment<MessagePresenter> implements MessageContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.top_text1)
    TextView topText1;
    @BindView(R.id.top_text2)
    TextView topText2;
    @BindView(R.id.top_text3)
    TextView topText3;

    private MessageAdapter adapter;
    private List<NewsEntity> data;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(View view) {
        mPresenter = new MessagePresenter();
        mPresenter.attachView(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 20);//底部间距
        recyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        adapter = new MessageAdapter(data);
        recyclerView.setAdapter(adapter);
        mPresenter.loadData();

        adapter.setOnItemChildClickListener((a, v, p) -> {

            /*if (v.getId() == R.id.item_message_icon) {
                new XPopup.Builder(getContext())
                        .asImageViewer(((ImageView) v), R.drawable.my_icon, new MyImageLoader())
                        .show();
                return;
            }*/
            //LogUtils.d("dxy positon = ", p, "dxy" + v.getTag(), "dxy = ");
            if (MediaFileUtil.isVideoFileType(adapter.getItem(p).getVideo())) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("data", adapter.getItem(p).getVideo());
                startActivity(intent);
                return;
            }

            List<Object> list = new ArrayList<>();
            List<String> images = adapter.getData().get(p).getImages();
            if (images == null || ((int) v.getTag()) >= images.size()) return;
            list.addAll(images);
            new XPopup.Builder(getContext()).asImageViewer(((ImageView) v), ((int) v.getTag()), list, (p1, p2) -> {
                //p1.updateSrcView(((ImageView) adapter.getViewByPosition(p, getId(p2))));
                //adapter.getViewByPosition(p, getId(p2));
            }, new MyImageLoader())
                    .show();

        });

        adapter.setOnItemClickListener((a, v, p) -> {
            Intent intent = new Intent(getContext(), ContextActivity.class);
            intent.putExtra("data", adapter.getData().get(p));
            startActivity(intent);
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void success(List<NewsEntity> body) {
        adapter.addData(body);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.message_tvRelease)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), ReleaseActivity.class));
    }

    @OnClick({R.id.top_text1, R.id.top_text2, R.id.top_text3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_text1:

                break;
            case R.id.top_text2:
                CustomPartShadowPopupView popupView = new CustomPartShadowPopupView(getContext());
                popupView.setOnClick(i -> {
                    LogUtils.d("dxy", i);
                });
                new XPopup.Builder(getContext())
                        .atView(topText2)
                        .asCustom(popupView)
                        .show();
                break;
            case R.id.top_text3:
                break;
        }
    }
}
