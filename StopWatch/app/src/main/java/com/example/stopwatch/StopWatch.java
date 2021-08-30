package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {
    Button btn_start,btn_stop ;
    ImageView inchor ;
    Animation Long;
    Chronometer time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btn_start = findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
        inchor = findViewById(R.id.anchor);
        time = findViewById(R.id.meter);

        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        btn_start.setTypeface(MMedium);
        btn_stop.setTypeface(MMedium);
        btn_stop.setVisibility(View.GONE);
        // load Animtions
        Long = AnimationUtils.loadAnimation(this,R.anim.long_anchor);
    btn_start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inchor.startAnimation(Long);
            btn_stop.animate().alpha(1).translationY(300).setDuration(500).start();
            btn_start.animate().setDuration(300).start();
            time.animate().translationY(300).setDuration(500).start();
            btn_start.setVisibility(View.GONE);
            btn_stop.setVisibility(View.VISIBLE);
            time.setBase(SystemClock.elapsedRealtime());
            time.start();

        }
    });
    btn_stop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inchor.getAnimation().cancel();
            inchor.clearAnimation();
            btn_start.setVisibility(View.VISIBLE);
            btn_stop.setVisibility(View.GONE);
            time.animate().translationY(-5).setDuration(500).start();
            time.stop();
        }
    });
    }
}