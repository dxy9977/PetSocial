package com.example.petsocial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petsocial.R;

import java.util.ArrayList;
import java.util.List;

public class FirstListAdapter extends BaseAdapter {
    private List<String> list = new ArrayList();
    private LayoutInflater inflater;
    public FirstListAdapter(List list, Context context){
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_friend_listview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.imageView.setImageResource(R.drawable.cat);
        viewHolder.textView.setText(list.get(position));

        return convertView;
    }

    class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View view){
            imageView = view.findViewById(R.id.item_first_img);
            textView = view.findViewById(R.id.item_first_name);
        }
    }
}
