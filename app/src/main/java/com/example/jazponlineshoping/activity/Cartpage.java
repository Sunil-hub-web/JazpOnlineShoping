package com.example.jazponlineshoping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jazponlineshoping.R;

public class Cartpage extends AppCompatActivity {

    DrawerLayout mydrawer;
    TextView text_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpage);


        mydrawer = findViewById(R.id.myDraw);
        text_cart = findViewById(R.id.name);

        text_cart.setText("Cart");
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