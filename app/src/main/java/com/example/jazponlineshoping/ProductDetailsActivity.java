package com.example.jazponlineshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    DrawerLayout mydrawer;
    TextView text_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mydrawer = findViewById(R.id.myDraw);
        text_cart = findViewById(R.id.name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        text_cart.setText(name);

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