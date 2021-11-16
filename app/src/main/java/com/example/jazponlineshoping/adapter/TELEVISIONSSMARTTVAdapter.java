package com.example.jazponlineshoping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jazponlineshoping.activity.ProductDetailsActivity;
import com.example.jazponlineshoping.R;

public class TELEVISIONSSMARTTVAdapter extends RecyclerView.Adapter<TELEVISIONSSMARTTVAdapter.MyViewholder> {

    Context context;
    int [] image;

    public TELEVISIONSSMARTTVAdapter(Context context, int[] images1) {

        this.context = context;
        this.image = images1;
    }

    @NonNull
    @Override
    public TELEVISIONSSMARTTVAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.televisions,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TELEVISIONSSMARTTVAdapter.MyViewholder holder, int position) {

        holder.product_image.setImageResource(image[position]);

        holder.product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ProductDetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        ImageView product_image;

        public MyViewholder(@NonNull  View itemView) {
            super(itemView);

            product_image = itemView.findViewById(R.id.product_image);
        }
    }
}
