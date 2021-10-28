package com.example.jazponlineshoping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryPage extends AppCompatActivity {

    RecyclerView showProductrecycler;
    GridLayoutManager gridLayoutManager;
    BottomNavigationView bottomNavigation;
    MobilesAndTabletsAdapter mobilesAndTabletsAdapter;
    TELEVISIONSSMARTTVAdapter televisionssmarttvAdapter;
    ImageView img_Lenovo,img_Hp;
    int [] images = {R.drawable.mob2,R.drawable.mob3,R.drawable.mob4,R.drawable.mob6,R.drawable.mob7};
    int [] images1 = {R.drawable.tv2,R.drawable.tv3,R.drawable.tv4,R.drawable.tv5,R.drawable.tv6,R.drawable.tv7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);

        showProductrecycler = findViewById(R.id.showProductrecycler);
        img_Lenovo = findViewById(R.id.img_Lenovo);
        img_Hp = findViewById(R.id.img_Hp);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        img_Lenovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gridLayoutManager = new GridLayoutManager(CategoryPage.this,2,GridLayoutManager.VERTICAL,false);
                mobilesAndTabletsAdapter = new MobilesAndTabletsAdapter(CategoryPage.this, images);
                showProductrecycler.setLayoutManager (gridLayoutManager);
                showProductrecycler.setHasFixedSize (true);
                showProductrecycler.setAdapter (mobilesAndTabletsAdapter);
            }
        });

        img_Hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gridLayoutManager = new GridLayoutManager(CategoryPage.this,2,GridLayoutManager.VERTICAL,false);
                televisionssmarttvAdapter = new TELEVISIONSSMARTTVAdapter(CategoryPage.this, images1);
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

}