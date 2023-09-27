package com.example.project;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DirectionActivity extends AppCompatActivity {
    String[] directions = {"Above", "Behind", "Below", "Between", "In", "In front of", "Next to", "On", "On the left", "On the right","Opposite","Under"};
    int[] image_array = {R.drawable.above, R.drawable.behind, R.drawable.below, R.drawable.between, R.drawable.in, R.drawable.in_front_of, R.drawable.next_to, R.drawable.on, R.drawable.on_the_left, R.drawable.on_the_right, R.drawable.opposite, R.drawable.under};
    TextView direction_text;
    Button nextButton;
    ImageView directionImage;
    int currentIndex = 0;
    int score;
    TextView scoreTextView;
    Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        direction_text = findViewById(R.id.direction_text);
        nextButton = findViewById(R.id.direction_next_button);
        directionImage = findViewById(R.id.direction_views);
        scoreTextView = findViewById(R.id.scoreTextView);
        score = 0;
        checkButton = findViewById(R.id.direction_check_button);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < directions.length; i++) {
            builder.append(directions[i]);
            if (i != directions.length - 1) {
                builder.append(" - ");
            }
        }
        String result = builder.toString();
        direction_text.setText(result);
        directionImage.setImageResource(image_array[currentIndex]);
        scoreTextView.setText("Score: " + score);
    }

    public void click_direction_next(View view) {
        if (currentIndex < image_array.length - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        directionImage.setImageResource(image_array[currentIndex]);
        checkButton.setEnabled(true);
    }

    public void click_direction_check(View view) {
        EditText inputText = findViewById(R.id.answer_directions);
        String userInput = inputText.getText().toString();

        if (userInput.equals(directions[currentIndex])) {
            Toast.makeText(this, "Congratulations! Correct Answer!", Toast.LENGTH_SHORT).show();
            score++;
            scoreTextView.setText("Score: " + score);
            checkButton.setEnabled(false);
        } else {
            Toast.makeText(this, "Wrong Answer! Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
