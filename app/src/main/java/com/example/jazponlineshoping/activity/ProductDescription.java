package com.example.jazponlineshoping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.adapter.SliderAdpter;
import com.example.jazponlineshoping.modelclass.ShowImage_ModelClass;

import java.util.ArrayList;

public class ProductDescription extends AppCompatActivity {

    TextView text_productName,text_producPrice,text_description_Details;
    String name,price;
    String image;

    LinearLayout dots_container;
    ViewPager2 showImageViewPager2;
    SliderAdpter sliderAdpter;

    TextView [] dots;

    ArrayList<ShowImage_ModelClass> showImage = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        text_productName = findViewById(R.id.productName);
        text_producPrice = findViewById(R.id.producPrice);
        dots_container = findViewById(R.id.dots_container);
        showImageViewPager2 = findViewById(R.id.showImageViewPager2);
        text_description_Details = findViewById(R.id.text_description_Details);

        text_description_Details.setText("The mobile phone can be used to communicate over long distances without wires. It works by communicating with a nearby base station (also called a \"mobile tower\") which connects it to the main phone network. When moving, if the mobile phone gets too far away from the cell it is connected to, that cell sends a message to another cell to tell the new cell to take over the call. This is called a \"hand off,\" and the call continues with the new cell the phone is connected to. The hand-off is done so well and carefully that the user will usually never even know that the call was transferred to another cell.\n" +
                "\n" +
                "As mobile phones became more popular, they began to cost less money, and more people could afford them. Monthly plans became available for rates as low as US$30 or US$40 a month. Cell phones have become so cheap to own that they have mostly replaced pay phones and phone booths except for urban areas with many people.\n");

        Intent intent = getIntent();

        image = intent.getStringExtra("productimage");
        name = intent.getStringExtra("productname");
        price = intent.getStringExtra("productprice");

        int intImage = Integer.valueOf(image);

        text_productName.setText(name);
        text_producPrice.setText(price);

        showImage.add(new ShowImage_ModelClass(image));
        showImage.add(new ShowImage_ModelClass(image));
        showImage.add(new ShowImage_ModelClass(image));
        showImage.add(new ShowImage_ModelClass(image));
        showImage.add(new ShowImage_ModelClass(image));


        sliderAdpter = new SliderAdpter(ProductDescription.this,showImage);
        showImageViewPager2.setAdapter(sliderAdpter);

        int arraysize = showImage.size();

        dots = new TextView[arraysize];

        dotsIndicator();

        showImageViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicatorPosition(position);
                super.onPageSelected(position);
            }
        });
    }

    private void selectedIndicatorPosition(int position) {


        for(int i=0;i<dots.length;i++){


            if(i==position){

                dots[i].setTextColor(getResources().getColor(R.color.yellow));

            }else{

                dots[i].setTextColor(getResources().getColor(R.color.grey));
            }
        }

    }

    private void dotsIndicator() {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                                         LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);

        for(int i=0;i<dots.length;i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(20);
            dots[i].setPadding(5, 0, 5, 0);
            dots[i].setLayoutParams(params);
            dots_container.addView(dots[i]);
        }
    }
}