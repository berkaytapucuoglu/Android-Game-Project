package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SimilarPicture extends AppCompatActivity {
    int[] fourth_array = {R.drawable.car1, R.drawable.dog2, R.drawable.vegetable3};
    int[] main_pictureArray = {R.drawable.motorcycle_main, R.drawable.cat_main, R.drawable.main_fruit};
    int[] first_option = {R.drawable.motorcycle4, R.drawable.dog1, R.drawable.vegetable1};
    int[] second_option = {R.drawable.car2, R.drawable.cat4, R.drawable.vegetable2};
    int[] third_option = {R.drawable.car3, R.drawable.dog3, R.drawable.fruit4};

    ImageView main_image;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    Button next_picture_button;
    TextView answer_text;
    TextView score_text;

    int currentIndex = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_picture);
        main_image = findViewById(R.id.main_picture);
        image1 = findViewById(R.id.picture1);
        image2 = findViewById(R.id.picture2);
        image3 = findViewById(R.id.picture3);
        image4 = findViewById(R.id.picture4);
        next_picture_button = findViewById(R.id.picture_next_button);
        answer_text = findViewById(R.id.answer_text);
        score_text = findViewById(R.id.score_text);

        main_image.setImageResource(main_pictureArray[currentIndex]);
        image1.setImageResource(first_option[currentIndex]);
        image2.setImageResource(second_option[currentIndex]);
        image3.setImageResource(third_option[currentIndex]);
        image4.setImageResource(fourth_array[currentIndex]);

        main_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image4.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void click_next_picture_button(View view) {
        if (currentIndex < main_pictureArray.length - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        main_image.setImageResource(main_pictureArray[currentIndex]);
        image1.setImageResource(first_option[currentIndex]);
        image2.setImageResource(second_option[currentIndex]);
        image3.setImageResource(third_option[currentIndex]);
        image4.setImageResource(fourth_array[currentIndex]);
        answer_text.setText(" ");
        score_text.setText("Score: " + score);
    }

    public void picture1_click(View view) {
        checkAnswer(0);
    }

    public void picture2_click(View view) {
        checkAnswer(1);
    }

    public void picture3_click(View view) {
        checkAnswer(2);
    }

    public void picture4_click(View view) {
        checkAnswer(3);
    }

    private void checkAnswer(int selectedOption) {
        if (currentIndex == selectedOption) {
            answer_text.setTextColor(Color.GREEN);
            answer_text.setText("Correct Picture!");
            score++;
        } else {
            answer_text.setTextColor(Color.RED);
            answer_text.setText("Wrong Picture");
        }
        score_text.setText("Score: " + score); //
    }
}
