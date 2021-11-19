package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;
    ImageView ivClockHand;
    Animation rounding;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        ivClockHand = findViewById(R.id.iv_clock_hand);
        timer = findViewById(R.id.timer);

        // create optional animation
        btnStop.setAlpha(0);

        // load animation
        rounding = AnimationUtils.loadAnimation(this, R.anim.anim_rounding);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivClockHand.startAnimation(rounding);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                // start time
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();


                btnStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // ending animation
                        ivClockHand.clearAnimation();
                        btnStart.animate().alpha(1).setDuration(300).start();

                        // ending timer
                        timer.stop();
                    }
                });

            }
        });

    }
}