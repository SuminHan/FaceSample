package com.microsoft.projectoxford.emotionsample.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.projectoxford.emotionsample.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ListViewItem> data;
    private int layout;

    public ListViewAdapter(Context context, int layout, ArrayList<ListViewItem> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ListViewItem listviewitem = data.get(position);
        ImageView icon = (ImageView) convertView.findViewById(R.id.item_image_view);
        icon.setImageBitmap(listviewitem.getBitmap());
        TextView name = (TextView) convertView.findViewById(R.id.item_text_view);
        name.setText(listviewitem.getName());
        return convertView;
    }
}