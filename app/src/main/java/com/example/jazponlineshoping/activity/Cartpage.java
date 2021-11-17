package com.example.jazponlineshoping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.adapter.CartPageAdapter;
import com.example.jazponlineshoping.modelclass.CartPage_ModelClass;

import java.util.ArrayList;

public class Cartpage extends AppCompatActivity {

    DrawerLayout mydrawer;
    TextView text_cart;
    RecyclerView recyclerCartPage;
    LinearLayoutManager linearLayoutManager;
    CartPageAdapter cartPageAdapter;

    ArrayList<CartPage_ModelClass> productDetals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpage);


        mydrawer = findViewById(R.id.myDraw);
        text_cart = findViewById(R.id.name);
        recyclerCartPage = findViewById(R.id.recyclerCartPage);

        text_cart.setText("Cart");

        productDetals.add(new CartPage_ModelClass(R.drawable.realme,"realme C11 2021","Cool Blue",
                "64 GB","4 GB RAM"," Sun Nov 21","8,499"));
        productDetals.add(new CartPage_ModelClass(R.drawable.poco,"realme 8i ","Space Black",
                "32 GB","3 GB RAM"," Sun Nov 21","9,499"));
        productDetals.add(new CartPage_ModelClass(R.drawable.realme_origi,"realme C21","Cross Blue",
                "128 GB","6 GB RAM"," Sun Nov 21","10,499"));
        productDetals.add(new CartPage_ModelClass(R.drawable.redmi,"REDMI 9i Sport","Carbon Black",
                "128 GB","4 GB RAM"," Sun Nov 21","11,499"));
        productDetals.add(new CartPage_ModelClass(R.drawable.android_samsung,"REDMI 9i Sport","Carbon Black",
                "64 GB","3 GB RAM"," Sun Nov 21","12,499"));

        linearLayoutManager = new LinearLayoutManager(Cartpage.this,LinearLayoutManager.VERTICAL,false);
        cartPageAdapter = new CartPageAdapter(Cartpage.this,productDetals);
        recyclerCartPage.setLayoutManager(linearLayoutManager);
        recyclerCartPage.setHasFixedSize(true);
        recyclerCartPage.setAdapter(cartPageAdapter);


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

        MainActivity.reDirectActivity(this,MainActivity.class);

    }

}