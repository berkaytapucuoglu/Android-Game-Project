package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SpellingActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText editText;
    private Button checkButton;
    private Button nextButton;
    private TextView scoreTextView;

    private int currentImageIndex = 0;
    private int[] imageArray = {
            R.drawable.banana,
            R.drawable.car1,
            R.drawable.rose
    };
    private String[] correctAnswers = {"Banana", "Car", "Rose"};
    private int score = 0;
    private boolean answerChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelling);

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        checkButton = findViewById(R.id.check_button);
        nextButton = findViewById(R.id.next_button);
        scoreTextView = findViewById(R.id.scoreTextView);

        showImage();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage();
            }
        });
    }

    private void showImage() {
        imageView.setImageResource(imageArray[currentImageIndex]);
        editText.setText("");
        answerChecked = false;
    }

    private void showNextImage() {
        currentImageIndex++;
        if (currentImageIndex < imageArray.length) {
            showImage();
        } else {
            Toast.makeText(this, "All images completed.", Toast.LENGTH_SHORT).show();
            currentImageIndex = 0;
            showImage();
            finish(); // Finish the activity
        }
    }

    private void checkAnswer() {
        if (answerChecked) {
            Toast.makeText(this, "You have already checked the answer.", Toast.LENGTH_SHORT).show();
            return;
        }

        String userAnswer = editText.getText().toString().trim();

        if (userAnswer.equalsIgnoreCase(correctAnswers[currentImageIndex])) {
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
            score++;
            scoreTextView.setText("Score: " + score);
        } else {
            Toast.makeText(this, "Wrong answer, try again!", Toast.LENGTH_SHORT).show();
        }

        answerChecked = true;
    }
}
