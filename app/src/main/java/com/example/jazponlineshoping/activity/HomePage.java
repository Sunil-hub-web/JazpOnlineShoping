package com.example.jazponlineshoping.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.jazponlineshoping.R;
import com.example.jazponlineshoping.RecyclerViewClickInterface;
import com.example.jazponlineshoping.adapter.MobilesAndTabletsAdapter;
import com.example.jazponlineshoping.adapter.ProductDetailsAdapter;
import com.example.jazponlineshoping.adapter.TELEVISIONSSMARTTVAdapter;
import com.example.jazponlineshoping.adapter.ViewPagerAdapter;
import com.example.jazponlineshoping.modelclass.ProductDetails;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomePage extends Fragment implements RecyclerViewClickInterface {

    ViewPager viewPager;
    int currentPage = 0;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 4000;
    private int dotscount;
    Context context;
    private static final int NUM_PAGES = 4 ;
    MobilesAndTabletsAdapter mobilesAndTabletsAdapter;
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    LinearLayoutManager linearLayoutManager,linearLayoutManager1,linearLayoutManager2;
    int [] images = {R.drawable.mob2,R.drawable.mob3,R.drawable.mob4,R.drawable.mob6,R.drawable.mob7};
    TELEVISIONSSMARTTVAdapter televisionssmarttvAdapter;
    ImageView img_Back;

    ArrayList<Integer> images2 = new ArrayList<Integer>();
    ArrayList<String> productname = new ArrayList<String>();

    ArrayList<ProductDetails> productDetails = new ArrayList<ProductDetails>();

    int [] images1 = {R.drawable.tv2,R.drawable.tv3,R.drawable.tv4,R.drawable.tv5,R.drawable.tv6,R.drawable.tv7};

    ProductDetailsAdapter productDetailsAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater,
                             @Nullable  ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage,container,false);

        /*images2.add(R.drawable.category1);
        images2.add(R.drawable.category2);
        images2.add(R.drawable.category3);
        images2.add(R.drawable.category5);
        images2.add(R.drawable.category6);
        images2.add(R.drawable.category8);
        images2.add(R.drawable.category9);
        images2.add(R.drawable.category10);

        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");
        productname.add("Home&Furniture");*/


        productDetails.add(new ProductDetails(R.drawable.category1,"Home&Furniture"));
        productDetails.add(new ProductDetails(R.drawable.category2,"Mobile&TabLets"));
        productDetails.add(new ProductDetails(R.drawable.category3,"Home&Furniture"));
        productDetails.add(new ProductDetails(R.drawable.category5,"Home&Furniture"));
        productDetails.add(new ProductDetails(R.drawable.category6,"Home&Furniture"));
        productDetails.add(new ProductDetails(R.drawable.category8,"Television"));
        productDetails.add(new ProductDetails(R.drawable.category9,"Home&Furniture"));
        productDetails.add(new ProductDetails(R.drawable.category10,"Home&Furniture"));



        viewPager = view.findViewById(R.id.viewPager);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView1 = view.findViewById(R.id.recycler1);
        recyclerView2 = view.findViewById(R.id.recycler2);
        img_Back = view.findViewById(R.id.img_Back);

        img_Back.setVisibility(View.GONE);

        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        mobilesAndTabletsAdapter = new MobilesAndTabletsAdapter(getContext(), images);
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (mobilesAndTabletsAdapter);


        linearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        televisionssmarttvAdapter = new TELEVISIONSSMARTTVAdapter(getContext(), images1);
        recyclerView1.setLayoutManager (linearLayoutManager1);
        recyclerView1.setHasFixedSize (true);
        recyclerView1.setAdapter (televisionssmarttvAdapter);

        linearLayoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        productDetailsAdapter = new ProductDetailsAdapter(getContext(), productDetails,this);
        recyclerView2.setLayoutManager (linearLayoutManager2);
        recyclerView2.setHasFixedSize (true);
        recyclerView2.setAdapter (productDetailsAdapter);

        createViewPager();

        return view;
    }

    public void createViewPager() {


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();

        ScrollViewpager();
    }

    public void ScrollViewpager(){

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(getContext(), productDetails.get(position).toString(), Toast.LENGTH_SHORT).show();

        Log.d("data",productDetails.get(position).toString());

    }

    @Override
    public void onLongItemClick(int position) {

        productDetails.remove(position);
        productDetailsAdapter.notifyItemRemoved(position);

        Toast.makeText(getContext(), productDetails.get(position).toString(), Toast.LENGTH_SHORT).show();

    }
}
