package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.O;
import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
     TextView tv_health , tv_sub;
     Button btn ;
     Animation atg , atgone , atgtwo ;
     ImageView SplachTv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_health = findViewById(R.id.tv_health);
        tv_sub = findViewById(R.id.tv_sub);
        btn = findViewById(R.id.btn);
        SplachTv = findViewById(R.id.SplachTv);
        //Import fonts
        Typeface Mlight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        //customize font
        tv_health.setTypeface(MRegular);
        tv_sub.setTypeface(Mlight);
        btn.setTypeface(MMedium);
        //Load Animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo = AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgone = AnimationUtils.loadAnimation(this, R.anim.atgone);

        //Set Animation
        SplachTv.startAnimation(atg);
        tv_health.startAnimation(atgone);
        tv_sub.startAnimation(atgone);
        btn.startAnimation(atgtwo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Go = new Intent(MainActivity.this, StopWatch.class);
                Go.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(Go);
            }
        });
    }
}