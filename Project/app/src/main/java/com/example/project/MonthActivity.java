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

public class MonthActivity extends AppCompatActivity {

    private TextView monthTextView;
    private TextView questionTextView;
    private RadioGroup optionGroup;
    private Button submitBtn;
    private TextView scoreTextView;

    private String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int currentMonthIndex = 0;
    private int correctAnswerIndex;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);

        monthTextView = findViewById(R.id.monthTextView);
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
            String correctAnswer = monthsOfYear[currentMonthIndex + 1];
            if (selectedAnswer.equals(correctAnswer)) {
                Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
                score++;
                scoreTextView.setText("Score: " + score);
                currentMonthIndex++;
                if (currentMonthIndex < monthsOfYear.length - 1) {
                    setQuestion();
                } else {
                    monthTextView.setText("Congratulations, you've learned all the months!");
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
        if (currentMonthIndex >= monthsOfYear.length - 1) {
            monthTextView.setText("Congratulations, you've learned all the months!");
            questionTextView.setVisibility(View.GONE);
            optionGroup.setVisibility(View.GONE);
            submitBtn.setVisibility(View.GONE);
            return;
        }

        monthTextView.setText(monthsOfYear[currentMonthIndex]);
        questionTextView.setText("What is the next month?");
        optionGroup.clearCheck();

        correctAnswerIndex = new Random().nextInt(4);
        RadioButton correctOption = (RadioButton) optionGroup.getChildAt(correctAnswerIndex);
        correctOption.setText(monthsOfYear[currentMonthIndex + 1]);

        int wrongOptionIndex = 0;
        for (int i = 0; i < optionGroup.getChildCount(); i++) {
            if (i != correctAnswerIndex) {
                RadioButton wrongOption = (RadioButton) optionGroup.getChildAt(i);
                int index = currentMonthIndex + 2 + wrongOptionIndex;
                if (index >= monthsOfYear.length) {
                    index %= monthsOfYear.length;
                }
                wrongOption.setText(monthsOfYear[index]);
                wrongOptionIndex++;
            }
        }

    }


}