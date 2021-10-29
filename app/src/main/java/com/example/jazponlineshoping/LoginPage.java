package com.example.jazponlineshoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    TextView text_Signin,text_Signup;
    ImageView img_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        text_Signin = findViewById(R.id.signin);
        text_Signup = findViewById(R.id.signup);
        img_Back = findViewById(R.id.img_Back);

        text_Signin.setBackgroundResource(R.drawable.loginstock);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        SignInPage signinpage = new SignInPage();
        ft.replace(R.id.frame, signinpage,"testID");
        ft.commit();

        text_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_Signup.setBackgroundResource(R.drawable.loginstock);
                text_Signin.setBackgroundResource(R.drawable.loginstock1);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SignUpPage signuppage = new SignUpPage();
                ft.replace(R.id.frame, signuppage);
                ft.commit();


            }
        });

        text_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_Signin.setBackgroundResource(R.drawable.loginstock);
                text_Signup.setBackgroundResource(R.drawable.loginstock1);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SignInPage signinpage = new SignInPage();
                ft.replace(R.id.frame, signinpage,"testID");
                ft.commit();

            }
        });

        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}