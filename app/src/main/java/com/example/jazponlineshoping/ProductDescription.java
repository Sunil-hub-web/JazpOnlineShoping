package com.example.jazponlineshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDescription extends AppCompatActivity {

    ImageView product_Image;
    TextView text_productName,text_producPrice;
    Uri imageUri;
    String name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        product_Image = findViewById(R.id.product_Image);
        text_productName = findViewById(R.id.productName);
        text_producPrice = findViewById(R.id.producPrice);

        Intent intent = getIntent();
        name = intent.getStringExtra("productname");
        price = intent.getStringExtra("productprice");
        //imageUri = Uri.parse(getIntent().getExtras().getString("productimage"));

        //Log.d("image",imageUri.toString());


        //product_Image.setImageURI(imageUri);
        text_productName.setText(name);
        text_producPrice.setText(price);


    }
}