package com.example.jazponlineshoping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.example.jazponlineshoping.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigation;
    Button btn_SignInSignUP;
    DrawerLayout mydrawer;
    NavigationView navigationView;
    ImageView img_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mydrawer = findViewById(R.id.myDraw);
       navigationView = findViewById(R.id.navigationview);
       img_Back = findViewById(R.id.img_Back);

       img_Back.setVisibility(View.GONE);

       navigationView.setNavigationItemSelectedListener(this);
       View header = navigationView.getHeaderView(0);

       btn_SignInSignUP = header.findViewById(R.id.nav_SignInSignUP);

       bottomNavigation = findViewById(R.id.bottomNavigation);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        HomePage home = new HomePage();
        ft.replace(R.id.frame, home,"testID");
        ft.commit();

      /*  btn_SignInSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mydrawer.closeDrawer(GravityCompat.END);

                Intent intent = new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);
            }
        });*/



        bottomNavigation.setSelectedItemId(R.id.home);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), LoginPage.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.category:
                        startActivity(new Intent(getApplicationContext(), CategoryPage.class));
                        overridePendingTransition(0, 0);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        mydrawer.closeDrawer(GravityCompat.END);

        return true;
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

        reDirectActivity(this,LoginPage.class);

    }
    public void Serachpage(View view){

        reDirectActivity(this,SearchPage.class);

    }

    public void Cartpage(View view){

       reDirectActivity(this,Cartpage.class);

    }

    public static void reDirectActivity(Activity activity, Class aclass){

        Intent intent = new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

}