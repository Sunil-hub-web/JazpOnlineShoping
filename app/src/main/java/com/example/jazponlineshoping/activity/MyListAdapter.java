package com.example.jazponlineshoping.activity;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazponlineshoping.R;

import java.util.ArrayList;

public class MyListAdapter implements ListAdapter {

    Context context;
    ArrayList<String> page;

    public MyListAdapter(ProductDescription productDescription, ArrayList<String> addaddress) {

        this.context  =productDescription;
        this.page = addaddress;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return page.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.sub_cat_item, null);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, page.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        TextView tittle = convertView.findViewById(R.id.heading);
        tittle.setText(page.get(position));
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return page.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
