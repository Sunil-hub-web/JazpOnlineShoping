package com.example.jazponlineshoping.activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jazponlineshoping.R;

import java.util.ArrayList;

public class AddressArrayAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> page;


    public AddressArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);

        this.context = context;
        this.page = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sub_cat_item, null);

        TextView description = (TextView) view.findViewById(R.id.heading);

        description.setText(page.get(position));

        return view;
    }
}
