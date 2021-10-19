package com.example.jazponlineshoping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    Context context;
    //ArrayList<Integer> image;
   // ArrayList<String> name;
    ArrayList<ProductDetails> product;
    private RecyclerViewClickInterface recyclerViewClickInterface;

  /*  public ProductDetailsAdapter(Context context, ArrayList<Integer> images2, ArrayList<String> productname, RecyclerViewClickInterface recyclerViewClickInterface) {

        this.context = context;
        this.image = images2;
        this.name = productname;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }*/

    public ProductDetailsAdapter(Context context, ArrayList<ProductDetails> productDetails, RecyclerViewClickInterface recyclerViewClickInterface) {

        this.context = context;
        this.product = productDetails;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public ProductDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ProductDetailsAdapter.ViewHolder holder, int position) {

        /*holder.pimage.setImageResource(image.get(position));
        holder.pname.setText(name.get(position));*/

        ProductDetails productDetails = product.get(position);

        holder.pimage.setImageResource(productDetails.getImage());
        holder.pname.setText(productDetails.getName());

    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pimage;
        TextView pname;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            pimage = itemView.findViewById(R.id.pimage);
            pname = itemView.findViewById(R.id.pname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    recyclerViewClickInterface.onLongItemClick(getAdapterPosition());

                    return true;
                }
            });
        }
    }
}
