package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SeasonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);

        Button buttonSpring=findViewById(R.id.spring_button);
        buttonSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView=findViewById(R.id.spring);
                Drawable drawable=imageView.getDrawable();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    if (drawable instanceof AnimatedImageDrawable) {
                        AnimatedImageDrawable animatedDrawable = (AnimatedImageDrawable) drawable;
                        if (animatedDrawable.isRunning()) {
                            animatedDrawable.stop();
                        } else {
                            animatedDrawable.start();
                        }
                    }
                }
            }

        });
        Button buttonAutumn=findViewById(R.id.autumn_button);
        buttonAutumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView=findViewById(R.id.autumn);
                Drawable drawable=imageView.getDrawable();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    if (drawable instanceof AnimatedImageDrawable) {
                        AnimatedImageDrawable animatedDrawable = (AnimatedImageDrawable) drawable;
                        if (animatedDrawable.isRunning()) {
                            animatedDrawable.stop();
                        } else {
                            animatedDrawable.start();
                        }
                    }
                }
            }

        });
        Button buttonWinter=findViewById(R.id.winter_button);
        buttonWinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView=findViewById(R.id.winter);
                Drawable drawable=imageView.getDrawable();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    if (drawable instanceof AnimatedImageDrawable) {
                        AnimatedImageDrawable animatedDrawable = (AnimatedImageDrawable) drawable;
                        if (animatedDrawable.isRunning()) {
                            animatedDrawable.stop();
                        } else {
                            animatedDrawable.start();
                        }
                    }
                }
            }
        });
        Button buttonSummer=findViewById(R.id.summer_button);
        buttonSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView=findViewById(R.id.summer);
                Drawable drawable=imageView.getDrawable();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    if (drawable instanceof AnimatedImageDrawable) {
                        AnimatedImageDrawable animatedDrawable = (AnimatedImageDrawable) drawable;
                        if (animatedDrawable.isRunning()) {
                            animatedDrawable.stop();
                        } else {
                            animatedDrawable.start();
                        }
                    }
                }
            }
        });
    }






}