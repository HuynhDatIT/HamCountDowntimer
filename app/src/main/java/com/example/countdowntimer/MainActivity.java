package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView mImgView;
Button mBtnStart;

int mImgArray[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};
int mindex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgView = findViewById(R.id.imageBanner);
        mBtnStart = findViewById(R.id.buttonBanner);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(1200, 1000) {
                    @Override
                    public void onTick(long l) {
                        if(mindex >= mImgArray.length){
                            mindex = 0;
                        }
                        if(l >= 1000){
                            mImgView.setImageResource(mImgArray[mindex]);
                            mindex++;
                        }
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                    }
                };
                countDownTimer.start();
            }
        });

    }
}