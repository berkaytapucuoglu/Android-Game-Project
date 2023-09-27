package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Clock_activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView clockText;
    private RadioGroup radioGroup;
    private Button nextButton;
    private TextView scoreText;

    private int score = 0;
    private int currentQuestionIndex = 0;
    private int[] analogClockImages = {
            R.drawable.clock1,
            R.drawable.clock2,
            R.drawable.clock3
    };
    private String[][] answerOptions = {
            {"03:00", "04:00", "05:00", "06:00"},
            {"03:00", "03:15", "03:30", "03:45"},
            {"03:00", "03:15", "03:25", "03:30"}
    };
    private String[] correctAnswers = {"03:00", "03:45", "03:25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        imageView = findViewById(R.id.imageView);
        clockText = findViewById(R.id.clockText);
        radioGroup = findViewById(R.id.radioGroup);
        nextButton = findViewById(R.id.nextButton);
        scoreText = findViewById(R.id.scoreText);

        scoreText.setText("Score: " + score);

        showQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void showQuestion() {
        imageView.setImageResource(analogClockImages[currentQuestionIndex]);
        clockText.setText("Please tick the time you see on the screen.");

        radioGroup.removeAllViews();

        for (int i = 0; i < answerOptions[currentQuestionIndex].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setText(answerOptions[currentQuestionIndex][i]);
            radioGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                score++;
                scoreText.setText("Score: " + score);
                currentQuestionIndex++;
                if (currentQuestionIndex < analogClockImages.length) {
                    showQuestion();
                } else {
                    Toast.makeText(this, "All questions are completed.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Wrong Answer. Try Again!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select an option.", Toast.LENGTH_SHORT).show();
        }
    }
}