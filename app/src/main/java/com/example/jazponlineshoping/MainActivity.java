package com.example.jazponlineshoping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mydrawer;
    NavigationView navigationView;
    BottomNavigationView bottomNavigation;
    Button btn_SignInSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydrawer = findViewById(R.id.myDraw);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        navigationView = findViewById(R.id.navigationview);

        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        btn_SignInSignUP = header.findViewById(R.id.nav_SignInSignUP);

        btn_SignInSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,LoginPage.class);
                startActivity(intent);

            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        HomePage home = new HomePage();
        ft.replace(R.id.frame, home,"testID");
        ft.commit();

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
        mydrawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void Clickmenu(View view){

        // open drawer
        openDrawer(mydrawer);
    }

    private static void openDrawer(DrawerLayout drawerLayout){

        // opendrawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
}