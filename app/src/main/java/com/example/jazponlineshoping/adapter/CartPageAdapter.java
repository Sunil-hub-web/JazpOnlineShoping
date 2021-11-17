package com.example.jazponlineshoping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.activity.Cartpage;
import com.example.jazponlineshoping.modelclass.CartPage_ModelClass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CartPageAdapter extends RecyclerView.Adapter<CartPageAdapter.ViewHolder> {

    Context context;
    ArrayList<CartPage_ModelClass> cartpage;

    public CartPageAdapter(Cartpage cartpage, ArrayList<CartPage_ModelClass> productDetals) {

        this.context = cartpage;
        this.cartpage = productDetals;
    }

    @NonNull
    @NotNull
    @Override
    public CartPageAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartpage,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartPageAdapter.ViewHolder holder, int position) {

        CartPage_ModelClass cart = cartpage.get(position);

        holder.img_imageCart.setImageResource(cart.getProductImage());
        holder.text_productName.setText(cart.getProductName());
        holder.text_productColor.setText("("+cart.getProductColor()+")");
        holder.text_productDesc.setText(cart.getInternalStorage()+", "+cart.getExternalStorage());
        holder.text_DeliveryDate.setText(cart.getDeliveryDate());
        holder.text_ProductPrice.setText(cart.getProductPrice());

    }

    @Override
    public int getItemCount() {
        return cartpage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_imageCart;
        TextView text_productName,text_productColor,text_productDesc,text_DeliveryDate,text_ProductPrice;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_imageCart = itemView.findViewById(R.id.img_imageCart);
            text_productName = itemView.findViewById(R.id.text_productName);
            text_productColor = itemView.findViewById(R.id.text_productColor);
            text_productDesc = itemView.findViewById(R.id.text_productDesc);
            text_DeliveryDate = itemView.findViewById(R.id.text_DeliveryDate);
            text_ProductPrice = itemView.findViewById(R.id.text_ProductPrice);
        }
    }
}
