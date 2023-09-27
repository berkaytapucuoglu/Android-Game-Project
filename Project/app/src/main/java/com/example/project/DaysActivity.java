package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DaysActivity extends AppCompatActivity {

    private TextView dayTextView;
    private TextView questionTextView;
    private RadioGroup optionGroup;
    private Button submitBtn;
    private TextView scoreTextView;

    private String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int currentDayIndex = 0;
    private int correctAnswerIndex;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

        dayTextView = findViewById(R.id.dayTextView);
        questionTextView = findViewById(R.id.questionTextView);
        optionGroup = findViewById(R.id.optionGroup);
        submitBtn = findViewById(R.id.submitBtn);
        scoreTextView = findViewById(R.id.scoreTextView);

        setQuestion();
    }

    public void submitAnswer(View view) {
        int selectedOptionId = optionGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedOption = findViewById(selectedOptionId);
            String selectedAnswer = selectedOption.getText().toString();
            String correctAnswer = daysOfWeek[currentDayIndex + 1];
            if (selectedAnswer.equals(correctAnswer)) {
                Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
                score++;
                scoreTextView.setText("Score: " + score);
                currentDayIndex++;
                if (currentDayIndex < daysOfWeek.length - 1) {
                    setQuestion();
                } else {
                    dayTextView.setText("Congratulations, you've learned all the days!");
                    questionTextView.setVisibility(View.GONE);
                    optionGroup.setVisibility(View.GONE);
                    submitBtn.setVisibility(View.GONE);
                }
            } else {
                Toast.makeText(this, "Wrong answer, try again!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select an option!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setQuestion() {
        if (currentDayIndex >= daysOfWeek.length - 1) {
            dayTextView.setText("Congratulations, you've learned all the days!");
            questionTextView.setVisibility(View.GONE);
            optionGroup.setVisibility(View.GONE);
            submitBtn.setVisibility(View.GONE);
            return;
        }

        dayTextView.setText(daysOfWeek[currentDayIndex]);
        questionTextView.setText("What is the next day?");
        optionGroup.clearCheck();

        correctAnswerIndex = new Random().nextInt(4);
        RadioButton correctOption = (RadioButton) optionGroup.getChildAt(correctAnswerIndex);
        correctOption.setText(daysOfWeek[currentDayIndex + 1]);

        int wrongOptionIndex = 0;
        for (int i = 0; i < optionGroup.getChildCount(); i++) {
            if (i != correctAnswerIndex) {
                RadioButton wrongOption = (RadioButton) optionGroup.getChildAt(i);
                if (currentDayIndex + 2 + wrongOptionIndex < daysOfWeek.length) {
                    wrongOption.setText(daysOfWeek[currentDayIndex + 2 + wrongOptionIndex]);
                    wrongOptionIndex++;
                }
            }
        }
    }
}
