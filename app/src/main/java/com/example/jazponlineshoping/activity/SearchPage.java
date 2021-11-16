package com.example.jazponlineshoping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jazponlineshoping.R;

public class SearchPage extends AppCompatActivity {

    ImageView img_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        img_Back = findViewById(R.id.img_Back);

        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}