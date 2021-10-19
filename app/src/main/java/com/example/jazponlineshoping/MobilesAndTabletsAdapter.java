package com.example.jazponlineshoping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MobilesAndTabletsAdapter extends RecyclerView.Adapter<MobilesAndTabletsAdapter.ViewModel> {

    Context context;
    int [] image;

    public MobilesAndTabletsAdapter(Context context, int[] images) {

        this.context = context;
        this.image = images;
    }

    @NonNull
    @Override
    public MobilesAndTabletsAdapter.ViewModel onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobileandtalets,parent,false);

        return new ViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MobilesAndTabletsAdapter.ViewModel holder, int position) {

        holder.product_image.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewModel extends RecyclerView.ViewHolder {

        ImageView product_image;

        public ViewModel(@NonNull View itemView) {
            super(itemView);

            product_image = itemView.findViewById(R.id.product_image);
        }
    }
}
