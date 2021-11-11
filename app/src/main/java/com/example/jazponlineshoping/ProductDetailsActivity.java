package com.example.jazponlineshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazponlineshoping.adapter.CategoryMobilesTabletsAdapter;
import com.example.jazponlineshoping.adapter.CategoryProductDetailsAdapter;
import com.example.jazponlineshoping.modelclass.Productdetails_ModelClass;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {

    DrawerLayout mydrawer;
    TextView text_cart;
    ImageView noproduct;
    CategoryProductDetailsAdapter productDetailsAdapter;
    RecyclerView productRecycler;
    GridLayoutManager gridLayoutManager;
    ArrayList<Productdetails_ModelClass> productDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mydrawer = findViewById(R.id.myDraw);
        text_cart = findViewById(R.id.name);
        productRecycler = findViewById(R.id.productRecycler);
        noproduct = findViewById(R.id.noproduct);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        text_cart.setText(name);

         if(name.equals("MobilePhone")){

            productDetails.add(new Productdetails_ModelClass("Redmi 9 (Sky Blue, 4GB RAM, 64GB Storage)","₹8,790",R.drawable.imagesuu));
            productDetails.add(new Productdetails_ModelClass("OPPO A12 4 GB 64 GB Blue","₹10,899",R.drawable.imageshh));
            productDetails.add(new Productdetails_ModelClass("Samsung Galaxy M32 5G (Slate Black, 6GB RAM, 128GB Storage)","₹16,999.00",R.drawable.down));
            productDetails.add(new Productdetails_ModelClass("OnePlus 9 5G (Astral Black, 8GB RAM, 128GB Storage)","₹46,999.00",R.drawable.android_samsung));

            if(productDetails.size()==0){

                noproduct.setVisibility(View.VISIBLE);
            }else{

                gridLayoutManager = new GridLayoutManager(ProductDetailsActivity.this,2,GridLayoutManager.VERTICAL,false);
                productDetailsAdapter = new CategoryProductDetailsAdapter(ProductDetailsActivity.this, productDetails);
                productRecycler.setLayoutManager (gridLayoutManager);
                productRecycler.setHasFixedSize (true);
                productRecycler.setAdapter (productDetailsAdapter);
            }



        }else if(name.equals("Tablets")){

             if(productDetails.size()==0){

                 noproduct.setVisibility(View.VISIBLE);

             }else{

                 Toast.makeText(this, "Array in null", Toast.LENGTH_SHORT).show();
             }


         }




       /* gridLayoutManager = new GridLayoutManager(ProductDetailsActivity.this,2,GridLayoutManager.VERTICAL,false);
        productDetailsAdapter = new CategoryProductDetailsAdapter(ProductDetailsActivity.this, productDetails);
        productRecycler.setLayoutManager (gridLayoutManager);
        productRecycler.setHasFixedSize (true);
        productRecycler.setAdapter (productDetailsAdapter);*/






    }

    public void Clickmenu(View view){
        // open drawer
        openDrawer(mydrawer);
    }

    private static void openDrawer(DrawerLayout drawerLayout){
        // opendrawer layout
        drawerLayout.openDrawer(GravityCompat.END);
    }

    public void SignInUp(View view){

        MainActivity.reDirectActivity(this,LoginPage.class);

    }

    public void Serachpage(View view){

        MainActivity.reDirectActivity(this,SearchPage.class);

    }

    public void Cartpage(View view){

        recreate();

    }

    public void ImageBack(View view){

        MainActivity.reDirectActivity(this,CategoryPage.class);

    }

}