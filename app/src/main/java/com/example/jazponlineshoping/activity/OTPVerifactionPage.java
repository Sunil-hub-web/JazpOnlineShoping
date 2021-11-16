package com.example.jazponlineshoping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazponlineshoping.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OTPVerifactionPage extends AppCompatActivity {

    TextView text_Timer,text_Changenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifaction_page);

        text_Timer = findViewById(R.id.timer);
        text_Changenumber = findViewById(R.id.text_Changenumber);

        timer();

        text_Changenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OTPVerifactionPage.this,LoginPage.class);
                startActivity(intent);
            }
        });

    }

    public void timer(){

        //Initialize time duration
        long duration = TimeUnit.MINUTES.toMillis(1);
        //Initialize countdown timer

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                //When tick
                //Convert millisecond to minute and second

                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                text_Timer.setText(sDuration);

            }

            @Override
            public void onFinish() {

                text_Timer.setVisibility(View.GONE);

                Toast.makeText(OTPVerifactionPage.this, "Countdown timer has ended", Toast.LENGTH_SHORT).show();

            }
        }.start();
    }
}