package com.example.jazponlineshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.myDraw);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        HomePage home = new HomePage();
        ft.replace(R.id.frame, home,"testID");
        ft.commit();
    }

    public void Clickmenu(View view){

        // open drawer
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout){

        // opendrawer layout
        drawerLayout.openDrawer(Gravity.RIGHT);
    }

}