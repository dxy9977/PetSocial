package com.example.petsocial.util.view;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

/**
 * 作者：叶应是叶
 * 时间：2017/8/20 11:39
 * 描述：
 */
public class IndexControl {

    private final RecyclerView listView;

    private final TextView tv_hint;

    private final Map<String, Integer> letterMap;

    public IndexControl(RecyclerView contactsListView, LetterIndexView letterIndexView,
                        TextView tv_hint, Map<String, Integer> letterMap) {
        this.listView = contactsListView;
        this.tv_hint = tv_hint;
        this.letterMap = letterMap;
        letterIndexView.setOnTouchingLetterChangedListener(new LetterChangedListener());
    }

    private class LetterChangedListener implements LetterIndexView.OnTouchingLetterChangedListener {

        @Override
        public void onHit(String letter) {
            tv_hint.setVisibility(View.VISIBLE);
            tv_hint.setText(letter);
            int index = -1;
            if ("↑".equals(letter)) {
                index = 0;
            } else if (letterMap.containsKey(letter)) {
                index = letterMap.get(letter);
            }
            if (index < 0) {
                return;
            }
            if (index >= 0 && index < listView.getChildCount()) {
                //listView.setSelectionFromTop(index, 0);

            }
        }

        @Override
        public void onCancel() {
            tv_hint.setVisibility(View.INVISIBLE);
        }
    }

}
