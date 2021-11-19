package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSubSplash;
    Button btnGet;
    Animation anim_splash;
    Animation anim_text;
    Animation anim_button;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnGet = findViewById(R.id.btnGet);
        ivSplash = findViewById(R.id.ivSplash);

        // load animation
        anim_splash = AnimationUtils.loadAnimation(this, R.anim.anim_image);
        anim_text = AnimationUtils.loadAnimation(this, R.anim.anim_text_up);
        anim_button = AnimationUtils.loadAnimation(this, R.anim.anim_button_up);

        // passing animation
        ivSplash.startAnimation(anim_splash);
        tvSplash.startAnimation(anim_text);
        tvSubSplash.startAnimation(anim_text);
        btnGet.startAnimation(anim_button);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, StopwatchActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }
}