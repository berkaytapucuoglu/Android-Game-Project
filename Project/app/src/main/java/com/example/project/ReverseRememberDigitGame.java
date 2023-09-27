package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ReverseRememberDigitGame extends AppCompatActivity {
    private Random random = new Random();
    private int[] randomDigits = new int[10];
    private TextView randomDigitText;
    private EditText userInput;
    private Button nextButton;
    private Button checkButton;
    private TextView descriptionText;
    private TextView description2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_remember_digit_game);

        randomDigitText = findViewById(R.id.reverse_random_digits);
        userInput = findViewById(R.id.reverse_user_digit);
        nextButton = findViewById(R.id.reverse_next_button);
        checkButton = findViewById(R.id.reverse_check_button);
        descriptionText = findViewById(R.id.reverse_description_text);
        description2Text = findViewById(R.id.reverse_description2_text);

        generateRandomDigits();

        StringBuilder sb = new StringBuilder();
        for (int digit : randomDigits) {
            sb.append(digit).append(" ");
        }
        randomDigitText.setText(sb.toString());
    }

    private void generateRandomDigits() {
        for (int i = 0; i < 10; i++) {
            randomDigits[i] = random.nextInt(10);
        }
    }

    public void reverse_next_click(View view) {
        randomDigitText.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        userInput.setVisibility(View.VISIBLE);
        checkButton.setVisibility(View.VISIBLE);
        descriptionText.setVisibility(View.INVISIBLE);
        description2Text.setVisibility(View.VISIBLE);
    }

    public void reverse_check_click(View view) {
        String inputText = userInput.getText().toString();
        if (inputText.length() != 10) {
            Toast.makeText(ReverseRememberDigitGame.this, "Please enter 10 digits.", Toast.LENGTH_SHORT).show();
            return;
        }

        int[] userDigits = new int[10];
        for (int i = 0; i < 10; i++) {
            char digitChar = inputText.charAt(i);
            if (!Character.isDigit(digitChar)) {
                Toast.makeText(ReverseRememberDigitGame.this, "Invalid digit: " + digitChar, Toast.LENGTH_SHORT).show();
                return;
            }
            userDigits[i] = Character.getNumericValue(digitChar);
        }

        boolean isSuccess = true;
        for (int i = 0; i < 10; i++) {
            if (userDigits[i] != randomDigits[9 - i]) {
                isSuccess = false;
                break;
            }
        }

        if (isSuccess) {
            Toast.makeText(ReverseRememberDigitGame.this, "Congratulations! The numbers you entered are correct.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ReverseRememberDigitGame.this, "Sorry, the numbers you entered are incorrect.", Toast.LENGTH_SHORT).show();
        }
    }
}
