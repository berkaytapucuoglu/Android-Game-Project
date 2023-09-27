package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MovingBall extends AppCompatActivity {
    private ImageView red_ball_image;
    private int screenWidth;
    private int screenHeight;
    private int imageWidth;
    private int imageHeight;
    private float ballX;
    private float ballY;
    private float velocityX;
    private float velocityY;
    private final float MAX_VELOCITY = 7;

    private int currentRow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_ball);
        red_ball_image = findViewById(R.id.red_ball_image);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        red_ball_image.post(new Runnable() {
            @Override
            public void run() {
                imageWidth = red_ball_image.getWidth();
                imageHeight = red_ball_image.getHeight();
                initializeBall();
                moveBall();
            }
        });
    }

    private void initializeBall() {
        ballX = 0;
        ballY = currentRow * imageHeight;

        velocityX = MAX_VELOCITY;
        velocityY = 0;

        red_ball_image.setX(ballX);
        red_ball_image.setY(ballY);
    }

    private void moveBall() {
        final long FRAME_DURATION = 16;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ballX += velocityX;

                if (ballX > screenWidth) {
                    ballX = 0;
                    ballY += imageHeight;
                    currentRow++;
                    if (currentRow * imageHeight > screenHeight - imageHeight) {
                        currentRow = 0;
                        ballY = 0;
                    }
                }

                red_ball_image.setX(ballX);
                red_ball_image.setY(ballY);

                moveBall();
            }
        }, FRAME_DURATION);
    }
}