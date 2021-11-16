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
import com.example.jazponlineshoping.modelclass.MobileDetails_ModelClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryMobilesTabletsAdapter extends RecyclerView.Adapter<CategoryMobilesTabletsAdapter.ViewHolder> {

    Context context;
    ArrayList<MobileDetails_ModelClass> mobile_details;

    public CategoryMobilesTabletsAdapter(CategoryPage categoryPage, ArrayList<MobileDetails_ModelClass> mobileImage) {

        this.context = categoryPage;
        this.mobile_details = mobileImage;

    }

    @NonNull
    @NotNull
    @Override
    public CategoryMobilesTabletsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_mobile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryMobilesTabletsAdapter.ViewHolder holder, int position) {

        MobileDetails_ModelClass mobile = mobile_details.get(position);

        holder.product_Image.setImageResource(mobile.getIamge());
        holder.productName.setText(mobile.getName());

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
        return mobile_details.size();
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
