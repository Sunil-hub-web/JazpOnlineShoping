package com.example.jazponlineshoping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jazponlineshoping.activity.ProductDescription;
import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.modelclass.ShowImage_ModelClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SliderAdpter extends RecyclerView.Adapter<SliderAdpter.ViewHOlder> {

    Context context;

    ArrayList<ShowImage_ModelClass> show_Image;

    public SliderAdpter(ProductDescription productDescription, ArrayList<ShowImage_ModelClass> showImage) {

        this.context = productDescription;
        this.show_Image = showImage;
    }

    @NonNull
    @NotNull
    @Override
    public SliderAdpter.ViewHOlder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_items,parent,false);
        return new ViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SliderAdpter.ViewHOlder holder, int position) {

        ShowImage_ModelClass slideImage = show_Image.get(position);

        String image = slideImage.getImage();
        int strImage = Integer.valueOf(image);
        holder.img_showImage.setImageResource(strImage);

    }

    @Override
    public int getItemCount() {
        return show_Image.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder {

        ImageView img_showImage;

        public ViewHOlder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_showImage = itemView.findViewById(R.id.img_showImage);
        }
    }
}
