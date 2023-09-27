package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class main_menu extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void clock_view(View view) {
        Log.d(LOG_TAG,"Clock View Successful");
        Intent intent= new Intent(this,Clock_activity.class);
        startActivity(intent);
    }


    public void season_view(View view) {
        Log.d(LOG_TAG,"Season View Successful");
        Intent intent= new Intent(this,SeasonActivity.class);
        startActivity(intent);
    }

    public void days_view(View view) {
        Log.d(LOG_TAG,"Days View Successful");
        Intent intent= new Intent(this,DaysActivity.class);
        startActivity(intent);
    }

    public void months_view(View view){
        Log.d(LOG_TAG,"Months View Successful");
        Intent intent= new Intent(this,MonthActivity.class);
        startActivity(intent);
    }

    public void remember_digit_view(View view) {
        Log.d(LOG_TAG,"Remember Digit View Successful");
        Intent intent= new Intent(this,RememberDigitGame.class);
        startActivity(intent);
    }

    public void reverse_remember_digit_view(View view) {
        Log.d(LOG_TAG,"Reverse Remember Digit View Successful");
        Intent intent= new Intent(this,ReverseRememberDigitGame.class);
        startActivity(intent);
    }

    public void spelling_view(View view) {
        Log.d(LOG_TAG,"Spelling View Successful");
        Intent intent= new Intent(this,SpellingActivity.class);
        startActivity(intent);
    }

    public void directions_view(View view) {
        Log.d(LOG_TAG,"Direction View Successful");
        Intent intent= new Intent(this,DirectionActivity.class);
        startActivity(intent);
    }
    public void multiplication_view(View view) {
        Log.d(LOG_TAG,"Multiplication View Successful");
        Intent intent= new Intent(this,MultiplicationActivity.class);
        startActivity(intent);
    }
    public void similar_picture_view(View view) {
        Log.d(LOG_TAG,"Similar Picture View Successful");
        Intent intent= new Intent(this,SimilarPicture.class);
        startActivity(intent);
    }
    public void moving_ball_view(View view) {
        Log.d(LOG_TAG,"Moving Ball View Successful");
        Intent intent= new Intent(this,MovingBall.class);
        startActivity(intent);
    }
}