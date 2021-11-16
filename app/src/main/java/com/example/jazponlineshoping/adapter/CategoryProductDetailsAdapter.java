package com.example.jazponlineshoping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jazponlineshoping.activity.ProductDescription;
import com.example.jazponlineshoping.activity.ProductDetailsActivity;
import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.modelclass.Productdetails_ModelClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryProductDetailsAdapter extends RecyclerView.Adapter<CategoryProductDetailsAdapter.ViewHolder> {

    Context context;
    ArrayList<Productdetails_ModelClass> product_details;

    public CategoryProductDetailsAdapter(ProductDetailsActivity productDetailsActivity,
                                         ArrayList<Productdetails_ModelClass> productDetails) {

           this.context = productDetailsActivity;
           this.product_details = productDetails;

    }

    @NonNull
    @NotNull
    @Override
    public CategoryProductDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productdetails,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryProductDetailsAdapter.ViewHolder holder, int position) {

        Productdetails_ModelClass product = product_details.get(position);

        holder.product_Image.setImageResource(product.getImage());
        holder.productName.setText(product.getName());
        holder.producPrice.setText(product.getPrice());

        holder.product_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int image = product.getImage();
                String strImage = String.valueOf(image);

                Intent intent = new Intent(context, ProductDescription.class);
                intent.putExtra("productname",product.getName());
                intent.putExtra("productprice",product.getPrice());

                intent.putExtra("productimage",strImage);
                //intent.putExtra("productimage",product.getImage());
                context.startActivity(intent);

            }
        });


        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int image = product.getImage();
                String strImage = String.valueOf(image);

                Intent intent = new Intent(context, ProductDescription.class);
                intent.putExtra("productname",product.getName());
                intent.putExtra("productprice",product.getPrice());

                intent.putExtra("productimage",strImage);
                //intent.putExtra("productimage",product.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return product_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView product_Image;
        TextView productName,producPrice;
        Button addToCart;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            product_Image = itemView.findViewById(R.id.product_Image);
            productName = itemView.findViewById(R.id.productName);
            producPrice = itemView.findViewById(R.id.producPrice);
            addToCart = itemView.findViewById(R.id.addToCart);
        }
    }
}
