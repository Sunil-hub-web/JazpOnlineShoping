package com.example.jazponlineshoping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.jazponlineshoping.adapter.CategoryMobilesTabletsAdapter;
import com.example.jazponlineshoping.adapter.CategoryTelevisionsSmartTvAdapter;
import com.example.jazponlineshoping.modelclass.MobileDetails_ModelClass;
import com.example.jazponlineshoping.modelclass.TelevisionDetails_ModelClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CategoryPage extends AppCompatActivity {

    RecyclerView showProductrecycler;
    GridLayoutManager gridLayoutManager;
    BottomNavigationView bottomNavigation;
    CategoryMobilesTabletsAdapter mobilesAndTabletsAdapter;
    CategoryTelevisionsSmartTvAdapter televisionssmarttvAdapter;
    ImageView img_Lenovo,img_Hp,img_Back;
    DrawerLayout mydrawer;

    ArrayList<MobileDetails_ModelClass> mobileImage = new ArrayList<>();
    ArrayList<TelevisionDetails_ModelClass> televisionImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);

        showProductrecycler = findViewById(R.id.showProductrecycler);
        img_Lenovo = findViewById(R.id.img_Lenovo);
        img_Hp = findViewById(R.id.img_Hp);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        mydrawer = findViewById(R.id.mydrawer);
        img_Back = findViewById(R.id.img_Back);

        mobileImage.add(new MobileDetails_ModelClass("MobilePhone",R.drawable.mob2));
        mobileImage.add(new MobileDetails_ModelClass("Tablets",R.drawable.download_dd));
        mobileImage.add(new MobileDetails_ModelClass("Tablets Accessories",R.drawable.laptop_accessories));
        mobileImage.add(new MobileDetails_ModelClass("Mobile  Accessories",R.drawable.images_ddd));
        mobileImage.add(new MobileDetails_ModelClass("Smart Wearable",R.drawable.smart));

        televisionImage.add(new TelevisionDetails_ModelClass("Television1",R.drawable.tv2));
        televisionImage.add(new TelevisionDetails_ModelClass("Television2",R.drawable.tv3));
        televisionImage.add(new TelevisionDetails_ModelClass("Television3",R.drawable.tv4));
        televisionImage.add(new TelevisionDetails_ModelClass("Television4",R.drawable.tv5));
        televisionImage.add(new TelevisionDetails_ModelClass("Television5",R.drawable.tv6));
        televisionImage.add(new TelevisionDetails_ModelClass("Television6",R.drawable.tv7));

        img_Back.setVisibility(View.GONE);

        gridLayoutManager = new GridLayoutManager(CategoryPage.this,2,GridLayoutManager.VERTICAL,false);
        mobilesAndTabletsAdapter = new CategoryMobilesTabletsAdapter(CategoryPage.this, mobileImage);
        showProductrecycler.setLayoutManager (gridLayoutManager);
        showProductrecycler.setHasFixedSize (true);
        showProductrecycler.setAdapter (mobilesAndTabletsAdapter);

        img_Lenovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gridLayoutManager = new GridLayoutManager(CategoryPage.this,2,GridLayoutManager.VERTICAL,false);
                mobilesAndTabletsAdapter = new CategoryMobilesTabletsAdapter(CategoryPage.this, mobileImage);
                showProductrecycler.setLayoutManager (gridLayoutManager);
                showProductrecycler.setHasFixedSize (true);
                showProductrecycler.setAdapter (mobilesAndTabletsAdapter);
            }
        });

        img_Hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gridLayoutManager = new GridLayoutManager(CategoryPage.this,2,GridLayoutManager.VERTICAL,false);
                televisionssmarttvAdapter = new CategoryTelevisionsSmartTvAdapter(CategoryPage.this, televisionImage);
                showProductrecycler.setLayoutManager (gridLayoutManager);
                showProductrecycler.setHasFixedSize (true);
                showProductrecycler.setAdapter (televisionssmarttvAdapter);


            }
        });

        bottomNavigation.setSelectedItemId(R.id.category);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), LoginPage.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                    case R.id.category:
                         return true;

                   /* case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SerachPage.class));
                        overridePendingTransition(0, 0);
                        return true;*/

                }
                return false;
            }
        });

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

        MainActivity.reDirectActivity(this,Cartpage.class);

    }

}