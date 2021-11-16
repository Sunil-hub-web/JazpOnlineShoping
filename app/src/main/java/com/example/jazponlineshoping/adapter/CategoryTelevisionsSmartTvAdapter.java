package com.example.jazponlineshoping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jazponlineshoping.activity.CategoryPage;
import com.example.jazponlineshoping.activity.ProductDetailsActivity;
import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.modelclass.TelevisionDetails_ModelClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryTelevisionsSmartTvAdapter extends RecyclerView.Adapter<CategoryTelevisionsSmartTvAdapter.ViewHolder> {

    Context context;
    ArrayList<TelevisionDetails_ModelClass> television_details;

    public CategoryTelevisionsSmartTvAdapter(CategoryPage categoryPage, ArrayList<TelevisionDetails_ModelClass> televisionImage) {

        this.context = categoryPage;
        this.television_details = televisionImage;
    }

    @NonNull
    @NotNull
    @Override
    public CategoryTelevisionsSmartTvAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_television,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryTelevisionsSmartTvAdapter.ViewHolder holder, int position) {

        TelevisionDetails_ModelClass television = television_details.get(position);

        holder.product_Image.setImageResource(television.getImage());
        holder.productName.setText(television.getName());

        holder.product_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",holder.productName.getText().toString().trim());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return television_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView product_Image;
        TextView productName;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            product_Image = itemView.findViewById(R.id.product_Image);
            productName = itemView.findViewById(R.id.productName);

        }
    }
}
