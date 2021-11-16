package com.example.jazponlineshoping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jazponlineshoping.activity.OTPVerifactionPage;
import com.example.jazponlineshoping.R;

public class SignInPage extends Fragment {

    Button btn_Continue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signinpage,container,false);

        btn_Continue = view.findViewById(R.id.btn_Continue);

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), OTPVerifactionPage.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
